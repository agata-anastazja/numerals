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

(def scales
  {100 "hundred"
   1000 "thousand"
   1000000 "million"})

(defn get-quotient [dividend divisor]
  (int (/ dividend divisor)))

(defn read-single-digit [digits]
  (get digit-names digits))

(defn read-two-digit-number [digits]
  (let [teen (get teen-names digits)
        multiplication-of-ten (get multiplication-of-ten-names digits)]
    (if (or teen multiplication-of-ten)
      (or teen multiplication-of-ten)
      (let [ multiplication-of-ten-part-in-digits  (* 10 (get-quotient digits 10))
            multiplication-of-ten-part (get multiplication-of-ten-names multiplication-of-ten-part-in-digits)
            remainder (read-single-digit (- digits multiplication-of-ten-part-in-digits))]
        (str multiplication-of-ten-part " " remainder)))))


(defn parse-hundreds [digits]
  (loop [remaining-digits digits
         accumulator ""]
    (let [length (count (str remaining-digits))]
      (case length
        1 (str accumulator (read-single-digit remaining-digits))
        2 (str accumulator (read-two-digit-number remaining-digits))
        3 (let [quotient-of-hundred (get-quotient remaining-digits 100)
                multiplication-of-hundred (* 100 quotient-of-hundred)
                remainder (- remaining-digits multiplication-of-hundred)
                three-digit-number-in-words (str (get digit-names quotient-of-hundred) " hundred")]
            (if (not (zero? remainder))
                (recur remainder
                         (str accumulator (str three-digit-number-in-words " and ")))
                (str accumulator three-digit-number-in-words)))
        ;4 (let [quotient-of-thousand (get-quotient remaining-digits 1000)
        ;        multiplication-of-hundred (* 1000 quotient-of-thousand)
        ;        remainder (- remaining-digits multiplication-of-hundred)
        ;        four-digit-number-in-words (str (get digit-names quotient-of-thousand) " thousand")]
        ;    (if (not (zero? remainder))
        ;      (recur remainder
        ;             (str four-digit-number-in-words " and "))
        ;      four-digit-number-in-words))
        ;5 (let [quotient-of-thousand (get-quotient remaining-digits 1000)
        ;        multiplication-of-hundred (* 1000 quotient-of-thousand)
        ;        remainder (- remaining-digits multiplication-of-hundred)]
        ;    (if (not (zero? remainder))
        ;      (recur remainder
        ;             (str " and "))
        ;      (recur )))
        ))))

(defn parse-thousands [digits]
  (let [quotient-of-thousand (get-quotient digits 1000)]
    (if (= 0 quotient-of-thousand)
      ""
      (str (parse-hundreds quotient-of-thousand) " thousand "))))

(defn add-and [digits]
  (if (and (and (> digits 1000) (> (mod digits 100) 0)) (= 0 (get-quotient (- digits (* 1000 (get-quotient digits 1000))) 100) ))
    "and "
    ""))

(defn parse-digits-to-words [digits]
  (let [thousands (parse-thousands digits)
        and (add-and digits)
        hundreds  (parse-hundreds (mod digits 1000 ))]
      (str thousands and hundreds)
   ))



(defn -main
  [& digits]
  (parse-digits-to-words (first digits)))
