package edu.escuelaing.arsw.tarea2.calculator;

import java.util.List;

/**
 * calculator that can receive operations in lambda function operate in
 * Integer or Double
 * 
 * @author vashi
 */
public class Calculator {

    /**
    * interface containing integer operations
    * 
    * @author vashi
    */
    public interface IntegerMath {

        int operation(int a, int b);
    }

    /**
    * interface containing Double operations
    * 
    * @author vashi
    */
    public interface DoubleMath {

        double operation(List<Double> ld);
    }

    /**
    * calculate Integer operations
    * 
    * @author vashi
     * @param a - integer value
     * @param b - integer value
     * @param op - IntegerMath operation
     * @return result operation
    */
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    
    /**
    * calculate Double operations in a list
    * 
    * @author vashi
     * @param a - list of double values
     * @param op - IntegerMath operation
     * @return result operation
    */
    public double operateBinary(List<Double> a, DoubleMath op) {
        return op.operation(a);
    }

}
