/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}
