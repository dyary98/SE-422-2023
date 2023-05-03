package Lecture14;
// !Linked Blocking Queues - Part 1
    // BLocking Q
    // is an interface, we have some implementaion of this interface
    // Blocking Q can allows only share data between multi- threads and also can slow dawn one thread if it needs to  

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// t1--------------->t2
    // if one is fast the other should be faster and if one is slow the other must slowdown 

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer>   queue = new LinkedBlockingQueue<>();
        // BlockingQueue<Integer>   queue = new LinkedBlockingQueue<>(100); size of the Q is 100 the above one is unlimited
        Thread t1 = new Thread1(queue);
    }
}
class Thread1 extends Thread{
    private BlockingQueue<Integer> q;
    public Thread1(BlockingQueue<Integer> q){
        this.q = q;
    }
    @Override
    public void run() {
        q.add(1); //! throws exception if problem happened(Running out of memory, capacity limit reached or size of Queue) illegal state Exception
        boolean result = q.offer(1); //! if it couldnt added data to the Q, returns false |||| No exception here 
        q.offer(1, 10, TimeUnit.SECONDS); //! needs try and catch and keeps trying for 10 seconds if faild to add value 1 to the Q
        q.put(1); //! will put the thread into sleeping mode if couldnt add the elemenet to Q, it wakes up The THread if Q had room to other eleements
      
        while (1==1) {
            q.add(1); // if we specifi a size for our Q, lets say its 100, our loop will go for 100 times and then we get an exception on 101th iteration
            //if u dont have try and catch and u got the exception, your thread will be terminated
        }
    }
}


class Department{

}