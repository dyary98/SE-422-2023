

//Intrinsic locks | structured Locks --- synchronize it has advantages and disadvantages...... everything is ready for you ... locking and unlocking 



//! Rentrant Locks


//imagine the follwoing scenario

// synchronize(l1){
    //     synchronize(l2){
        //         A();
        //     }
        //
// }






// in the above scenario here is how automatically lock and unlock happens for you
//t1
// Lock l1
// Lock l2
// A()
// UnLock l2
// UnLock l1
// synchronize order ba dast to nia 
// can you swich the order of the above locks and UnLocks


//! Thread Starvation
// Thread starvation is a condition that can occur in Java when a thread is ......
// unable to make progress because it cannot acquire the resources it needs to execute. 

//DeadLock 

//when you want to manually perform lock and UL you have to use Rentrant | unstructured Locks  

// import java.util.concurrent.*;
// import java.util.concurrent.locks.*;

// public class Main {
//     public static void main(String[] args) {
//         Student s1 = new Student(); 

//         Thread t1 = new ThreadOne(s1);
//         Thread t2 = new ThreadTwo(s1);
//         t1.start();
//         t2.start();

//     }
// }

// class ThreadOne extends Thread{
//     private Student student;
//     public ThreadOne(Student student){
//         this.student = student;
//     }

//     @Override
//     public void run(){
//         ReentrantLock l = student.lock;
//         l.lock();
        
//         l.unlock();
//     }
// }



// class ThreadTwo extends Thread{
//     private Student student;
//     public ThreadTwo(Student student){
//         this.student = student;
//     }

//     @Override
//     public void run(){

//     }
// }

//  class Student  {
//     public final ReentrantLock lock; //final no body can change the pointer of the obj

//     public Student(){
//         lock = new ReentrantLock();//so that each student obj will have a different lock obj
//     }
// }

// today lecture only ReentrantLock 








//!Implement these practises 

//Use Polymorphism
//Use get and set Design pattern
//3 add locks inside your set  functions 
// try and finally

package SixthLecture;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

        Thread t1 = new ThreadOne(s1);
        Thread t2 = new ThreadTwo(s1);

        t1.start();
        t2.start();

    }
}

class ThreadOne extends Thread{
    private Student student;
    public ThreadOne(Student student){
        this.student = student;
    }

    @Override
    public void run(){
        Lock l = student.lock;
        l.lock();
        student.setName("dyary");
        l.unlock();

        // student.setName("sozy");
    }
}
class ThreadTwo extends Thread{
    private Student student;
    public ThreadTwo(Student student){
        this.student = student;
    }

    @Override
    public void run(){
        // Lock l = student.lock;
        // l.lock();
        // student.setName("Hellein");
        // l.unlock();

        student.setName("Rawaz");
    }
}

 class Student  {
    public final Lock lock; //final no body can change the pointer of the obj
    private String name;
    public Student(){
        lock = new ReentrantLock();//so that each student obj will have a different lock obj
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.lock.lock();
        this.name = name;
        this.lock.unlock();
    }
    
}




// //!ٍsome other methods 


// package SixthLecture;
// import java.util.concurrent.*;
// import java.util.concurrent.locks.*;

// public class Main {
//     public static void main(String[] args) {
//         Student s1 = new Student();

//         Thread t1 = new ThreadOne(s1);
//         Thread t2 = new ThreadTwo(s1);
//         t1.start();
//         t2.start();

//     }
// }

// class ThreadOne extends Thread{
//     private Student student;
//     public ThreadOne(Student student){
//         this.student = student;
//     }

//     @Override
//     public void run(){
//         ReentrantLock l = student.lock;
//         l.lock();
//         l.isLocked();
//         l.tryLock(); //trys to lock if couldnt returns false
//         // l.tryLock(10, TimeUnit.SECONDS); //trys to lock if couldnt tries again after 10s
//         l.lockInterruptibly(); //not grng    
//         l.getHoldCount();//returns an int how many times this thread has locked the object while not being unlocked yet
//         l.unlock();
//     }
// }
// class ThreadTwo extends Thread{
//     private Student student;
//     public ThreadTwo(Student student){
//         this.student = student;
//     }

//     @Override
//     public void run(){
//         Lock l = student.lock;
//         l.lock();
//         l.unlock();

//     }
// }

//  class Student  {
//     public final ReentrantLock lock; //final no body can change the pointer of the obj
//     private String name;
//     public Student(){
//         lock = new ReentrantLock();//so that each student obj will have a different lock obj
//     }

//     public String getName(){
//         return name;
//     }
//     public void setName(String name){
//         this.lock.lock();
//         this.name = name;
//         this.lock.unlock();
//     }
    
// }













// cody hama 
// package week6;
// import java.util.concurrent.*;
// import java.util.concurrent.locks.*;
// //taqatm chw rewatch the lecture 13/3/2023
// //deadlock or thread starvation is when a thread is waiting for a resource that is locked by another thread.
// //and the other thread is waiting for a resource that is locked by the first thread.
// //so they are waiting for each other.
// //here is an example of deadlock:
// // Thread 1: lockA.lock();
// // Thread 2: lockB.lock();
// // Thread 1: lockB.lock();
// // Thread 2: lockA.lock();
// // Thread 1: lockA.unlock();
// // Thread 2: lockB.unlock();
// // Thread 1: lockB.unlock();
// // Thread 2: lockA.unlock();
// /*
// In Java, both intrinsic locks (also known as monitor locks) and reentrant locks are mechanisms used to synchronize access to shared resources in multi-threaded programs. However, there are some differences between the two:
// Ownership: Intrinsic locks are owned implicitly by the thread that acquired them, whereas reentrant locks are owned explicitly by the thread that acquired them. This means that with intrinsic locks, a thread cannot release a lock that it did not acquire, whereas with reentrant locks, a thread can release a lock it has acquired multiple times.
// Acquiring and releasing: Intrinsic locks are acquired using the synchronized keyword and are released when the synchronized block or method ends. Reentrant locks are acquired using the lock() method and are released using the unlock() method.
// Reentrancy: Reentrant locks can be reacquired by the same thread that already owns them, whereas intrinsic locks are not reentrant - if a thread tries to acquire a lock that it already owns, it will block indefinitely.
// Fairness: Reentrant locks can be constructed to be fair, meaning that the lock will be granted to the longest-waiting thread when it becomes available. Intrinsic locks do not have this capability.
// Overall, reentrant locks provide more fine-grained control over locking behavior, including reentrancy and fairness, while intrinsic locks provide a simpler and more lightweight mechanism for synchronization.
//  */
// public class p1 {
//     public static void main(String[] args) {
//         Student s1 = new Student();
//         Thread t1 = new Thread1(s1);
//         Thread t2 = new Thread2(s1);
//     }
// }
// class Thread1 extends Thread {
//     private Student s1;
//     private Student s2;
//     public Thread1(Student s1, Student s2) {
//         this.s1 = s1;
//         this.s2 = s2;
//     }
//     public void run(){
//         while(true){
//             s1.lock.lock();
//             s1.lock.unlock();
//             boolean b = s1.lock.tryLock();
//         }
//     }
// }
// class Thread2 extends Thread {
//     private Student s1;
//     public Thread2(Student s1) {
//         this.s1 = s1;
//     }
//     public void run(){
//         s1.lock.lock();
//         //do something
//         s1.lock.unlock();
//     }
// }
// class Student {
//     public final Lock lock;
//     // by making it final we can't change the pointer of the lock.
//     private String name;
//     //never expose the variables of the class, always use getters and setters.
//     public Student () {
//         lock = new ReentrantLock();
//     }
//     public void setName(String name) {
//         this.lock.lock();
//         this.name = name;
//         this.lock.unlock();
//     }
//     public String getName() {
//         return name;
//     }
// }

// 