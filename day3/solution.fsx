open System.IO

let bin a = System.Convert.ToInt32(a, 2)

let count l s = if s > (l / 2) then "1" else "0"

let reverse s =
    s
    |> String.map (fun a -> if a = '1' then '0' else '1')

let folder xs (ys: string) =
    Seq.map2 (+) xs (ys |> Seq.map string |> Seq.map int)

let solution path =
    let file = File.ReadLines path
    let hl = file |> Seq.head |> Seq.length
    let start = [ for _ in 1 .. hl -> 0 ]

    file
    |> Seq.fold folder start
    |> Seq.map (count (file |> Seq.length))
    |> Seq.reduce (+)
    |> (fun a -> bin a * bin (reverse a))

solution "./input.txt" |> printfn "%A"
