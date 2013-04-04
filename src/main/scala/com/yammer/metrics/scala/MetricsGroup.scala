package com.yammer.metrics.scala

import java.util.concurrent.TimeUnit
import com.yammer.metrics.{MetricRegistry, Gauge}

/**
 * A helper class for creating and registering metrics.
 */
class MetricsGroup(val klass: Class[_], val metricRegistry: MetricRegistry) {

  /**
   * Registers a new gauge metric.
   *
   * @param name  the name of the gauge
   * @param registry the registry for the gauge
   */
  def gauge[A](name: String, registry: MetricRegistry = metricRegistry)(f: => A) = {
    registry.register(name, new Gauge[A] {
      def getValue = f
    })
  }

  /**
   * Creates a new counter metric.
   *
   * @param name  the name of the counter
   * @param registry the registry for the gauge
   */
  def counter(name: String, registry: MetricRegistry = metricRegistry) =
    new Counter(registry.counter(name))

  /**
   * Creates a new histogram metrics.
   *
   * @param name   the name of the histogram
   * @param registry the registry for the gauge
   */
  def histogram(name: String,
                registry: MetricRegistry = metricRegistry) =
    new Histogram(registry.histogram(name))

  /**
   * Creates a new meter metric.
   *
   * @param name the name of the meter
   * @param registry the registry for the gauge
   */
  def meter(name: String,
            registry: MetricRegistry = metricRegistry) =
    new Meter(registry.meter(name))

  /**
   * Creates a new timer metric.
   *
   * @param name the name of the timer
   * @param registry the registry for the gauge
   */
  def timer(name: String,
            registry: MetricRegistry = metricRegistry) =
    new Timer(registry.timer(name))
}

