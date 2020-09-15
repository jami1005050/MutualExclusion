/*
Date: 11/10/2019
Class: CS5310
Assignment: Mutual Exclusion
Author(s): Mohammad Jaminur Islam
*/

package thread;

public class SharedInstance {
    boolean[] flag = new boolean[2]; // keep the threads states in critical section
    int turn; // in order to track the turn of the threads

    public SharedInstance() {
        flag[0] = false; // o thread for critical section false
        flag[1] = false; // 1 thread for critical section false
        turn = 1;  // default set turn to 1
    }
}
