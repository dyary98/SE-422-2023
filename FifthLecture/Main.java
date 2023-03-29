

// //! TERMS: 
// Critical Area: The unsafe area of your code
//Entry set: acts as a Q, it will contain the waiting threads to aquire the lock 
// public class Main {
//     public static void main(String[] args) {
        
//     }
// }





//__________________________________________________________________________________________

// //! RECAP
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
//     public synchronized int next(){
//         // t1 aquire the lock
//         // t1 lockled
//         // t2 tries to Acquire the lock, but it can not untill t1 unlocks the lock 
//         counter++;
//         return counter;
//         //Unlock the current obj
//     } 
// }


// The more threads you have without thread safety practises you will see more data corruption 
//but with synchronize does not matter  


//__________________________________________________________________________________________


// public class Main {
//     public static void main(String[] args) {
//         Ticket t = new Ticket();
//         Ticket t2 = new Ticket();
        
//         //These two will colaborate together
//         new Worker(t).start();
//         new Worker(t).start();
        
//         //These two will colaborate together, and does not effect the ones above and vice versa
//         new Worker(t2).start();
//         new Worker(t2).start();
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
//     public synchronized int next(){
//         counter++;
//         return counter;
      
//     } 
// }


//__________________________________________________________________________________________
// //! Static
// //! when using static, try your best not use it with primitive data types because

// // lets say you have two objs, t1 and t2 and inside the ticket class you have a static variable which is shared between them, ..
// // you can add synchronize and lock the first obj so that no longer any thread that are using t1 use the obj ..
// // but the problem is cause you have a static var, you can modify the var from the secooond obj cause they both have the same var

// public class Main {
//     public static void main(String[] args) {
//         Ticket t = new Ticket();
//         Ticket t2 = new Ticket();
        
//         //These two will colaborate together
//         new Worker(t).start();
//         new Worker(t).start();
        
//         //These two will colaborate together, and does not effect the ones above and vice versa
//         new Worker(t2).start();
//         new Worker(t2).start();
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
    //The keyword static, no matter how many objects you have all of them has the same counter variable 
//     private static int counter;
//     public synchronized int next(){
//         counter++;
//         return counter;
      
//     } 
// }



//__________________________________________________________________________________________


// //! synchronized this

// public class Main {
//     public static void main(String[] args) {
//         Ticket t2 = new Ticket();
//         new Worker(t2).start();
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
//     private static int counter;
//     public synchronized int next() throws InterruptedException{
//         counter++;
//         Thread.sleep(1000*10);
//         return counter;
//     } 
// }
// class TicketModifeid {
//         private static int counter;
//         public int next() throws InterruptedException{
//                 synchronized(this){
//                         counter++;
//                     }
//                     Thread.sleep(1000*10);
//                     return counter;
//                 } 
//             }
//             //? what if 10 threads enter inside the 10 second sleep, when we return the value it is the latest one
            
//__________________________________________________________________________________________

// //! performance optimiazation
// public class Main {
//     public static void main(String[] args) {
//         // Ticket t2 = new Ticket();
        
//         //These two will colaborate together
//         Ticket t = new Ticket();
//         new Worker(t).start();
//         new Worker(t).start();
        
//         //These two will colaborate together, and does not effect the ones above and vice versa
//         // new Worker(t2).start();
//         // new Worker(t2).start();
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

// class NumberLock {
//     //claaseki be ma3na
// }
// class Ticket {
//     private static int counterA;
//     private static int counterB;

//     private NumberLock lockA;
//     private NumberLock lockB;

//     public Ticket(){
//         //creating two meanningless objects
//         lockA  = new NumberLock();
//         lockB  = new NumberLock();
//     }
//     public int next(){
        
//         synchronized(lockA){
//             counterA++;
//             return counterA;
//         }
//     } 

//     public int previous(){
        
//         synchronized(lockB){
//             counterB++;
//             return counterB;
//         }
//     }
 
// }
//__________________________________________________________________________________________

//! test your critical thinking 

public class Main {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Ticket t2 = new Ticket();
        
        //These two will colaborate together
        new Worker(t).start();
        new Worker(t).start();
        
        //These two will colaborate together, and does not effect the ones above and vice versa
        new Worker(t2).start();
        new Worker(t2).start();
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
                this.sleep(500);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
}

class NumberLock {
    
}
class Ticket {
    private static int counterA;
    private static int counterB;
    
    private NumberLock lockA;
    private NumberLock lockB;
    
    public Ticket(){
        //creating two meanningless objects
        lockA  = new NumberLock();
        lockB  = new NumberLock();
    }
    public int next(){
        synchronized(lockA){
            counterA++;
            return counterA;
        }
    } 

    public int previous(){
        synchronized(lockB){
            counterB++;
            return counterB;
        }
    }
    //these two methods, are doing the same thing but with some modifications 
    
    //this ones is pass by reference, here we need to add synchronize to ensure thread safety
    public int read(){
        int result = counterA; 
        result *= 10;
        return result - counterA ; 
    }
    
    //this one is pass by value, here we dont need it cause the values wont change
    public int readVariant(){
        int value = counterA; 
        int result = value; 
        result *= 10;
        return result - value ; 
    }
 
}




//__________________________________________________________________________________________

////! how to unlock a threads lock once it has been aquired 

//first you must aquire the lock, then you must have locked the obj, enorder to unlock it we use the key word wait() after the lockobj .... lockObj.wait(), this will put the thread into the "Wait set" data structure of the monitor obj
// inorder to re-lock it again you must use the keyword notify() after the lockobj... lockObj.notify()........ we have another one lockObj.notifyAll()