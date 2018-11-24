/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring

import spock.lang.Specification
import static spock.util.matcher.HamcrestSupport.that
import static spock.util.matcher.HamcrestMatchers.closeTo

class CalculatorSpec extends Specification {
    def "Calculator shall be able to calculate sum of two numbers"() {
        given: "a calculator instance"
        def calculator = new Calculator()

        expect: "adding two numbers gives the sum of these numbers"
        that calculator.add(a, b), closeTo(sum, 0.001)

        where: "the input numbers are"
        a    | b   | sum
        1.0  | 2.0 | 3.0
        -1.0 | 1.0 | 0.0
        0.0  | 0.0 | 0.0
    }
}
