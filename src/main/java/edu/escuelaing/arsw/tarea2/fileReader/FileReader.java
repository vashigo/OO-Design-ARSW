/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.tarea2.fileReader;

import edu.escuelaing.arsw.tarea2.linkedList.LinkedListGeneric;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Vashi
 */
public class FileReader {

    private List<Double> list;
    private Charset charset;

    public FileReader() {
        this.list = new LinkedListGeneric<>();
        this.charset = Charset.forName("UTF-8");
    }

    public List<Double> getNumbers(Path file) throws Exception {
        try {
            BufferedReader BR = Files.newBufferedReader(file, this.charset);
            String linea = BR.readLine();
            while (linea != null) {
                String[] tmp = linea.split(" ");
                for (String s : tmp) {
                    this.list.add(Double.parseDouble(s));
                }
                linea = BR.readLine();
            }
        } catch (IOException ex) {
            throw new Exception("Error leyendo el archivo, revise la ruta");
        }
        return this.list;
    }
}
