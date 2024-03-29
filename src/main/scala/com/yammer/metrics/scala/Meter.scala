package com.yammer.metrics.scala

/**
 * A Scala façade class for Meter.
 */
class Meter(metric: com.yammer.metrics.Meter) {

  /**
   * Marks the occurrence of an event.
   */
  def mark() {
    metric.mark()
  }

  /**
   * Marks the occurrence of a given number of events.
   */
  def mark(count: Long) {
    metric.mark(count)
  }

  /**
   * Returns the number of events which have been marked.
   */
  def count = metric.getCount

  /**
   * Returns the fifteen-minute exponentially-weighted moving average rate at
   * which events have occurred since the meter was created.
   * <p>
   * This rate has the same exponential decay factor as the fifteen-minute load
   * average in the top Unix command.
   */
  def fifteenMinuteRate = metric.getFifteenMinuteRate

  /**
   * Returns the five-minute exponentially-weighted moving average rate at
   * which events have occurred since the meter was created.
   * <p>
   * This rate has the same exponential decay factor as the five-minute load
   * average in the top Unix command.
   */
  def fiveMinuteRate = metric.getFiveMinuteRate

  /**
   * Returns the mean rate at which events have occurred since the meter was
   * created.
   */
  def meanRate = metric.getMeanRate

  /**
   * Returns the one-minute exponentially-weighted moving average rate at
   * which events have occurred since the meter was created.
   * <p>
   * This rate has the same exponential decay factor as the one-minute load
   * average in the top Unix command.
   */
  def oneMinuteRate = metric.getOneMinuteRate
}

