(require '[clojure.java.io :as io])

(defn solution []
  (def m (with-open [rdr (io/reader "input")]
           (mapv #(Integer/parseInt %) (line-seq rdr))))
  (count (filterv true?  (mapv #(< (first %) (second %)) (map list m (rest m))))))

(print (solution))

(defn solution' [] (with-open [rdr (io/reader "input")]
                     (->> (line-seq rdr)
                          (mapv #(Integer/parseInt %))
                          (#(map list % (rest %)))
                          (mapv #(< (first %) (second %)))
                          (filterv true?)
                          (count))))

(print (solution'))