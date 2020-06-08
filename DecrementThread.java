package PortfolioMilestone_2_Option1;

import java.util.concurrent.locks.ReentrantLock;

public class DecrementThread implements Runnable {
  // local variables
  private static ReentrantLock lock;
  private static Counter counter;
  private static final int MIN_COUNT = 0;

  /**
   * Constructor to instantiate DecrementThread with 
   * reference to counter and lock
   * 
   * @param _counter instance of Counter
   * @param _lock    instance of ReentrantLock
   */
  public DecrementThread(Counter _counter, ReentrantLock _lock) {
    counter = _counter;
    lock = _lock;
  }

  /**
   * Acquires lock and decrements Counter from Counter.count's
   * current value to floor value
   * 
   * @param counter reference to Counter
   * @param floor   integer to decrement down to
   */
  private static void decrement(Counter counter, int floor) {
    lock.lock(); // acquire lock

    try {
      System.out.println("--START DECREMENT--");
      // set starting index at current value of count
      int index = counter.getCount();
      counter.printCount(); // print starting index

      while (index > floor) { // while index is greater than floor
        counter.decrement(); // decrement count
        counter.printCount(); // print count

        index--; // decrement index
      }
    } finally {
      lock.unlock(); // release lock
    }
  }

  /**
   * Run action will decrement Counter
   */
  @Override
  public void run() {
    decrement(counter, MIN_COUNT);
  }
}