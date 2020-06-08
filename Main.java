package PortfolioMilestone_2_Option1;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
  // instantiate lock
  private static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {
    final int MIN_COUNT = 0;
    // instantiate counter
    final Counter counter = new Counter(MIN_COUNT);

    // instantiate increment thread and pass counter & lock
    Thread incrementThread = new Thread(new IncrementThread(counter, lock));
    // instantiate decrement thread and pass counter & lock
    Thread decrementThread = new Thread(new DecrementThread(counter, lock));

    // kick off threads
    incrementThread.start();
    decrementThread.start();

    try {
      // stop threads
      incrementThread.join();
      decrementThread.join();
    } catch (InterruptedException e) { 
      // print exception if error thrown
      e.printStackTrace();
    }
  }
}