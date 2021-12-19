(require '[clojure.java.io :as io])



(defn solution' [] (with-open [rdr (io/reader "input")]
                     (->> (line-seq rdr)
                          (mapv #(Integer/parseInt %))
                          (partition 3 1)
                          (map #(reduce + %))
                          (partition 2 1)
                          (map #(< (first %) (second %)))
                          (filter true?)
                          (count))))





(print (solution'))