(ns numerals.core-test
  (:require [clojure.test :refer :all]
            [numerals.core :refer :all]))

(deftest the-application-translates-single-digits
  (testing "return zero when passed 0"
    (is (= "zero" (-main (Integer/valueOf 0)))))

  (testing "return one when passed 1"
    (is (= "one" (-main (Integer/valueOf 1)))))

  (testing "return one when passed 1"
    (is (= "two" (-main (Integer/valueOf 2))))))


(deftest the-application-translates-double-digits
  (testing "return ten when passed 10"
    (is (= "ten" (-main (Integer/valueOf 10)))))

  (testing "return eleven when passed 11"
    (is (= "eleven" (-main (Integer/valueOf 11)))))

  )
