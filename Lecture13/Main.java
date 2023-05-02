package Lecture13;
//! Concurrent Queues
// Data structures,we want a thread safe linked list
//non blocking datastructures

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

//passing multiple values from one thread to the other is why we need datastructures with multi threading 
// pass by refrence, coomunication channel, anytime, any data 
//? how can you make sure that a data structure is thread safe
//! communication channel || shared datastructure if you have two threads one must write the other must read and can remove also
//  ConcurentLinekdQueue - Thread safe data structure, when u c concurent with a data structure most of the time means that they are not using locks to ensure thread safety

class Student {
    String id, name;
}

public class Main {

    public static void main(String[] args) {
        
        ConcurrentLinkedQueue<Student> ds = new ConcurrentLinkedQueue<Student>();
        Thread t1 = new T1(ds);
        Thread t2 = new T1(ds);
    }
}
//
//
class T1 extends Thread{
    ConcurrentLinkedQueue<Student> ds;
    public T1(ConcurrentLinkedQueue<Student> ds){
        this.ds = ds;
    }
    @Override
    public void run() {
        Student s1 = new Student();
        //! first in firstout fifo
        ds.add(s1); //! adds to the tail element s1|s2|s3
        // ds.offer(s1);
        //addAll
        //ds.remove(); //! removes from the head, oldest data will be removed first 
        //ds.peek();
    }
    //!how to iterate through this datastructure
    Iterator<Student> it = ds.iterator();
    while(it.hasNext()){
        Student e = it.next();
        System.out.println(e.name);
    }
    for(Student s: ds){

    }
}


//!u can not use null or in other words u can not add null to this ds