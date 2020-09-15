/*
Date: 11/10/2019
Class: CS5310
Assignment: Mutual Exclusion
Author(s): Mohammad Jaminur Islam
*/

package main;

import thread.SharedInstance;
import thread.ThreadMutex;

public class Main {


    public static void main(String[] args) {

        SharedInstance sharedVariable = new SharedInstance(); // create the shared instances

        ThreadMutex process1 = new ThreadMutex(0, sharedVariable); // create process 1 with shared instance
        ThreadMutex process2 = new ThreadMutex(1, sharedVariable); // create process 2 with shared instance
        Thread thread1 = new Thread(process1); // start thread 1
        Thread thread2 = new Thread(process2); // start thread 2

        // start the threads
        thread1.start();
        thread2.start();

    }
}
