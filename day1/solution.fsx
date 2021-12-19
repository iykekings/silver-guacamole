open System.IO

let solution = 
    File.ReadLines("input") |> Seq.map int |> Seq.pairwise
    |> Seq.map (fun e -> fst e < snd e) |> Seq.filter ((=) true) |> Seq.length

solution |> printfn "%d"