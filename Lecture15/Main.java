package Lecture15;
//! Linked Blocking Queue - Part 2
/* 
 ! In Java, a SynchronousQueue is a type of blocking queue that is used to transfer elements between threads in a synchronous manner. The SynchronousQueue has a zero capacity, which means that it cannot hold any elements, and it is used mainly for handoff-style operations.

When an element is inserted into a SynchronousQueue, the thread that is inserting the element is blocked until another thread removes the element from the queue. Similarly, when a thread tries to remove an element from a SynchronousQueue, it is blocked until another thread inserts an element into the queue.

The SynchronousQueue is typically used for thread handoff scenarios where one thread needs to pass an object to another thread for further processing. The SynchronousQueue guarantees that the object will be passed from one thread to another in a synchronous manner without the need for explicit synchronization between the two threads.

Here is an example of using a SynchronousQueue in Java:


import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        // Producer thread
        new Thread(() -> {
            try {
                System.out.println("Inserting element...");
                queue.put(42);
                System.out.println("Element inserted");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                System.out.println("Waiting for element...");
                Integer element = queue.take();
                System.out.println("Element received: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
In this example, we create a SynchronousQueue of type Integer and start two threads: a producer thread and a consumer thread. The producer thread inserts an element (42) into the queue, and the consumer thread waits for an element to be available in the queue. When the producer thread inserts the element, the consumer thread takes the element from the queue and prints it out.
 */

import java.util.concurrent.BlockingQeque;

//! write a simple java app to create the follwoing thread topology
// T1----> t2(x+y)
// T1----> t3(x*y)
// T1----> t4(x/y)
//! thread 1 generates two numbers for t2,3,4 
public class Main {
    public static void main(String[] args) {
        
    }
}

class Thread1 extends Thread{
    public Thread1(BlockingQeque)
}

//! class PriorityBlockingQueue

/* 
 * 
 * In Java, a PriorityBlockingQueue is a type of blocking queue that is used to hold elements in a sorted order. The PriorityBlockingQueue is an unbounded queue, which means that it can grow dynamically as new elements are added to it.

The PriorityBlockingQueue stores elements in a priority queue, which means that the elements are ordered based on their natural ordering or based on a Comparator if one is specified. The head of the queue is the least element according to the specified ordering.

The PriorityBlockingQueue is thread-safe, which means that multiple threads can access and modify the queue concurrently without causing data corruption or other issues.

Here is an example of using a PriorityBlockingQueue in Java:

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // Add elements to the queue
        queue.add(10);
        queue.add(5);
        queue.add(20);
        queue.add(15);

        // Print the elements in the queue
        System.out.println("Elements in the queue: " + queue);

        // Remove the head element
        Integer head = queue.poll();
        System.out.println("Head element: " + head);

        // Print the elements in the queue again
        System.out.println("Elements in the queue after removing head: " + queue);
    }
}


In this example, we create a PriorityBlockingQueue of type Integer and add four elements to the queue. The elements are automatically sorted based on their natural ordering (i.e., smallest to largest). We then print out the elements in the queue and remove the head element (which is the smallest element). Finally, we print out the elements in the queue again to see that the head element has been removed.

The output of the above code would be:
Elements in the queue: [5, 10, 20, 15]
Head element: 5
Elements in the queue after removing head: [10, 15, 20]

As you can see, the elements in the queue are automatically sorted based on their natural ordering. When we remove the head element, the new head becomes the next smallest element in the queue.
 */



 /* 
  *  The Comparable interface in Java provides a single method compareTo that is used to define a natural ordering for a class. The compareTo method returns a negative integer, zero, or a positive integer if the current object is less than, equal to, or greater than the specified object, respectively.

The PriorityBlockingQueue in Java uses the natural ordering of the elements to determine their priority by default. This means that if you add objects of a class that implements the Comparable interface to a PriorityBlockingQueue, the queue will use the compareTo method to order the elements in the queue.

Here's an example of using the Comparable interface with a PriorityBlockingQueue:

arduino
Copy code
import java.util.concurrent.PriorityBlockingQueue;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return this.age - otherPerson.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Person> queue = new PriorityBlockingQueue<>();

        // Add persons to the queue
        queue.add(new Person("John", 35));
        queue.add(new Person("Alice", 25));
        queue.add(new Person("Bob", 40));

        // Print the persons in the queue
        System.out.println("Persons in the queue: " + queue);

        // Remove the person with the highest priority
        Person highestPriorityPerson = queue.poll();
        System.out.println("Highest priority person: " + highestPriorityPerson);

        // Print the persons in the queue again
        System.out.println("Persons in the queue after removing highest priority: " + queue);
    }
}
In this example, we create a Person class that implements the Comparable interface. We define the natural ordering of persons based on their age. We then add three Person objects to the PriorityBlockingQueue, and the queue automatically orders them based on their age (i.e., youngest to oldest).

When we remove the person with the highest priority using the poll() method, the queue returns the person with the lowest age (i.e., highest priority). Finally, we print out the persons in the queue again to see that the highest priority person has been removed.

The output of the above code would be:

arduino
Copy code
Persons in the queue: [Person{name='Alice', age=25}, Person{name='John', age=35}, Person{name='Bob', age=40}]
Highest priority person: Person{name='Alice', age=25}
Persons in the queue after removing highest priority: [Person{name='John', age=35}, Person{name='Bob', age=40}]
As you can see, the PriorityBlockingQueue automatically ordered the Person objects based on their age, which is defined by the compareTo method in the Person class.
  */