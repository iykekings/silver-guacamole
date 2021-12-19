module Solution =
    open System.IO

    let parseMove (a: string) : int * int =
        match a.Split [| ' ' |] with
        | [| dir; mag |] ->
            match dir with
            | "forward" -> (0, int mag)
            | "down" -> (int mag, 0)
            | _ -> (-(int mag), 0)
        | _ -> (0, 0)

    let solution =
        File.ReadLines("../input.txt")
        |> Seq.map parseMove
        |> Seq.fold (fun (x, y) (a, b) -> (x + a, y + b)) (0, 0)
        |> fun (a, b) -> a * b


    solution |> printfn "%d"
