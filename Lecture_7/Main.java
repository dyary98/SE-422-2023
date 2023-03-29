package Lecture_7;
//today is two parts; part one introduction--- part two implementation
// !The problem of concurrency and parallelism
// There is a clear relationship between the threads you have and the logical cores in cpu or in your system
//* */ scenario 01 imagine we are dealing with complex algo, it requires a couple of steps to execute, each step is cpu intensive (video processing). which runs faster you have 8 cores 
// 200 threads only 9 execute 
// 8 threads is faster, u dont have switching  (eliminating overhead)
// we are using a builtin library to achieve this(not creating many threads) it is called ThreadPool 
//you should not use Thread Class like we did before, you need to import some classes from different packages, it is called executorService and Executors 
//Thread pool needs runnable implementation not Thread if you use Thread you will end up with creating many threads

// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class Main {
//     public static void main(String[] args) {
//         for (int i = 0; i < 20; i++) {
//             Thread t = new Thread(new Task());
//             t.start();
//         }
//     }
// }

// class Task implements Runnable{
//     public void run(){
//         for (int i = 0; true; i++) {
//             System.out.println(i);
//             Thread t1 = new Thread(){
//                 public void run(){
//                     System.out.println();
//                 }
//             };
//         }
//     }
// }

///---------------------------------------------------
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class Main {
//     public static void main(String[] args) {
//         //provides you with static methods
//         ExecutorService pool = Executors.newFixedThreadPool(10);//size of the thread // here we have 10 threads
//         //ExecutorService is a class that allows you to create threadpools, but we have different thread pools, the first type is called FixedThreadpool: when this line executers immediately java will run 10 threads for you, they are ready for the code you provide for the, 
//         for (int i = 0; i < 20; i++) {
//             // we have 10 threads and 20 tasks
//             pool.submit(new Task());

//             // we have a Q, it will hold the waiting tasks
           
//         }
//         // the threadpools we created the 10 ones wont die termiante if they finieshed executing the tasks

//     }
// }

// class Task implements Runnable{
//     public void run(){
//         for (int i = 0; true; i++) {
//             System.out.println(i);
//             Thread t1 = new Thread(){
//                 public void run(){
//                     System.out.println();
//                 }
//             };
//         }
//     }
// }

///---------------------------------------------------
//! what is the best size for the Q
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors(); // it will tell you your logical cores
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < 20; i++) {
            pool.submit(new Task());           
        }
    }
}

class Task implements Runnable{
    public void run(){
        for (int i = 0; true; i++) {
            System.out.println(i);
            Thread t1 = new Thread(){
                public void run(){
                    System.out.println();
                }
            };
        }
    }
}

//_______________________part One 