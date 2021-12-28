(ns solution-clj.solution-p2
  (:require [clojure.java.io :as io]))

(defn select-next [cs fn]
  (let [count' (count (filter #(= % \1) cs))
        isOne (fn count' (/ (count cs) 2))]
    (if isOne \1 \0)))

(defn foldrec' [ss i fn]
  (case (count ss)
    1 ss
    (let [sel (select-next (map #(nth % i) ss) fn)
          selected (filter #(= (nth % i) sel) ss)]
      (foldrec' selected (+ i 1) fn))))

(defn foldrec [ss fn]
  (first (foldrec' ss 0 fn)))

(defn bin [s] (Integer/parseInt s 2))

(defn solution [path]
  (with-open [rdr (io/reader path)]
    (let [file (doall (line-seq rdr))
          m (foldrec file (partial >=))
          n (foldrec file (partial <))]
      (* (bin m) (bin n)))))

(print (solution "./test.txt"))
(print (solution "./input.txt"))