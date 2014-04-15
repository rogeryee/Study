package com.yeep.study.patterns.iterator;

/**
 * Interface of Iterator
 */
public interface Iterator
{
  /**
   * Return a boolean indicates whether or not there are more elements to iterate
   * @return
   */
  public boolean hasNext();

  /**
   * Return the next element
   * @return
   */
  public Object next();
}
