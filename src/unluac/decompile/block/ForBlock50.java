package unluac.decompile.block;

import unluac.decompile.Registers;
import unluac.parse.LFunction;

public class ForBlock50 extends ForBlock {
  
  public ForBlock50(LFunction function, int begin, int end, int register, boolean innerClose) {
    super(function, begin, end, register, false, innerClose);
  }

  @Override
  public void handleVariableDeclarations(Registers r) {
    r.setExplicitLoopVariable(register, begin - 1, end - 1);
    r.setInternalLoopVariable(register + 1, begin - 1, end - 1);
    r.setInternalLoopVariable(register + 2, begin - 1, end - 1);
  }
  
}
