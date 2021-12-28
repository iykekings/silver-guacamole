(ns solution-clj.solution
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str]))

(defn folder [xs ys]
  (map + xs
       (map
        #(Integer/parseInt %)
        (str/split ys #""))))

(defn start [num]
  (make-array Integer/TYPE num))

(defn my-reduce [file]
  (reduce folder
          (start (count (first file))) file))

(defn ones [l s]
  (case (> s (/ l 2))
    true "1"
    "0"))

(defn revbin [s]
  (reduce str (map #(case % \1 "0" "1") s)))

(defn bin [s] (Integer/parseInt s 2))


(defn solution [path]
  (with-open [rdr (io/reader path)]
    (let [file (doall (line-seq rdr))]
      (->> (my-reduce file)
           (map (partial ones (count file)))
           (reduce str)
           (#(* (bin %) (bin (revbin %))))))))

(print (solution "./test.txt"))
(print (solution "./input.txt"))