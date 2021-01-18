(ns numerals.core-test
  (:require [clojure.test :refer :all]
            [numerals.core :refer :all]))

(deftest the-application-translates-single-digits
  (testing "return zero when passed 0"

    (is (= "zero" (-main (Integer/valueOf 0))))))
