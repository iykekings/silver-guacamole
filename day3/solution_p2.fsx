open System.IO

let bin a = System.Convert.ToInt32(a, 2)

let selectNext cs (fn: float -> float -> bool) =
    let count = cs |> Seq.filter ((=) '1') |> Seq.length

    let isOne =
        fn (float count) (cs |> Seq.length |> (fun a -> float a / 2.0))

    if isOne then '1' else '0'

let foldRec (fn: float -> float -> bool) (ss: seq<string>) =
    let rec foldRec' (xs: seq<string>) (i: int) =
        if Seq.length xs = 1 then
            xs
        else
            let sel =
                selectNext (xs |> Seq.map (fun x -> Seq.item i x)) fn

            let selected =
                Seq.filter (fun a -> (a |> Seq.item i) = sel) xs

            foldRec' selected (i + 1)

    Seq.head (foldRec' ss 0)

let solution path =
    let file = File.ReadLines path
    let m = file |> foldRec ((>=))
    let n = file |> foldRec ((<))
    bin m * bin n

solution "./input.txt" |> printfn "%A"
