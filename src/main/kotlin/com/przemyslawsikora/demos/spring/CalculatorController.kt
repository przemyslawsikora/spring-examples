/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("calc")
class CalculatorController(
        private val calculator: Calculator
) {
    @GetMapping("add")
    fun add(
            @RequestParam(value = "a", defaultValue = "0") a: Double,
            @RequestParam(value = "b", defaultValue = "0") b: Double
    ) = calculator.add(a, b)
}
