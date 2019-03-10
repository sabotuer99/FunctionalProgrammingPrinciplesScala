package expr

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }

  def show: String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => "(" + e1.show + " + " + e2.show + ")"
  }
}

case class Number(n: Int) extends Expr
case class Sum(lhs: Expr, rhs: Expr) extends Expr
