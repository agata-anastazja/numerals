(ns numerals.core-test
  (:require [clojure.test :refer :all]
            [numerals.core :refer :all]))

(deftest the-application-parses-single-digits
  (testing "return zero when passed 0"
    (is (= "zero" (-main (Integer/valueOf 0)))))

  (testing "return one when passed 1"
    (is (= "one" (-main (Integer/valueOf 1)))))

  (testing "return one when passed 2"
    (is (= "two" (-main (Integer/valueOf 2))))))


(deftest the-application-parses-double-digits
  (testing "return ten when passed 10"
    (is (= "ten" (-main (Integer/valueOf 10)))))

  (testing "return eleven when passed 11"
    (is (= "eleven" (-main (Integer/valueOf 11)))))

  (testing "return twenty one when passed 21"
    (is (= "twenty one" (-main (Integer/valueOf 21)))))

  (testing "return twenty one when passed 22"
    (is (= "twenty two" (-main (Integer/valueOf 22)))))

  (testing "return thirty when passed 30"
    (is (= "thirty" (-main (Integer/valueOf 30)))))
  )



(deftest the-application-parses-three-digits
  (testing "return one hundred and five when passed 105"
    (is (= "one hundred and five" (-main (Integer/valueOf 105)))))

  (testing "return one hundred and twenty five when passed 125"
    (is (= "one hundred and twenty five" (-main (Integer/valueOf 125)))))
  )

(deftest the-application-parses-four-digits
  (testing "return one thousand and five when passed 1005"
    (is (= "one thousand and five" (-main (Integer/valueOf 1005)))))

  (testing "return one thousand one hundred and five when passed 1025"
    (is (= "one thousand and twenty five" (-main (Integer/valueOf 1025)))))

  (testing "return one thousand one hundred and five when passed 1125"
    (is (= "one thousand one hundred and twenty five" (-main (Integer/valueOf 1125)))))

  )

(deftest the-application-parses-five-digits
  (testing "return ten thousand and five when passed 10005"
    (is (= "ten thousand and five" (-main (Integer/valueOf 10005)))))

  (testing "return ten thousand one hundred and twenty five when passed 10005"
    (is (= "ten thousand one hundred and twenty five" (-main (Integer/valueOf 10125)))))
  )

(deftest the-application-parses-six-digits
  (testing "return one hundred thousand and five when passed 100005"
    (is (= "one hundred thousand and five" (-main (Integer/valueOf 100005)))))

  (testing "return one hundred thousand and five when passed 100125"
    (is (= "one hundred thousand one hundred and twenty five" (-main (Integer/valueOf 100125)))))
  )

(deftest the-application-parses-millions
  (testing "return fifty six million nine hundred and forty five thousand seven hundred and eighty one when passed 56945781"
    (is (= "fifty six million nine hundred and forty five thousand seven hundred and eighty one" (-main (Integer/valueOf 56945781)))))

  (testing "return fifty six million and forty five thousand seven hundred and eighty one when passed 56045781"
    (is (= "fifty six million and forty five thousand seven hundred and eighty one" (-main (Integer/valueOf 56045781)))))
  
  )
