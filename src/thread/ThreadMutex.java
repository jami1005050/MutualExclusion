/*
Date: 11/10/2019
Class: CS5310
Assignment: Mutual Exclusion
Author(s): Mohammad Jaminur Islam
*/

package thread;

public class ThreadMutex implements Runnable{
    int processId;
    volatile SharedInstance sharedInstance; // volatile key word is used to make the shared object thread safe
    public ThreadMutex(int processId,SharedInstance sharedInstance){
        this.processId = processId;
        this.sharedInstance = sharedInstance;
    }
    @Override
    public void run() {
        while (true) {
            sharedInstance.flag[this.processId] = true;
            int otherProcessID = (this.processId == 0 ? 1 : 0); // change the process id
            sharedInstance.turn = this.processId; //setting other threads turn to 1
            while (sharedInstance.flag[otherProcessID] == true && sharedInstance.turn == this.processId)
                ; // busy wait
            //critical section
            try {
                System.out.println("Process :" + this.processId+ " entering CS. Sleeping for 1 seconds");
                Thread.currentThread().sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            // set false to let other process know that it has done processing the critical section
            sharedInstance.flag[this.processId] = false;
        }
    }
}
