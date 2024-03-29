package Lecture9;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//!Callable and Complex Thread flows
//?starting the lecture with a lab,
//? write your application to do the foollowing, a threadpool to submit the following task, 
//? task1: compute the result of 1+2+3....+10, 000
//? print the result in the main thread

// the problem here are 
// how can you print the result in the main, you have done the computation in a different thread
//! use getResult method and return the result
// how can you print it at the right time?

// class ComputeSum implements Runnable{
//     private int limit;
//     private int result;

//     public ComputeSum(int limit){
//         this.limit = limit;
//     }
//     public int getResult() {
//         return result;
//     }
//     @Override
//     public void run() {
//         for (int i = 0; i < limit + 1; i++) {
//             result += i;
//         }
//     }
// }
// public class Main {

//     public static void main(String[] args) {
//         ExecutorService pool = Executors.newFixedThreadPool(1);   
//         ComputeSum cs = new ComputeSum(10000);
//         pool.submit(cs);
//         System.out.println("the result: "+cs.getResult());
//         //!if you run this code you will get the result: 0
//         // because the sysout is retriving the result value, in a time where the computation havent started yet
//         //two ways to fix this: Ugly way and goodway
//         //Thread.sleep(10000); it is not practical cause you dont know when its gonna end the task i mean 
//     }
// }
//!----------------------------------------------------------------------
//!----------------------------------------------------------------------
//!----------------------------------------------------------------------
//!----------------------------------------------------------------------

// class ComputeSum implements Callable<Integer>{ //ishi ama away zhmara la iak tawakw limit kobkatawa
//     private int limit;
//     private int result;

//     public ComputeSum(int limit){
//         this.limit = limit;
//     }
//     public int getResult() {
//         return result;
//     }
    
    
//     @Override
//     public Integer call() {
//         for (int i = 0; i < limit + 1; i++) {
//             result += i;
//         }
//         return result;
//     }
// }
// public class Main {

//     public static void main(String[] args) throws InterruptedException, ExecutionException {
        
//         ExecutorService pool = Executors.newFixedThreadPool(1);   //yak thread drwst krawa
//         ComputeSum cs = new ComputeSum(10000); // zhmarakanman la 0 tawkaw 100000 sum krdwa
        
//         Future<Integer> futre = pool.submit(cs); // 7sabka task tekrdwa
        
//         System.out.println("the result using the old way: "+cs.getResult());

//         System.out.println("the result: "+futre.get()); // am method
//         // a ishaka awastene 

//         System.out.println("the result using : "+cs.getResult());

//         //!if you run this code you will get the result: 0
//         // because the sysout is retriving the result value, in a time where the computation havent started yet
//         //two ways to fix this: Ugly way and goodway
//         //Thread.sleep(10000); it is not practical cause you dont know when its gonna end the task i mean 
//     }
// }




//  class ComputeResult {
//     public int sum;
//     public long fact;
// }

//  class ComputeSum implements Callable<ComputeResult> {

//     private int limit;
//     private int result;
//     public long factorial = 1;

//     public ComputeSum(int limit){
//         this.limit = limit;
//     }
//     public int getResult() {
//         return result;
//     }
    
    
//     @Override
//     public ComputeResult call() {
//         ComputeResult object1 = new ComputeResult();
//         for (int i = 0; i < limit + 1; i++) {
//             result += i;
//         }
//         object1.sum = result;
//         for (int i = 1; i < limit + 1; i++) {
//             factorial *= i;
//             System.out.println(factorial +" ");
//         }
//         object1.fact =factorial;
//         return object1;
//     }
// }


// public class Main {

//     public static void main(String[] args) throws InterruptedException, ExecutionException {
//         ExecutorService pool = Executors.newFixedThreadPool(1);   
//         ComputeSum cs = new ComputeSum(10000); //callable yan task 
//         Future<ComputeResult> f = pool.submit(cs);
//         ComputeResult response = f.get(); // awaste hatawkw responsaki pe aga         
//         System.out.println(response.sum);
//         System.out.println(response.fact);
//     }
// }








 class ComputeResult {
    public int sum;
    public long fact;
}
/**
 * ComputeSum 
 */
 class ComputeSum implements Callable<ComputeResult> {

    private int limit;
    private int result;
    public long factorial = 1;

    public ComputeSum(int limit){
        this.limit = limit;
    }
    public int getResult() {
        return result;
    }
    
    
    @Override
    public ComputeResult call() {
        ComputeResult object1 = new ComputeResult();
        for (int i = 0; i < limit + 1; i++) {
            result += i;
        }
        object1.sum = result;
        for (int i = 1; i < limit + 1; i++) {
            factorial *= i;
            System.out.println(factorial +" ");
        }
        object1.fact =factorial;
        return object1;
    }
}


// public class Main {

//     public static void main(String[] args) throws InterruptedException, ExecutionException {
//         ExecutorService pool = Executors.newFixedThreadPool(10);   


//         ExecutorService pool2 = Executors.newFixedThreadPool(100);   
//         CompletableFuture.supplyAsync(() -> getOrder(), pool)
//         .thenApply(order -> processOrder(order), pool)
//         .thenApplyAsync(details -> saveToDb(details), pool2).thenAccept();

       
//     }
//     public static Integer getOrder(){
//         System.out.println( Thread.currentThread().getName());   
//         return 1;
//     }
//     public static Integer processOrder(Integer num){
//         System.out.println( Thread.currentThread().getName());   
//         return num + 1;
//     }
//     public int saveToDb(int num){
//         System.out.println( Thread.currentThread().getName());   
//         return num + 1;
//     }
// }


// public class Main {

//     public static void main(String[] args) {
        
//         ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 100, 10L, TimeUnit.SECONDS, LinkedBlockingQueue<Runnable>());
//         //thread 1 ---------------- > 100 -------------- queue
//         for (int i = 0; i < 30; i++) {
//             executor.submit(new Task());
//         }
//     }
// }