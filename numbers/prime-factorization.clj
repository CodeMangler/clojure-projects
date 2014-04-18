(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn divisible? [number divisor]
  (== (mod number divisor) 0))


(comment

(defn prime? [number]
  (def largest-divisor (Math/floor (Math/sqrt number)))
  (defn is-prime? [number divisor]
    (if (or (> divisor largest-divisor) (<= divisor 1))
      true
      (if (divisible? number divisor)
        false
        (is-prime? number (+ divisor 1)))))
  (is-prime? number 2))

)

(defn prime? [number]
  (def largest-divisor (Math/floor (Math/sqrt number)))
  (loop [n number divisor 2]
    (if (or (> divisor largest-divisor) (<= divisor 1))
      true
      (if (divisible? n divisor)
        false
        (recur number (+ divisor 1))))))


; Turns out, I don't really have to check if a factor is prime this way. All generated factors naturally turn out to be primes. So, all the above functions are redundant
(defn factors [number]
  (loop [n number divisor 2 divisors '()]
    (cond (<= n 1) divisors
          (zero? (rem n divisor)) (recur (/ n divisor) divisor (cons divisor divisors))
          :else (recur n (inc divisor) divisors))))

(defn main []
  (let [n (parse-int (read-line))]
    (println (factors n))))
