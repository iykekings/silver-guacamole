open System.IO




let solution =
    File.ReadLines("input")
    |> Seq.map int
    |> Seq.windowed 3
    |> Seq.map Seq.sum
    |> Seq.pairwise
    |> Seq.map (fun (f, s) -> f < s)
    |> Seq.filter ((=) true)
    |> Seq.length




solution |> printfn "%d"
