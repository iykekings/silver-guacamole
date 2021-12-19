(ns playground)

(require '[clojure.java.io :as io])
(require '[clojure.string :as string])


(defn parse [x y]
  (case x
    "forward" (list 0 (Integer/parseInt y))
    "down" (list (Integer/parseInt y) 0)
    (list (- (Integer/parseInt y)) 0)))

(defn parseMove [str]
  (apply parse (string/split str #" ")))

(defn sumTuples [acc next]
  (list (+ (first acc) (first next)) (+ (second acc) (second next))))

(defn solution []
  (with-open [rdr (io/reader "./input.txt")]
    (->> (line-seq rdr)
         (map parseMove)
         (reduce sumTuples)
         (apply *))))


(print (solution))