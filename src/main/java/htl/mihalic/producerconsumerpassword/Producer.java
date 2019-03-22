/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.mihalic.producerconsumerpassword;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Dominik
 */
public class Producer implements Runnable{
    private Password ps;

    public Producer(Password ps) {
        this.ps = ps;
    }
    
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        Queue<Password> queue = new LinkedList<>();
        synchronized(queue){
            while(!sc.next().equals("")){
                ps = new Password(sc.next());
                queue.add(ps);
            }
        }
    }
    
}
