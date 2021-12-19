parseMove str =
  let w = words str
      f = head w
      s = read . head $ tail w :: Int
   in case f of
        "forward" -> (\a b -> b * s + a, 0, s)
        "down" -> (const, s, 0)
        _ -> (const, - s, 0)

sumTuples (a, b, c) (fn, x, y) = (fn a b, b + x, c + y)

solution = do
  m <- map parseMove . lines <$> readFile "input.txt"
  let (u, _, v) = foldl sumTuples (0, 0, 0) m
  print $ show $ u * v
