package Lecture11;
// Introduction to Atomic Variables
// in class lab create two user threads to add all numbers from 0 to 20 to a shared variable called counter and print the result in the main thread

// public class Main {
//     public static void main(String[] args) {
//         Thread t1 = new UpdateCounterThread();
//         Thread t2 = new UpdateCounterThread();

//         t1.start();
//         t2.start();
//         System.out.println(t1.counter);
//    }
// }

//  class UpdateCounterThread extends Thread {
//     public static int counter; 
//     public UpdateCounterThread(){

//     }
//     @Override
//     public void run() {
//         for (int i = 0; i < 20; i++) {
//             counter += i;
//         }
//     }
    
// }



// public class Main {

//   public static void main(String[] args) throws InterruptedException {
//     CounterResult cr = new CounterResult();
//     Thread t1 = new UpdateCounterThread(cr);
//     Thread t2 = new UpdateCounterThread(cr);

//         t1.start();
//         t2.start();
//         t1.join();
//         t2.join();
//         System.out.println(cr.getResult());
//   }  
// }

// class CounterResult{
//     private int counter;
//     public int getResult(){
//         return counter;
//     }

//     public void compute(){
//         for (int i = 0; i < 4000; i++) {
//             counter += i;
//         }
//     }
// }

//  class UpdateCounterThread extends Thread {
//     private CounterResult cr ; 
//     public UpdateCounterThread( CounterResult cr){
//         this.cr = cr;
//     }
//     @Override
//     public void run() {
//         cr.compute();
//     }
    
// }


// this code is not thread safe when we increase the loop to a greater number 

//sols 
// synchronize dis--performance 
// Rentrant Locks -- same not faster 
// RentrantReadWrite Does not work here cause both threads read and write 
// Volatile does not work, this is racing condition 

//Goal making this faster without using locks,
//Atomic variables to do primitive operations 

// import java.util.concurrent.atomic.*;
// // either update or not 
// public class Main {

//     public static void main(String[] args) throws InterruptedException {
//       CounterResult cr = new CounterResult();
//       Thread t1 = new UpdateCounterThread(cr);
//       Thread t2 = new UpdateCounterThread(cr);
  
//           t1.start();
//           t2.start();
//           t1.join();
//           t2.join();
//           System.out.println(cr.getResult());
//     }  
//   }
  
//   class CounterResult{
//     private AtomicInteger aCounter = new AtomicInteger(1); //the one below does not work cause they are not integers
//     // private AtomicInteger aCounter = 4; //this does not work 
    
//       public int getResult(){
//           return aCounter.get();
//       }
  
//       public void compute(){
//           for (int i = 0; i < 10000; i++) {
//               aCounter.incrementAndGet(); // old 6 + 1 = 7 return 7
//               aCounter.getAndIncrement(); // old 6 return 6  dway old 6 + 1 = 7
//               // this perform increment operation in a thread safe manner withoutusing locks
//             //   aCounter.getAndIncrement();
//             // aCounter.decrementAndGet();
//             aCounter.addAndGet(23456);
//           }
//       }
//   }
  
//    class UpdateCounterThread extends Thread {
//       private CounterResult cr ; 
//       public UpdateCounterThread( CounterResult cr){
//           this.cr = cr;
//       }
//       @Override
//       public void run() {
//           cr.compute();
//       }
      
//   }

  //this only is good for increment and decremment if you have more complex operations, this might lead to thread unsafity
  // if you add two atomic ints they might not be thread safe, 

  import java.util.concurrent.atomic.*;
// either update or not 
public class Main {

    public static void main(String[] args) throws InterruptedException {
      CounterResult cr = new CounterResult();
      Thread t1 = new UpdateCounterThread(cr);
          Thread t2 = new UpdateCounterThread(cr);
  
          t1.start();
          t2.start();
          t1.join();
          t2.join();
          System.out.println(cr.getResult());
    }  
  }
  
  class CounterResult{
    private AtomicInteger aCounter = new AtomicInteger(1); //the one below does not work cause they are not integers
    
      public int getResult(){
          return aCounter.get();
      }
  
      public void compute(){
        int old = 0;
          for (int i = 0; i < 10000; i++) {
            //   aCounter.incrementAndGet();
            if(aCounter.compareAndSet(old, old+1)){
              //! It takes two arguments: the expected value and the new value. If the current value of the variable is equal to the expected value, then the variable is set to the new value, and the method returns true. If the current value of the variable is not equal to the expected value, then the variable is not modified, and the method returns false.
                old = getResult(); 
            }else{
                old = getResult();
                i--;
            }
          }
      }
  }







  class Counter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void compute() {
        int oldValue = 0;
        for (int i = 0; i < 2000000; i++) {
            if (!counter.compareAndSet(oldValue, oldValue + 1)) {
                i--; // retry the operation if the value has changed in the memory
            }
            oldValue = getCounter();
        }
    }

    public int getCounter() {
        return counter.get();
    }
}




  
   class UpdateCounterThread extends Thread {
      private CounterResult cr ; 
      public UpdateCounterThread( CounterResult cr){
          this.cr = cr;
      }
      @Override
      public void run() {
          cr.compute();
      }
  }
  // !atomic are goood for one value or one variable at a time, for complex ops use locks

//! AtomicIntegerArray midterm or final exam 

//   AtomicIntegerArray in Java is a class that provides a thread-safe way to work with arrays of integers. It's part of the java.util.concurrent package and was introduced in Java 5.0.

// The class provides a set of methods that allow for atomic operations to be performed on the elements of the array, such as get, set, and compareAndSet. These methods ensure that all changes to the array are visible to all threads immediately and that there are no race conditions or inconsistencies.

// AtomicIntegerArray can be useful in scenarios where multiple threads need to update and access the same array of integers. Since it provides thread safety, it eliminates the need for explicit synchronization and reduces the chances of deadlocks and other concurrency-related issues.

// Here's an example of how to use AtomicIntegerArray:

// scss
// Copy code
// AtomicIntegerArray arr = new AtomicIntegerArray(5);

// arr.set(0, 1);
// arr.set(1, 2);
// arr.set(2, 3);
// arr.set(3, 4);
// arr.set(4, 5);

// int oldValue = arr.getAndSet(0, 6); // returns 1
// int newValue = arr.get(0); // returns 6

// boolean swapped = arr.compareAndSet(1, 2, 7); // returns true
// In the example, we create an instance of AtomicIntegerArray with a size of 5 and set some initial values. We then use the getAndSet method to atomically set the value at index 0 to 6 and get its previous value. We also use the compareAndSet method to atomically update the value at index 1 from 2 to 7 if it's currently 2.
  


//work 