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
         
        //!Exception  add()       remove()    element()
        //!no Exce    offer()     poll()      peek()
        //!sleep      put()       take()
        while (1==1) {
            q.add(1); // if we specifi a size for our Q, lets say its 100, our loop will go for 100 times and then we get an exception on 101th iteration
            //if u dont have try and catch and u got the exception, your thread will be terminated
        }
    }
}


class Department{

}

// !we also have LinkedBlockingDeque

/* 
 * 
 !LinkedBlockingDeque is a thread-safe implementation of the Deque interface in Java. It is similar to LinkedBlockingQueue but provides support for both FIFO (First-In-First-Out) and LIFO (Last-In-First-Out) operations. It is implemented as a linked list with both head and tail pointers, allowing elements to be added or removed from both ends of the deque.

Here are some important methods of LinkedBlockingDeque:

addFirst(E e) - Adds the specified element at the beginning of the deque. Throws an exception if the deque is full.
addLast(E e) - Adds the specified element at the end of the deque. Throws an exception if the deque is full.
offerFirst(E e) - Adds the specified element at the beginning of the deque. Returns true if the operation is successful, false if the deque is full.
offerLast(E e) - Adds the specified element at the end of the deque. Returns true if the operation is successful, false if the deque is full.
removeFirst() - Removes and returns the first element of the deque. Throws an exception if the deque is empty.
removeLast() - Removes and returns the last element of the deque. Throws an exception if the deque is empty.
pollFirst() - Removes and returns the first element of the deque. Returns null if the deque is empty.
pollLast() - Removes and returns the last element of the deque. Returns null if the deque is empty.
getFirst() - Returns the first element of the deque without removing it. Throws an exception if the deque is empty.
getLast() - Returns the last element of the deque without removing it. Throws an exception if the deque is empty.
peekFirst() - Returns the first element of the deque without removing it. Returns null if the deque is empty.
peekLast() - Returns the last element of the deque without removing it. Returns null if the deque is empty.
LinkedBlockingDeque also supports blocking operations like takeFirst() and takeLast() which block the calling thread until an element becomes available. It also provides methods like offerFirst(E e, long timeout, TimeUnit unit) and offerLast(E e, long timeout, TimeUnit unit) which try to add an element to the deque, blocking the calling thread for the specified time if the deque is full.
 */


 //! linkedTransferedQueue
 //! DelayQueue homework