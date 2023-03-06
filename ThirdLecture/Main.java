// // 7:12
// //!Life Cycle of a Thread Object 
// // we have some states that we have to be aware of. The first state when we create a Thread Obj is called New, here you only created a new object or a new Thread nothing fancy.
// // Second State (Runnable) comes when we call the .start() method, which means that we are ready for executing the code in the run method, here we havent called the run method yet, it waits for the operating system to start it, might be busy with other things
// // Third state (Running) in this state we are actually executing the code, which is in the run method.

// //              New State _______________stop()_______________> Dead
// //                  ||
// //                  || start()
// //                  ||
// //     resume()     \/
// //   --------> Runnable _______________stop()_______________> Dead
// //   | notify()      ||            /\
// //   |               || run()      || yield()
// //   |               ||            ||
// //   |               \/            || 
// //   |           Running _______________End of Execution_______________> Dead
// //   |               ||
// //   |               || suspend(), wait(), delete()
// //   |               ||
// //   |               \/
// //   ___________Blocked _______________stop()_______________> Dead

// // There is no way in which we can go back to the new state(A Thread once started you can not start it again)

// package ThirdLecture;

// public class Main {
//     public static void main(String[] args) {
//         //New state
//         Thread w1 = new Worker1();
//         Thread w2 = new Worker2();

//         //runnable state
//         w1.start();
        
//         //runnable state
//         w2.start();

//         w1 = new Worker1();
//         w1.start();
//     }
// }

// class Worker1 extends Thread{
//     @Override
//     public void run(){

//     }
// }

// class Worker2 extends Thread{
//     @Override
//     public void run(){
        
//     }
// }




//___________________________________________________________________________



// //!When a Java program starts, it creates a main thread that is a non-daemon thread. If the main thread creates additional threads and any of them are marked as daemon threads using the setDaemon(true) method, then the JVM will terminate when all non-daemon threads have completed, regardless of whether the daemon threads have finished their work.
// package ThirdLecture;

// public class Main {
//     public static void main(String[] args) {
      
//         Thread w1 = new Worker1();
//         Thread w2 = new Worker2();

//         w1.setDaemon(true);
//         w2.setDaemon(false);
//         w1.start();
//         w2.start();

//     }
// }

// class Worker1 extends Thread{
//     @Override
//     public void run(){
//         for (int i = 0; i < 100000; i++) {
//             System.out.print("Thread 1 :" + i + " " );
//             //it Will put it into blocked state
//             try {
//                 sleep(1000);
//             } catch (InterruptedException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }

//         }
//     }
// }

// class Worker2 extends Thread{
//     @Override
//     public void run(){
//         for (int i = 0; i < 100000; i++) {
//             System.out.print("Thread 2 :" + i  + " " );
//             //it Will put it into blocked state
//             try {
//                 sleep(i);
//             } catch (InterruptedException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         }
//     }
// }


// -----------------------------------------------------------------------------

// //! When a thread is in blocked state it will not use cpu power, you reduce memory consumption
// package ThirdLecture;

// public class Main {
//     public static void main(String[] args) throws InterruptedException {
      
//         Thread w1 = new Worker1();
//         Thread w2 = new Worker2();

//         w1.setDaemon(true);
//         w2.setDaemon(false);
//         w1.start();
//         w2.start();
        
//         //We can not do the following in the main Thread
//         // sleep(1000) we have to do 
//         Thread.sleep(3000);
//     }
// }

// class Worker1 extends Thread{
//     @Override
//     public void run(){
//         for (int i = 0; i < 100000; i++) {
//             System.out.print("Thread 1 :" + i + " " );
//             //it Will put it into blocked state
//             try {
//                 sleep(1000);
//             } catch (InterruptedException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }

//         }
//     }
// }

// class Worker2 extends Thread{
//     @Override
//     public void run(){
//         for (int i = 0; i < 100000; i++) {
//             System.out.print("Thread 2 :" + i  + " " );
//             //it Will put it into blocked state
//             try {
//                 sleep(i);
//             } catch (InterruptedException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         }
//     }
// }


//------------------------------------------------------


// //! In class Lab
// //? Write a simple java application to print your name every 5 secs

// package ThirdLecture;

// public class Main {
//     public static void main(String[] args) throws InterruptedException {
      
//         for (int i = 0; i < 1000; i++) {
//             System.out.println("Dyary");
//             Thread.sleep(5000);
//         }
    
//     }
// }



//------------------------------------------------------

// //! sleep in Interface
// package ThirdLecture;
// public class Main {
//     public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Worker1()); 
//        t1.start();
//     }
// }

// class Worker1 implements Runnable {

//         @Override
//         public void run() {
          
//             try {
//                 for (int i = 0; i < 1000; i++) {
//                     Thread.sleep(1000);
//                     System.out.println("slaw");
//                 }
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
            
//         }
    
// }

//------------------------------------------------------

//! Second In-Class Lab
// //? Write a simple java application to print your name every 5 secs for the next two hours

// package ThirdLecture;

// public class Main {
//     public static void main(String[] args) {
        
//         Thread t1 = new Thread(new NamePrinter());
//         t1.start();    
//     }
// }
// class NamePrinter implements Runnable {

//     public void run() {
//         try {
//             for (int i = 0; i < 1440; i++) { //1440 * 5 = 7200 secs
//                 System.out.println("Sa3a");
//                 Thread.sleep(5000); 
//             }
//         } catch (InterruptedException e) {
//             System.out.println("Thread interrupted");
//         }
//     }
// }



//------------------------------------------------------

//! How to terminate or change a Thread state into dead state
//1:02:00
// package ThirdLecture;
// public class Main {
//     public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Worker1()); 
//        Thread t2 = new Thread(new Worker2()); 
//        t1.start();
//        t2.start();
//     }
// }

// class Worker1 extends Thread  {
//         @Override
//         public void run() {
//             try {

//                 //stops after 5 secs
//                 for (int i = 0; i < 1000; i++) {
//                     System.out.println("worker 1 " + i);
//                     if(i == 5) break;
//                     //if(i == 5) return;
//                     Thread.sleep(1000);
                    
//                 }
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
            
//         }
// }
// class Worker2 extends Thread {
//         @Override
//         public void run() {
          
//             try {
//                 for (int i = 0; i < 1000; i++) {
//                     System.out.println("Worker 2 " + i);
//                     Thread.sleep(1000);
//                 }
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
            
//         }
// }


//------------------------------------------------------
//! Create Two threads the second thread should start the first Thread after 5 seconds

package ThirdLecture;
public class Main {
    public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Worker1(); 
       Thread t2 = new Worker2(t1); 
       t2.start();
  
    }
}

class Worker1 extends Thread  {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("worker 1 " + i);
                    if(i == 5) break;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
}
class Worker2 extends Thread {
    Thread t1;
    public Worker2(Thread t1){
        this.t1 = t1;
    }
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                t1.start();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
}


//Interupt will triger the InterruptedException catch 
// suspend will put the thread into the blocked state forever unless you call resume it will resume the thread
//stop kills the thread and puts it into the dead state
