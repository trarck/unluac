package unluac.decompile.block;

import unluac.decompile.Decompiler;
import unluac.decompile.Output;
import unluac.decompile.Registers;
import unluac.decompile.Walker;
import unluac.decompile.condition.Condition;
import unluac.decompile.expression.Expression;
import unluac.decompile.statement.Statement;
import unluac.parse.LFunction;

public class RepeatBlock extends ContainerBlock {

  private final Condition cond;
  
  private Expression condexpr;
  
  public RepeatBlock(LFunction function, Condition cond, int begin, int end) {
    super(function, begin, end, 0);
    this.cond = cond;
  }
  
  @Override
  public void resolve(Registers r) {
    condexpr = cond.asExpression(r);
  }
  
  @Override
  public void walk(Walker w) {
    w.visitStatement(this);
    for(Statement statement : statements) {
      statement.walk(w);
    }
    condexpr.walk(w);
  }
  
  @Override
  public boolean breakable() {
    return true;
  }
  
  @Override
  public boolean isUnprotected() {
    return false;
  }
  
  @Override
  public int getLoopback() {
    throw new IllegalStateException();
  }
  
  @Override
  public void print(Decompiler d, Output out) {
    out.print("repeat");
    out.println();
    out.indent();
    Statement.printSequence(d, out, statements);
    out.dedent();
    out.print("until ");
    condexpr.print(d, out);
  }
  
}
