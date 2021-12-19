module Solution2 =
    open System.IO

    let parseMove (a: string) =
        match a.Split [| ' ' |] with
        | [| dir; mag |] ->
            match dir with
            | "forward" -> ((fun (a, b) -> b * int mag + a), 0, int mag)
            | "down" -> ((fun (a, _) -> a), int mag, 0)
            | _ -> ((fun (a, _) -> a), -(int mag), 0)
        | _ -> failwith "invalid data"

    let sumTuples (a, b, c) (fn, x, y) = (fn (a, b), b + x, c + y)

    let solution =
        File.ReadLines("../input.txt")
        |> Seq.map parseMove
        |> Seq.fold sumTuples (0, 0, 0)
        |> fun (a, _, b) -> a * b


    solution |> printfn "%d"
