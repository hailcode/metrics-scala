package com.yammer.metrics.scala

import collection.JavaConversions._
import java.util.concurrent.TimeUnit
import java.io.File

/**
 * A Scala façade class for Timer.
 */
class Timer(metric: com.yammer.metrics.Timer) {
  /**
   * Runs f, recording its duration, and returns the result of f.
   */
  def time[A](f: => A): A = {
    val ctx = metric.time
    try {
      f
    } finally {
      ctx.stop
    }
  }

  /**
   * Adds a recorded duration.
   */
  def update(duration: Long, unit: TimeUnit) {
    metric.update(duration, unit)
  }

  /**
   * Returns a timing [[com.metrics.yammer.core.TimerContext]],
   * which measures an elapsed time in nanoseconds.
   */
  def timerContext() = metric.time()

  /**
   * Returns the number of durations recorded.
   */
  def count = metric.getCount

  /**
   * Returns a snapshot of the values in the timer's sample.
   */
  def snapshot = metric.getSnapshot

  /**
   * Returns the fifteen-minute rate of timings.
   */
  def fifteenMinuteRate = metric.getFifteenMinuteRate

  /**
   * Returns the five-minute rate of timings.
   */
  def fiveMinuteRate = metric.getFiveMinuteRate

  /**
   * Returns the mean rate of timings.
   */
  def meanRate = metric.getMeanRate

  /**
   * Returns the one-minute rate of timings.
   */
  def oneMinuteRate = metric.getOneMinuteRate
}

