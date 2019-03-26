/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.mihalic.producerconsumerpassword;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Dominik
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Password> queue = new LinkedList<>();
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
                        
        new Thread(p, "Password lieferant").start();
        new Thread(c1, "Password cracker 1").start();
        new Thread(c2, "Password cracker 2").start();
        new Thread(c3, "Password cracker 3").start();
        
    }
}
