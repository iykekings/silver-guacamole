main' = do
  m <- map (read :: String -> Int) . lines <$> readFile "input"
  print . length $ filter (True ==) $ zipWith (<) m $ tail m