package PortfolioMilestone_2_Option1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
  // define local state
  private final AtomicInteger count;

  /**
   * Instantiate count at 0
   */
  public Counter() {
    count = new AtomicInteger(0);
  }

  /**
   * Instantiate count at user-defined integer
   * 
   * @param _count start count
   */
  public Counter(int _count) {
    count = new AtomicInteger(_count);
  }

  // setters
  /**
   * Atomically increment counter by 1
   * and return updated counter value
   * 
   * @return current count value
   */
  public int increment() {
    return count.incrementAndGet();
  }

  /**
   * Atomically decrement counter by 1 
   * and return updated counter value
   * 
   * @return current count value
   */
  public int decrement() {
    return count.decrementAndGet();
  }

  // getters
  /**
   * Return current value of count
   * 
   * @return current value of count
   */
  public int getCount() {
    return count.get();
  }

  /**
   * Print to console current value of count
   */
  public void printCount() {
    System.out.println("Count is: " + getCount());
  }
}