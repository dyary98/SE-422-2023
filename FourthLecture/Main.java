// //__________________________________________________________________________________________
//Install better comments exstension

// //! Data corruption & Data inconsistency ----- Race condition
// package FourthLecture;
// //This probelm will occure in multi Threeading enviroment 
// // Second Requiremnt for this to happen is a shared variable (passed by refrence)
// public class Main {
//     public static void main(String[] args) {
//         // System.out.println(t.next());
//         // System.out.println(t.next());
//         // System.out.println(t.next());
        
//         // new Worker(t).start();
//         // new Worker(t).start();
//         //its as same as
//         Ticket t = new Ticket();

//         Worker w1 = new Worker(t);
//         w1.start();

//         Worker w2 = new Worker(t);
//         w2.start();
        
//     }
// }
// class Worker extends Thread{
//     Ticket ticket;
//     public Worker(Ticket t){
//         this.ticket= t;
//     }
//     @Override 
//     public void run(){
//         while (true) {
          
//             int i = ticket.next();  
//             try {
//                 System.out.println( getName() + " " + i);
//                 this.sleep(500); //.5s
//             } catch (Exception e) {
//                 System.err.println(e.getMessage());
//             }
//         }
//     }

// }
// class Ticket {
//     private int counter;
   
//     public int next(){
//         counter++;
//         return counter;
//     } 
// }


//__________________________________________________________________________________________



// //! Pass by refrence --- Bad practise this one cause they are not unified, you get the same ids for both 
// package FourthLecture;

// public class Main {
//     public static void main(String[] args) {
//         Ticket t = new Ticket();
//         Ticket t2 = new Ticket();
        
//         new Worker(t).start();;
//         new Worker(t2).start();;
        
//     }
// }
// class Worker extends Thread{
//     Ticket ticket;
//     public Worker(Ticket t){
//         this.ticket= t;
//     }
//     @Override 
//     public void run(){
//         while (true) {
//             int i = ticket.next();
//             try {
//                 System.out.println("Thread #" + getName() + " " + i);
//                 this.sleep(1000);
//             } catch (Exception e) {
//                 System.err.println(e.getMessage());
//             }
//         }
//     }

// }
// class Ticket {
//     private int counter;
//     public int next(){
//         counter++;
//         return counter;
//     } 
// }



//__________________________________________________________________________________________


// //! SOl/1 --- synchronized 
// package FourthLecture;
// public class Main {
//     public static void main(String[] args) {
//         Ticket t = new Ticket();
        
//         new Worker(t).start();;
//         new Worker(t).start();;
//     }
// }
// class Worker extends Thread{
//     Ticket ticket;
//     public Worker(Ticket t){
//         this.ticket= t;
//     }
//     @Override 
//     public void run(){
//         while (true) {
//             int i = ticket.next();
//             try {
//                 System.out.println("Thread #" + getName() + " " + i);
//                 this.sleep(500);
//             } catch (Exception e) {
//                 System.err.println(e.getMessage());
//             }
//         }
//     }

// }
// class Ticket {
//     private int counter;
//     //synchronized means hey java only one thread can execute next at a time 
//     public synchronized int next(){
//         counter++;
//         return counter;
//     } 
// }



//__________________________________________________________________________________________
// !Terms
// synchronized is a java thing: one way to acheive Thread Safety
// Synchronized : mutual excclusion: you have a piece of code, part of that code need to be executed by one thread at a time.
// critical section: In a multi-threaded application, a critical section is a piece of code that can only be executed by one thread at a time. The purpose of a critical section is to prevent concurrent access to shared resources or variables, which can lead to data inconsistency or corruption.
// Monitor : blocking mechanism allows you to acheive mutual exclusion
// when we use synchronized next to a method, Thread 0 execute run before executing thread 0 need to aquire that obj, thread 0 loocks the object if t1 tries to aquire that obj itis locked and it can not use it 
package FourthLecture;
public class Main {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        
        new Worker(t).start();;
        new Worker(t).start();;
    }
}
class Worker extends Thread{
    Ticket ticket;
    public Worker(Ticket t){
        this.ticket= t;
    }
    @Override 
    public void run(){
        while (true) {
            int i = ticket.next();
            try {
                System.out.println("Thread #" + getName() + " " + i);
                this.sleep(1000);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
class Ticket {
    private int counter;

    
    public  int next(){
        synchronized(this){
            counter++;
        }
        System.out.println(counter);
        return counter;
    } 

    public synchronized int next2(){
        counter++;
        System.out.println(counter);
        return counter;
    }
}

// //!you can not use synchronized keyword with primitive data types, you have to do the above wrapping and those kind of stuff