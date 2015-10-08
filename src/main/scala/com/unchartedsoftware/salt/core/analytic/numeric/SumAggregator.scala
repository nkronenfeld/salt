package com.unchartedsoftware.salt.core.analytic.numeric

import com.unchartedsoftware.salt.core.analytic.Aggregator

object SumAggregator extends Aggregator[Double, Double, java.lang.Double] {
  def default(): Double = {
    0D
  }

  override def add(current: Double, next: Option[Double]): Double = {
    if (next.isDefined && !next.get.equals(Double.NaN)) {
      current + next.get
    } else {
      current
    }
  }
  override def merge(left: Double, right: Double): Double = {
    left + right
  }

  def finish(intermediate: Double): java.lang.Double = {
    intermediate
  }
}