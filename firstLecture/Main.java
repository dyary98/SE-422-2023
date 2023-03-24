// package firstLecture;
//Install better comments exstension


// public class Main {

//     public static void main(String[] args) {
        
//         System.out.println("Beg Main");

//         //below infinite loop
//         PrintTask t1 = new PrintTask();
//         t1.runTask();
//         //!the lines below wont be executed because it does not reach their
//         PrintTask t2 = new PrintTask();
//         t2.runTask();
        
//     }
// }

//  class PrintTask {
//     public void runTask() {
//         for (long i = 0 ; true; i++) {
//             System.out.println("Auis");
//         }
//     }
    
// }




//---------------------------------------------------




// //!multithreading for the rescue
// //you create branches that can be executed at the same time 


// public class Main {

//     public static void main(String[] args) {
        
//         System.out.println("Beg Main");
//         PrintTask t1 = new PrintTask();
//         PrintTask t2 = new PrintTask();
//         //starts the run method
        
//         t1.start();
//         t2.start();
        
//     }
// }

//  class PrintTask extends Thread {

//     //we need to override a method that is already inside the Thread class
//     // the run method been declared in the Thread class but not initialized
    
//     @Override
//     public void run() {
//         System.out.println("Hello from Thread");
//     }
    
// }

// //we see heloo from thread 2 times each from one thread, they are different from each other




//------------------------------------------------------



// // package firstLecture;

// public class Main {

//     public static void main(String[] args) {
        
//         System.out.println("Beg Main");

//         PrintTask t1 = new PrintTask();
//         PrintTask t2 = new PrintTask();
//         t1.start();
//         t2.start();
//         //! these thread run in paralel and if you have enough cores they should work in paralel
//         //the problem that sometimes you see to different range of numbers when u run the code is because--
//         // -- one core might be slower than the other and it will create the difference 
        
//     }
// }
//  class PrintTask extends Thread {
//     public void run() {
//         for (long i = 0 ; true; i++) {
//             System.out.println(i);
//         }
//     }
    
// }


//----------------------------------------------



// public class Main {

//     public static void main(String[] args) {
        
//         System.out.println("Beg Main");

    
//         PrintAUIS t1 = new PrintAUIS();
//         PrintSe422 t2 = new PrintSe422();
//         t1.start();
//         t2.start();
//         //!prove that the main class dont have any loops in it 
//         // if we see the following line in our code proves that the infinite loops are not inside the Main thread but rahter in the other Threads
//         System.out.println("Hello from Main");
        
//     }
// }

//  class PrintAUIS extends Thread {
//     public void run() {
//         for (long i = 0 ; true; i++) {
//             System.out.print("AUIS");
//         }
//     }
    
// }
//  class PrintSe422 extends Thread {
//     public void run() {
//         for (long i = 0 ; true; i++) {
//             System.out.print("SE422 ");
//         }
//     }
    
// }


//------------------------------------------------------


// //?in class lab
// //? Print your name, Email, age, the course u r taking today, each print should run under a different Thread

// public class Main {

//     public static void main(String[] args) {
    
//         PrintName t1 = new PrintName();
//         PrintEmail t2 = new PrintEmail();
//         PrintAge t3 = new PrintAge();
//         PrintTodaysCourse t4 = new PrintTodaysCourse();
//         t1.start();
//         t2.start();
//         t3.start();
//         t4.start();
//         System.out.println("Main Thread is done");
//         // for (int i = 0; true; i++) {
//         //     System.out.println("Dyary");
//         // }
//     }
// }

//  class PrintName extends Thread {
//     public void run() {
//         System.out.println("Dyary");
//     }
    
// }
//  class PrintEmail extends Thread {
//     public void run() {
//             System.out.println("dy19179@auis.edu.krd");
//     }
    
// }
//  class PrintAge extends Thread {
//     public void run() {
//         System.out.println("21");
//     }
    
// }
//  class PrintTodaysCourse extends Thread {
//     public void run() {
//         System.out.println("SE422");
//     }
    
// }

// ----------------------------------------------------


// public class Main {

//     public static void main(String[] args) {
    
//         PrintName t1 = new PrintName();
//         PrintEmail t2 = new PrintEmail();
//         PrintAge t3 = new PrintAge();
//         PrintTodaysCourse t4 = new PrintTodaysCourse();
//         // for (int i = 0; i<1000; i++) {
//         //     System.out.println("Dyary");
//         // }
//         t1.run();
//         t2.run();
//         t3.run();
//         t4.run();

//         //!the lines above does not create threads but rahter behaves just like any other object 
//         //!in plane english this is not multithreading 
//     }
// }

//  class PrintName extends Thread {
//     public void run() {
//         System.out.println("Dyary");
//     }
    
// }
//  class PrintEmail extends Thread {
//     public void run() {
//         System.out.println("dy19179@auis.edu.krd");
//     }
    
// }
//  class PrintAge extends Thread {
//     public void run() {
//         System.out.println("21");
//     }
    
// }
//  class PrintTodaysCourse extends Thread {
//     public void run() {
//         System.out.println("SE422");
//     }
    
// }



// //?Create 7 Threads and each one of them print your name in endless loop


// public class Main {

//     public static void main(String[] args) {
    
//         PrintName t1 = new PrintName();
//         PrintName t2 = new PrintName();
//         PrintName t3 = new PrintName();
//         PrintName t4 = new PrintName();
//         PrintName t5 = new PrintName();
//         PrintName t6 = new PrintName();
//         PrintName t7 = new PrintName();
        
//         t1.start();
//         t2.start();
//         t3.start();
//         t4.start();
//         t5.start();
//         t6.start();
//         t7.start();
//     }
// }

//  class PrintName extends Thread {

//     @Override
//     public void run() {
//         while(true){
//             System.out.print("dyary");        }
//     }
//  }




