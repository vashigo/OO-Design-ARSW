/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.tarea2.calculator;

import java.util.List;

/**
 *
 * @author vashi
 */
public class Calculator {

    public interface IntegerMath {

        int operation(int a, int b);
    }

    public interface DoubleMath {

        double operation(List<Double> ld);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public double operateBinary(List<Double> a, DoubleMath op) {
        return op.operation(a);
    }

}
