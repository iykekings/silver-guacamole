(require '[clojure.java.io :as io])

(defn solution []
  (with-open [rdr (io/reader "input")]
    (->> (line-seq rdr)
         (mapv #(Integer/parseInt %))
         (#(map list % (rest %)))
         (mapv #(< (first %) (second %)))
         (filterv true?)
         (count))))

(print (solution))