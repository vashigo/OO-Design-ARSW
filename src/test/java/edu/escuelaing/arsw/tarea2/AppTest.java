/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.tarea2;

import edu.escuelaing.arsw.tarea2.fileReader.FileReader;
import edu.escuelaing.arsw.tarea2.calculator.Calculator;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vashi
 */
public class AppTest 
{
    private Calculator myApp;
    private Calculator.DoubleMath mean;
    private Calculator.DoubleMath sDeviation;
    
    @Before
    public void setUp() {
        myApp = new Calculator();
        mean=(List<Double> a) -> {
            Double ans=0.0;
            ans = a.stream().map((n) -> n).reduce(ans, (accumulator, _item) -> accumulator + _item);
            return ans/a.size();
        };
        
        sDeviation=(List<Double> a) -> {
            Double m=myApp.operateBinary(a, mean);
            Double ans=0.0;
            ans = a.stream().map((n) -> (n-m)*(n-m)).reduce(ans, (accumulator, _item) -> accumulator + _item);
            return Math.sqrt(ans/(a.size()-1));
        };
    }
    
    @Test
    public void calculateMeansOfIntegers() throws Exception {
        
        Path file = Paths.get("src/test/resources/datos.txt");
        FileReader fileReader = new FileReader();
        //leer archivo y guardar las linkedList
        fileReader.getNumbers(file);
        
        //obtener LinkedList de ProxySize
        List<Double> listProxySize = fileReader.getListProxySize();
        
        //operar columna 1
        Double m1 = myApp.operateBinary(listProxySize, mean);
        
        assertEquals(550.6, m1,0.0001);
    }
    
    @Test
    public void calculateStandardDeviationofIntegers() throws Exception {
        
        Path file = Paths.get("src/test/resources/datos.txt");
        FileReader fileReader = new FileReader();
        //leer archivo y guardar las linkedList
        fileReader.getNumbers(file);
        
        //obtener LinkedList de ProxySize
        List<Double> listProxySize = fileReader.getListProxySize();
        
        //operar columna 1
        Double d1 = myApp.operateBinary(listProxySize, sDeviation);

        assertEquals(572.03, d1,0.005);
    }
    
    @Test
    public void calculateMeansOfDouble() throws Exception {
        
        Path file = Paths.get("src/test/resources/datos.txt");
        FileReader fileReader = new FileReader();
        //leer archivo y guardar las linkedList
        fileReader.getNumbers(file);
        
        //obtener LinkedList de ProxySize
        List<Double> listProxySize = fileReader.getListDevHours();
        
        //operar columna 1
        Double m1 = myApp.operateBinary(listProxySize, mean);
        
        assertEquals(60.32, m1,0.0001);
    }
    
    @Test
    public void calculateStandardDeviationofDouble() throws Exception {
        
        Path file = Paths.get("src/test/resources/datos.txt");
        FileReader fileReader = new FileReader();
        //leer archivo y guardar las linkedList
        fileReader.getNumbers(file);
        
        //obtener LinkedList de ProxySize
        List<Double> listProxySize = fileReader.getListDevHours();
        
        //operar columna 1
        Double d1 = myApp.operateBinary(listProxySize, sDeviation);

        assertEquals(62.26, d1,0.005);
    }
}
