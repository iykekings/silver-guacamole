(require '[clojure.java.io :as io])
(require '[clojure.string :as string])

(defn parse [x y]
  (case x
    "forward" (list #(+ %1 (* %2 (Integer/parseInt y))) 0 (Integer/parseInt y))
    "down" (list (fn [x _] x) (Integer/parseInt y) 0)
    (list (fn [x _] x) (- (Integer/parseInt y)) 0)))

(defn parseMove [str]
  (apply parse (string/split str #" ")))

(defn sumTuples [acc next]
  (let [[a b c] acc
        [fn' x y] next]
    (list (fn' a b) (+ b x) (+ c y))))

(defn solution []
  (with-open [rdr (io/reader "../input.txt")]
    (->> (line-seq rdr)
         (map parseMove)
         (reduce sumTuples '(0 0 0))
         (apply #(* %1 %3)))))


