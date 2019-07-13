/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author musta
 */
public class FileHandler {
    
    public static Data read() {
        try{
            FileInputStream fis = new FileInputStream("Data.txt");
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Data Data = (Data) ois.readObject();
                return Data;
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.print(e.getMessage());
        }
        return null;
    }

    public static void write(Data data) {
        try {
            FileOutputStream fos = new FileOutputStream("Data.txt");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(data);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
