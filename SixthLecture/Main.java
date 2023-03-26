

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
        ReentrantLock l = student.lock;
        l.lock();
        
        l.unlock();
    }
}



class ThreadTwo extends Thread{
    private Student student;
    public ThreadTwo(Student student){
        this.student = student;
    }

    @Override
    public void run(){

    }
}

 class Student  {
    public final ReentrantLock lock; //final no body can change the pointer of the obj

    public Student(){
        lock = new ReentrantLock();//so that each student obj will have a different lock obj
    }
}

// today lecture only ReentrantLock 








// //!Implement these practises 

// //Use Polymorphism
// //Use get and set Design pattern
// //3 add locks inside your set  functions 
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
//         // Lock l = student.lock;
//         // l.lock();
//         // student.setName("dyary");
//         // l.unlock();

//         student.setName("sozy");
//     }
// }
// class ThreadTwo extends Thread{
//     private Student student;
//     public ThreadTwo(Student student){
//         this.student = student;
//     }

//     @Override
//     public void run(){
//         // Lock l = student.lock;
//         // l.lock();
//         // student.setName("Hellein");
//         // l.unlock();

//         student.setName("Rawaz");
//     }
// }

//  class Student  {
//     public final Lock lock; //final no body can change the pointer of the obj
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




//!ٍsome other methods 


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
//         //l.tryLock(10, TimeUnit.SECONDS); //trys to lock if couldnt tries again after 10s
//         //l.lockInterruptibly(); //not grng    
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