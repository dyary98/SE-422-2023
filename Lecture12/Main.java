package Lecture12;

import java.util.concurrent.atomic.AtomicReference;

//!Atomic References
// allows you to update or get a refrence for an obj in a thread safe manner

// The need for AtomicReference arises when multiple threads need to update or access
//  the same shared reference variable. In a multi-threaded environment, if two or more threads
//  try to modify the same reference variable concurrently, it can lead to race conditions,
//  data inconsistencies, and other concurrency-related issues. AtomicReference provides a way
//  to avoid these issues by providing thread-safe access to the reference variable,
//  which eliminates the need for explicit synchronization and ensures consistent updates across all threads
public class Main {
    public static void main(String[] args) {
        
    }
}

/**
 * Employee
 */
 class Employee {
    String name; int id;
}
AtomicRefrence<Employee> ref = new AtomicReference<>();
Employee e1 = new Employee();
ref.set(e1);
ref.get().name = "mai";
ref.get().id = 5;
static Employee e = new Employee(); //volatile wont save you here, 
e.name = "maya";
e.id = 5;

class t1 extends Thread{
    void run(){
        System.out.println(e.name);
        System.out.println(e.id);
    }
}
class t2 extends Thread{
    void run(){
        e = new Employee();
        e.name = "soemals";
        e.id = 11;
    }
}

// is this code thread safe? one thread reads and the other writes hte shared obj




//chat gpt example 

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        AtomicReference<Person> atomicPerson = new AtomicReference<>(person);

        Thread thread1 = new Thread(() -> {
            while (true) {
                Person currentPerson = atomicPerson.get();
                currentPerson.setAge(currentPerson.getAge() + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                Person currentPerson = atomicPerson.get();
                System.out.println(currentPerson.getName() + " is " + currentPerson.getAge() + " years old");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
// In the example above, we define a Person class with name and age properties and getter and setter methods for the age property. We then create an instance of the Person class and initialize it with name "John" and age 25. We use this instance to create an instance of AtomicReference<Person>.

// We then create two threads. The first thread increments the age property of the Person object referenced by atomicPerson every second. The second thread reads the name and age properties of the Person object referenced by atomicPerson every half-second and prints them to the console.

// If we run this example without using AtomicReference, and instead share the Person object directly between the two threads, it can result in race conditions and data inconsistencies. For example, if thread 2 reads the age property while thread 1 is in the middle of updating it, thread 2 may get an incorrect value. This can lead to unpredictable behavior and incorrect results.

// However, when we use AtomicReference, the updates to the Person object are atomic and consistent across all threads. This eliminates the race conditions and ensures that all threads see the same values for the Person object's properties.

// Overall, AtomicReference is a useful class for ensuring thread-safe access to shared object references in multi-threaded environments.