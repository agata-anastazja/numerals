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

(def number-names
  (merge digit-names
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
   20 "twenty"
  }))


(defn -main
  [digits]

  (loop [remaining-digits digits
         result ""]
    (if (<= remaining-digits 20)
     (str result (get number-names remaining-digits))
     (recur (- remaining-digits 20)
            (str (get number-names (- remaining-digits (- remaining-digits 20)) ) " ")))))
