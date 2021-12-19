parseMove str =
  case words str of
    ["forward", m] -> (0, read m :: Int)
    ["down", m] -> (read m :: Int, 0)
    ["up", m] -> (- read m :: Int, 0)
    _ -> error "couldn't parse string"

sumTuples (a, b) (x, y) = (a + x, b + y)

solution = do
  m <- map parseMove . lines <$> readFile "input.txt"
  let (u, v) = foldr sumTuples (0, 0) m
  print $ show $ u * v
