main' = do
  xs <- map (read :: String -> Int) . lines <$> readFile "input"
  let ys = zipWith3 (\a b c -> a + b + c) xs (tail xs) (tail (tail xs))
  print . length $ filter (True ==) $ zipWith (<) ys $ tail ys
