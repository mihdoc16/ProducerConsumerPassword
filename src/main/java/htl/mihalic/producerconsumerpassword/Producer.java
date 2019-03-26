/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.mihalic.producerconsumerpassword;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dominik
 */
public class Producer implements Runnable{
    private Password ps;
    Queue<Password> queue;

    public Producer(Queue<Password> queue) {
        this.queue = queue;
    }


    
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        synchronized(queue) {
            System.out.printf("Enter password: ");
            String line = sc.next();
            ps = new Password(line);
            queue.add(ps);
            while(!line.equals("end")){
                System.out.printf("Enter password: ");
                line = sc.next();
                ps = new Password(line);
                queue.add(ps);
            }
            queue.notifyAll();
            try {
                queue.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Thread.yield();
    }
    
}
