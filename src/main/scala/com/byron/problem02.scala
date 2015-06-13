package com.byron

/*
 * Problem 02
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 *
 */

class evenFibs(n: Int) {
  // Stream of all fibonacci numbers
  val fib: Stream[Int] = 1 #:: 2 #:: fib.zip(fib.tail).map(n => n._1 + n._2)

  // Take from fib while less than 4 million and even. Sums.
  val answer: BigInt = fib.takeWhile(e => e < n).filter(f => f%2 == 0 ).sum
}

object problem02 {
  def main(args: Array[String]) {
    val ef = new evenFibs(4000000)
    println(ef.answer)
  }
}
