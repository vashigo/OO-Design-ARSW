package edu.escuelaing.arsw.tarea2;

import edu.escuelaing.arsw.tarea2.calculator.Calculator;
import edu.escuelaing.arsw.tarea2.fileReader.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Application to calculate the mean and standard deviation of data in a file 
 *
 * @author vashi
 */
public class App {

    public static void main(String[] args) throws Exception {
        Calculator myApp = new Calculator();
        //preprare mean operation
        Calculator.DoubleMath mean;
        mean = (List<Double> a) -> {
            Double ans = 0.0;
            ans = a.stream().map((n) -> n).reduce(ans, (accumulator, _item) -> accumulator + _item);
            return ans / a.size();
        };

        Calculator.DoubleMath sDeviation;
        //preprare sDeviation operation
        sDeviation = (List<Double> a) -> {
            Double m = myApp.operateBinary(a, mean);
            Double ans = 0.0;
            ans = a.stream().map((n) -> Math.pow((n - m), 2)).reduce(ans, (accumulator, _item) -> accumulator + _item);
            return Math.sqrt(ans / (a.size() - 1));
        };

        Path file = Paths.get(args[0]);
        FileReader fileReader = new FileReader();
        //leer archivo y guardar las linkedList
        fileReader.getNumbers(file);
        
        //obtener LinkedList de ProxySize
        List<Double> listProxySize = fileReader.getListProxySize();
        
        //obtener LinkedList de Dev Hours
        List<Double> listDevHours = fileReader.getListDevHours();
        
        //operar columna 1
        Double m1 = myApp.operateBinary(listProxySize, mean);
        Double d1 = myApp.operateBinary(listProxySize, sDeviation);
        
        //operar columna 2
        Double m2 = myApp.operateBinary(listDevHours, mean);
        Double d2 = myApp.operateBinary(listDevHours, sDeviation);
        
        //print resultados
        System.out.println("\nTable 1: Column 1 - " + "Mean : " + m1 + ", Standard Deviation: " + d1);
        System.out.println("Table 1: Column 2 - " + "Mean : " + m2 + ", Standard Deviation: " + d2 + "\n");
    }
}
