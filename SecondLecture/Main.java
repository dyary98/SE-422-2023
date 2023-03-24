

// package SecondLecture;
// // !!! Install "better comments" exstension daibazena kakaaaaaaaa

// public class Main {
//     public static void main(String[] args) throws Exception {
//         // amaian bakarbena tkaaya
//         TestThread t1 = new TestThread();
//         t1.start();
//         t1.printTask();
//     }
// }

// class TestThread extends Thread  {
    
//     @Override
//     public void run() {
        
//     }
//     public void printTask(){

//     }
//     //!you can not write static with the run method of the Thread Class, because it does not have static inside the Thread class
// }



//-----------------------------------------------------------


// //!I can not add two super classes to another class, or in other words i cannot extend two classes
// //solution : dont extend Thread but rather implement Runnable

// //advantage : you can extend other classes for your class

// //disadvantage: its more code 

// public class Main {
//     public static void main(String[] args) throws Exception {
//         //we cannot call the start method because the only method that Thread1 has is run
//         //so we are creating an object like before but we gonna pass it to a Thread obj that have a start method 
        
        
//         // am regaya xalata
//         // Test t2 = new Test();
//         // t2.start();
        
        
//         // ama rasta 
//         Test t1 = new Test();
//         Thread thread1 = new Thread(t1);
//         thread1.start();
        
//         Thread t23 = new Thread(new Test());
//         t23.start();

//     }
// }
// // class TestThread extends Thread
// class Test implements Runnable  {
    
//     public void run() {
//         while (true) {
//             System.out.println("Running Thread1");
//         }
//     }
// }



//-----------------------------------------------------------

// //!for things that happen once, not on a regular basis, use the annonymous class
// public class Main {
//     public static void main(String[] args) throws Exception {
//        Runnable r = new Runnable() {
//             //this means that: java create a class and make this class implement the class runnable
//             public void run(){
//                 while (true) {
//                     System.out.println("InnerClass");
//                 }
//             }
//        };
    
//        Thread t = new Thread(r);
//         t.start(); 
//     }
// }

//-----------------------------------------------------------
// //! creatin infinite threads
// //? Write a small java application to create inifinte Threads each printing your name infinetely
// public class Main {
//     public static void main(String[] args) throws Exception {
        
//        Runnable r = new Runnable() {
//             public void run(){
//                 for(;true;){
//                     System.out.println("InnerClass");
//                 }
//             }
//        }; 
//        while (true) {
//            Thread t2 = new Thread(r);
//            t2.start();
//        }
      
//     }
// }

//-----------------------------------------------------------

// public class Main {
//     public static void main(String[] args) throws Exception {
//        Runnable r = new Runnable() {
//             public void run(){
//                 while(true){
//                     System.out.println("InnerClass");
//                 }
//             }
//        }; 
//        for (int i =0; i < 14; i++) {
//            Thread t2 = new Thread(r);
//            t2.start();
//        }
      
//     }
// }
//-----------------------------------------------------------

// //!what if we had only 8 available cores ?, and we have 15 Thread
// //  only 8 of them run at the same time, but it looks like all of them are running at the same time 
// //  scheduling, context switching, shareing resources--------------> Concurrrency 
// //  parallelism: multiple tasks runnning at the same time
// //  we are running 15 Threads concurently, and 8 Threads in parallel



//! If you have 8 cores and you create 8 threads, that can potentially achieve parallelism, but it depends on how the threads are scheduled and how much CPU time each thread requires.

//! If the operating system is able to schedule each thread to run on a separate core, and each thread requires significant CPU time, then the threads can run in parallel, taking advantage of all 8 cores.

//! However, if the operating system is not able to schedule each thread to run on a separate core (e.g., due to contention for other system resources), or if each thread does not require significant CPU time
//!  (e.g., if the threads are mostly waiting for I/O or synchronization), then the threads may not run in parallel, and instead may run concurrently on fewer than 8 cores. In this case, the program is still
//!   using multithreading for concurrency, but not necessarily achieving parallelism.



// public class Main {
//     public static void main(String[] args) throws Exception {
//        Runnable r = new Runnable() {
//             public void run(){
//                 while(true){
//                     System.out.println("InnerClass");
//                 }
//             }
//        }; 
//        for (int i =0; i < 14; i++) {
//            Thread t2 = new Thread(r);
//            t2.start();
//        }
      
//     }
// }

//-----------------------------------------------------------
// //!lets say we have 8 cores is it faster to use 300 Threads to do the a task or do it with 14 Threads 
// public class Main {
//     public static void main(String[] args) throws Exception {
//        Runnable r = new Runnable() {
//             public void run(){
//                 while(true){
//                     System.out.println("InnerClass");
//                 }
//             }
//        }; 
//        for (int i =0; i < 300; i++) {
//            Thread t2 = new Thread(r);
//            t2.start();
//        }
      
//     }
// }


//--------------------

// //? class lab:  Medium-difficulty  ----- Create 24 Threads, each thread should print the follwoing phrase 10, 000 times : "Printed from Thread #"; start all threads together
// //? Taks 2: Install VisuallVm on your machine and profile your application while its running.

public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 24; i++) {
            int threadNumber = i;
            Runnable r = new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        System.out.println("Printed from Thread " + threadNumber + "iteration number" + j);
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}

