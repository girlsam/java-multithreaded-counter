package PortfolioMilestone_2_Option1;

import java.util.concurrent.locks.ReentrantLock;

public class IncrementThread implements Runnable {
  // local variables
  private static ReentrantLock lock;
  private static Counter counter;
  private static final int MAX_COUNT = 20;

  /**
   * Constructor to instantiate IncrementThread with
   * reference to a counter and lock
   * 
   * @param _counter instance of Counter
   * @param _lock instance of ReentrantLock
   */
  public IncrementThread(Counter _counter, ReentrantLock _lock) {
    counter = _counter;
    lock = _lock;
  }
  
  /**
   * Acquires lock and increment Counter from 
   * Counter.count's current value to ceiling value
   * 
   * @param counter   reference to counter
   * @param ceiling   Value to increment up to
   */
  private static void increment(Counter counter, int ceiling) {
    lock.lock(); // acquire lock

    try {
      System.out.println("--START INCREMENT--");
      // set starting index at current value of count
      int index = counter.getCount();
      counter.printCount(); // print current count

      while (index < ceiling) { // while index is less than ceiling
        counter.increment(); // increment count
        counter.printCount(); // print count

        index++; // increment index
      }
    } finally {
      lock.unlock(); // release lock
    }
  }
  
  /**
   * Run action will increment Counter
   */
  @Override
  public void run() {
    increment(counter, MAX_COUNT);
  }
}