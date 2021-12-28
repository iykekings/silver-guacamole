import Data.Char (digitToInt)
import Data.List (foldl')

toDec :: String -> Int
toDec = foldl' (\acc x -> acc * 2 + digitToInt x) 0

folder xs ys = zipWith (+) xs $ toInt ys

toInt = map $ (read :: String -> Int) . (: [])

solution path = do
  f <- lines <$> readFile path
  let m = foldl folder [0 | _ <- [0 .. (length $ head f)]] f
  let n = map (\a -> if a > length f `div` 2 then '1' else '0') m
  let rev = map (\a -> if a == '0' then '1' else '0') n
  print $ show $ toDec n * toDec rev