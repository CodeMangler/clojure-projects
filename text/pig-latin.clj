; http://en.wikipedia.org/wiki/Pig_Latin

(def pig-latin-parts-matcher #"(.*?)([AaEeIiOoUu].*)")
(def pig-latin-suffix "ay")
(defn pig-latinize [word]
  (let [parts (re-find pig-latin-parts-matcher word)]
    (if (== (count parts) 3)
      (clojure.string/join [(nth parts 2) (nth parts 1) pig-latin-suffix])
      word)))

(def word-boundary-matcher #"\s+")

(defn pig-latin [sentence]
  (map pig-latinize (clojure.string/split sentence word-boundary-matcher)))

(defn main []
  (println (clojure.string/join " " (pig-latin (read-line)))))
