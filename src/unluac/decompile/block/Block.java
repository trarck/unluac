package unluac.decompile.block;

import unluac.decompile.Decompiler;
import unluac.decompile.Registers;
import unluac.decompile.operation.Operation;
import unluac.decompile.statement.Statement;
import unluac.parse.LFunction;

abstract public class Block extends Statement implements Comparable<Block> {

  protected final LFunction function;
  public int begin;
  public int end;
  private final int priority;
  public boolean loopRedirectAdjustment = false;
  protected boolean scopeUsed = false;
  
  public Block(LFunction function, int begin, int end, int priority) {
    this.function = function;
    this.begin = begin;
    this.end = end;
    this.priority = priority;
  }
  
  abstract public void addStatement(Statement statement);
  
  public void resolve(Registers r) {}
  
  public boolean contains(Block block) {
    return begin <= block.begin && end >= block.end;
  }
  
  public boolean contains(int line) {
    return begin <= line && line < end;
  }
  
  public int scopeEnd() {
    return end - 1;
  }
  
  public void useScope() {
    scopeUsed = true;
  }
  
  /**
   * An unprotected block is one that ends in a JMP instruction.
   * If this is the case, any inner statement that tries to jump
   * to the end of this block will be redirected.
   * 
   * (One of the Lua compiler's few optimizations is that is changes
   * any JMP that targets another JMP to the ultimate target. This
   * is what I call redirection.)
   */
  abstract public boolean isUnprotected();
  
  public int getUnprotectedTarget() {
    throw new IllegalStateException(this.toString());
  }
  
  public int getUnprotectedLine() {
    throw new IllegalStateException(this.toString());
  }
  
  abstract public int getLoopback();
  
  abstract public boolean breakable();
  
  abstract public boolean isContainer();
  
  abstract public boolean isEmpty();
  
  public boolean allowsPreDeclare() {
    return false;
  }
  
  @Override
  public int compareTo(Block block) {
    if(this.begin < block.begin) {
      return -1;
    } else if(this.begin == block.begin) {
      if(this.end < block.end) {
        return 1;
      } else if(this.end == block.end) {
        return this.priority - block.priority;
      } else {
        return -1;
      }
    } else {
      return 1;
    }
  }  
  
  public Operation process(Decompiler d) {
    final Statement statement = this;
    return new Operation(end - 1) {
      
      @Override
      public Statement process(Registers r, Block block) {
        return statement;
      }
      
    };
  }
  
}
