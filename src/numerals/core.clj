(ns numerals.core
  (:gen-class))

(def digit-names
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"}
  )

(def teen-names
  {10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   })

(def multiplication-of-ten-names
  {20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"})

(defn read-single-digit [digits]
  (get digit-names digits))

(defn read-two-digit-number [digits]
  (let [teen (get teen-names digits)
        multiplication-of-ten (get multiplication-of-ten-names digits)
        ]
    (if (or teen multiplication-of-ten)
      (or teen multiplication-of-ten)
      (let [ multiplication-of-ten-part-in-digits  (* 10 (int (/ digits 10)))
            multiplication-of-ten-part (get multiplication-of-ten-names multiplication-of-ten-part-in-digits)
            remainder (read-single-digit (- digits multiplication-of-ten-part-in-digits))]
       (str multiplication-of-ten-part " " remainder)))))

(defn -main
  [digits]
  (let [length (count (str digits))]
    (case length
      1 (read-single-digit digits)
      2 (read-two-digit-number digits))))
