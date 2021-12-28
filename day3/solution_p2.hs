import Data.Char (digitToInt)

toDec :: String -> Int
toDec = foldl (\acc x -> acc * 2 + digitToInt x) 0

selectNext :: [Char] -> (Double -> Double -> Bool) -> Char
selectNext cs fn = if isOne then '1' else '0'
  where
    count' = length $ filter (== '1') cs
    isOne = fn (fromIntegral count') $ (/) (fromIntegral $ length cs) 2.0

foldRec :: [String] -> (Double -> Double -> Bool) -> String
foldRec ss fn = head $ foldRec' ss 0
  where
    foldRec' :: [String] -> Int -> [String]
    foldRec' [x] _ = [x]
    foldRec' xs i = foldRec' selected $ i + 1
      where
        sel = selectNext (map (!! i) xs) fn
        selected = filter (\a -> a !! i == sel) xs

solution path = do
  f <- lines <$> readFile path
  let m = foldRec f (>=)
  let n = foldRec f (<)
  print $ show $ toDec n * toDec m