package Lecture10;
//! Volatile and Read/Write Locks
//visibility in multythreading

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// thread safe without locks 

public class Main {
    public static void main(String[] args) {
        //volatile thread safe for visibility problem --- no cach-- lock free sol
    }
}

class SharedObject {
    public volatile static int sCount = 0;
    //performance is the key disadvantage of volatile
    // one right and one read always the right occur first...... advantage
}

//what happens when one thread performs r w and the other r w also ... it is not thread safe cause this is another problem data inconsistency and race condoiition 


// locks are sloower than volatile 

// class sharedobject2{
//     ReentrantLock lock = new ReentrantLock();
//     private int sCount = 0;

//     public void inc(){
//         lock.lock();
//         try{
//             sCount++;
//         } finally{
//             lock.unlock();
//         }
//     }
//     public int GET(){
//         lock.lock();
//         try{
//             return sCount;
//         } finally{
//             lock.unlock();
//         }
//     }
// }







class sharedobject2{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int sCount = 0;

    public void inc(){
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try{
            sCount++;
        } finally{
            writeLock.unlock();
        }
    }
    public int GET(){
        Lock readLock = lock.readLock();
        readLock.lock();
        try{
            return sCount;
        } finally{
            readLock.unlock();
        }
    }
}



//! chatgpt
// ReentrantReadWriteLock is a type of lock in Java that allows multiple threads to read a shared resource simultaneously while restricting write access to only one thread at a time. It is a more efficient alternative to the traditional synchronization mechanism of using synchronized blocks or methods, particularly in cases where the frequency of read operations is much higher than write operations.

// The key feature of ReentrantReadWriteLock is its reentrant nature, which means that a thread that already holds a read or write lock can acquire the same lock again without getting blocked. This allows for a more flexible and efficient locking strategy, as a thread can perform multiple operations on the shared resource without repeatedly acquiring and releasing the lock.

// ReentrantReadWriteLock provides two types of locks: read locks and write locks. Multiple threads can acquire read locks simultaneously as long as no thread holds a write lock. On the other hand, only one thread can hold a write lock at a time, and no other thread can acquire a read or write lock until the write lock is released.

// Overall, ReentrantReadWriteLock can help improve the performance and scalability of multi-threaded applications that require shared access to a resource, particularly in scenarios where read operations are more frequent than write operations. However, it also requires careful consideration and usage to avoid potential issues such as deadlocks or starvation of write operations.