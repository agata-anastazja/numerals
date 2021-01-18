(ns numerals.core
  (:gen-class))

(defn -main
  [digit]
  (if (= (int digit) 0) "zero" "one"))
