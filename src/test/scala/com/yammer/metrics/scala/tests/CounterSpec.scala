package com.yammer.metrics.scala.tests

import org.junit.Test
import com.simple.simplespec.Spec
import com.yammer.metrics.Counter

class CounterSpec extends Spec {
  class `A counter` {
    val metric = mock[com.yammer.metrics.Counter]
    val counter = new Counter(metric)

    @Test def `increments the underlying metric by an arbitrary amount` = {
      counter += 12

      verify.one(metric).inc(12)
    }

    @Test def `decrements the underlying metric by an arbitrary amount` = {
      counter -= 12

      verify.one(metric).dec(12)
    }
  }
}

