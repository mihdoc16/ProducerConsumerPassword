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
import java.io.IOException;
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
    private Queue<Password> queue;

    public Consumer(Queue<Password> queue) {
        this.queue = queue;
    }


    
    @Override
    public void run() {
        synchronized(queue){
            try {
                queue.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(!queue.isEmpty()){
            synchronized(queue){
//               try {
//                    queue.wait();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
//                }
                ps = queue.remove();
            }
            File f = new File("D:\\Schulordner\\POS Stuff\\10-million-password-list-top-1000000.txt");
            try {
                reader = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

            String line;
            try {
                while((line = reader.readLine()) != null){
                    if(ps.check(line)){
                        System.out.printf("%s, Password is: %s\n", Thread.currentThread().getName(), line);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
