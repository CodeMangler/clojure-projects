(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn fibonacci [n]
  (if (or (== n 0) (== n 1))
    1
    (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

(defn fibonacci-till [limit]
  (defn fibonacci-till-internal [n limit acc]
    (let [fib-n (fibonacci n)]
      (if (< fib-n limit)
        (fibonacci-till-internal (+ n 1) limit (conj acc fib-n))
        acc)))
  (fibonacci-till-internal 0 limit []))

(defn main []
  (let [n (parse-int (read-line))]
    (println (fibonacci-till n))
    (println (fibonacci n))))
