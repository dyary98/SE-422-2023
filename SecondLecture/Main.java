// package SecondLecture;
// public class Main {
//     public static void main(String[] args) throws Exception {
//         Thread t1 = new Thread1();
//         //Thread1 t1 = new Thread1() 
//         t1.start();

//     }
// }

// class Thread1 extends Thread {
    
//     @Override
//     public void run() {
        
//     }
//     //you can not write static with the run method of the Thread Class, because it does not have static inside the Thread class
// }



//-----------------------------------------------------------


// //!I can not add two super classes to another class, or in other words i cannot extend two classes
// //solution : dont extend Thread but rather implement Runnable

// //advantage : you can extend other classes for your class

// //disadvantage: its more code 

// package SecondLecture;
// public class Main {
//     public static void main(String[] args) throws Exception {
//         //we cannot call the start method because the only method that Thread1 has is run
//         //so we are creating an object like before but we gonna pass it to a Thread obj that have a start method 
//         Thread t1 = new Thread(new Thread1());
//         t1.start();
//     }
// }

// class Thread1 implements Runnable {
    
//     @Override
//     public void run() {
//         while (true) {
//             System.out.println("Running Thread1");
//         }
//     }
// }



//-----------------------------------------------------------

// //!for things that happen once not on a regular basis, use the annonymous class
// package SecondLecture;
// public class Main {
//     public static void main(String[] args) throws Exception {
//        Runnable r = new Runnable() {
//         //this means that: java create a class and make this class implement the class runnable
//         public void run(){
//             System.out.println("InnerClass");
//         }
//        }; 
      
//     }
// }

// class Thread1 implements Runnable {
    
//     @Override
//     public void run() {
//         while (true) {
//             System.out.println("Running Thread1");
//         }
//     }
// }



//-----------------------------------------------------------

// package SecondLecture;
// public class Main {
//     public static void main(String[] args) throws Exception {
//        Runnable r = new Runnable() {
//             public void run(){
//                 System.out.println("InnerClass");
//             }
//        }; 
//        while (true) {
//            Thread t2 = new Thread(r);
//            t2.start();
//        }
      
//     }
// }

//-----------------------------------------------------------

// package SecondLecture;
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

// //!what if we had only 8 cores ?, and we have 15 Thread
// //only 8 of them run at the same time, but it looks like all of them are running at the same time 
// //scheduling, context switching, shareing resources--------------> Concurrrency 
// // parallelism: multiple tasks runnning at the same time
// // we are running 15 Threads concurently, and 8 Threads in parallel 
// package SecondLecture;
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

// package SecondLecture;
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

//? class lab:  Medium-difficulty  ----- Create 24 Threads, each thread should print the follwoing phrase 10, 000 times : "Printed from Thread #"; start all threads together
//? Taks 2: Install VisuallVm on your machine and profile your application while its running.


package SecondLecture;
public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 24; i++) {

            int threadNum = i;
            Thread thread = new Thread(() -> {
                for (int j = 1; j <= 10000; j++) {
                    System.out.println("Printed from Thread number " + threadNum + "iteration Number: " + j);
                }
            });
            thread.start();
        }
      
    }
}

