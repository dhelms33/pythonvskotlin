import java.util.Arrays;  
import java.lang.Thread; // only to show a timing example (you won't need this)


public class java_example {


   public static int[] run() {
      int[] arr = new int[100];

      // this will not be needed in your program
      // it is only here to show a time delay when this function runs
      try
      {
        Thread.sleep(2000);
      }
      catch(InterruptedException e)
      {
        // do something
      }

      return arr;   
   }


   public static void main(String args[]){

      java_example myalgo = new java_example();

      // open the appropriate .txt file for your chosen assignment and load it
      // into the appropriate data structure to be run by your chosen algorithm 

      long start = System.currentTimeMillis();
      int[] solution = myalgo.run(); // pass input to the algorithm that is needed
      long end = System.currentTimeMillis();      

      System.out.println("My algorithm solution (or first part of it): ");

      System.out.println("My algorithm runtime (in milliseconds): " + (end-start));

   }
}
