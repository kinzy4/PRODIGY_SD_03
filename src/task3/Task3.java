/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.io.IOException;

/**
 *
 * @author Kinzy
 */
public class Task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        client p1= new client();
       // System.out.println( p1.register("kinzy", "mohamed", "kinzy", "1234")); 
        //System.out.println( p1.login("kinzy", "1234"));
       // System.out.println(p1.addcontact("kinzy", "nada", "nada @gmail.com", "0112588555"));  
        p1.listcontact("kinzy");
    }
    
}
