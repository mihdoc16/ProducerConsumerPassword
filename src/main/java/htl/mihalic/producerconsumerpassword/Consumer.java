/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.mihalic.producerconsumerpassword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dominik
 */
public class Consumer implements Runnable{
    private Password ps;
    private BufferedReader reader;

    public Consumer(Password ps) {
        this.ps = ps;
    }
    
    @Override
    public void run() {
        Queue<Password> queue = new LinkedList<>();
        while(!queue.isEmpty()){
            ps = queue.remove();
            File f = new File("D:\\Schulordner\\POS Stuff\\10-million-password-list-top-1000000.txt");
            try {
                reader = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String line;
            
        }
    }
    
}
