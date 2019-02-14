package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def pascalIter(ci: Int, ri: Int, memo: Map[String,Int]): Int = {
        if (ci < 0 || ci > ri || ri < 0 ) return 0
        if (ci == 0 || ci == ri) return 1
        if (ci == c && ri == r) memo(makeKey(ci - 1, ri - 1)) + memo(makeKey(ci, ri - 1))
      }

      def makeKey(c: Int, r: Int): String = {
        c.toString + "_" + r.toString
      }


      pascalIter(c - r, 0, Map())
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balIter(chars: List[Char], score: Int): Boolean = {
        if (chars.isEmpty) return true
        val increment =
          if (chars.head == '(') 1
          else if (chars.head == ')') -1
          else 0
        (score + increment) >= 0 && balIter(chars.tail, score + increment)
      }

      balIter(chars,0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
