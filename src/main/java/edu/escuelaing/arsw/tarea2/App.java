package edu.escuelaing.arsw.tarea2;

import edu.escuelaing.arsw.tarea2.calculator.Calculator;
import edu.escuelaing.arsw.tarea2.fileReader.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        Calculator myApp = new Calculator();
        Calculator.DoubleMath mean;
        mean = (List<Double> a) -> {
            Double ans = 0.0;
            ans = a.stream().map((n) -> n).reduce(ans, (accumulator, _item) -> accumulator + _item);
            return ans / a.size();
        };

        Calculator.DoubleMath sDeviation;
        sDeviation = (List<Double> a) -> {
            Double m = myApp.operateBinary(a, mean);
            Double ans = 0.0;
            ans = a.stream().map((n) -> Math.pow((n - m), 2)).reduce(ans, (accumulator, _item) -> accumulator + _item);
            return Math.sqrt(ans / (a.size() - 1));
        };

        Path file = Paths.get(args[0]);
        FileReader fileReader = new FileReader();
        //leer archivo 
        List<Double> lista = fileReader.getNumbers(file);
        Double m = myApp.operateBinary(lista, mean);
        Double d = myApp.operateBinary(lista, sDeviation);
        System.out.println("Mean : " + m + ", Standard Deviation: " + d);
    }
}
