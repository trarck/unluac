package unluac;

import unluac.decompile.Op;
import unluac.decompile.OpcodeMap;
import unluac.parse.LHeaderType;

public abstract class Version {

  public static final Version LUA50 = new Version50();
  public static final Version LUA51 = new Version51();
  public static final Version LUA52 = new Version52();
  public static final Version LUA53 = new Version53();
  
  public static enum VarArgType {
    ARG,
    HYBRID,
    ELLIPSIS;
  }
  
  protected final int versionNumber;
  
  protected Version(int versionNumber) {
    this.versionNumber = versionNumber;
  }
  
  public abstract LHeaderType getLHeaderType();
  
  public OpcodeMap getOpcodeMap() {
    return new OpcodeMap(versionNumber);
  }
  
  public abstract int getOuterBlockScopeAdjustment();

  public abstract boolean usesInlineUpvalueDeclarations();
  
  public abstract Op getTForTarget();

  public abstract Op getForTarget();
  
  public abstract boolean isAllowedPreceedingSemicolon();
  
  public abstract boolean isEnvironmentTable(String name);
  
  public abstract boolean usesIfBreakRewrite();
  
  public abstract VarArgType getVarArgType();
  
}

class Version50 extends Version {

  Version50() {
    super(0x50);
  }

  @Override
  public LHeaderType getLHeaderType() {
    return LHeaderType.TYPE50;
  }

  @Override
  public int getOuterBlockScopeAdjustment() {
    return -1;
  }

  @Override
  public boolean usesInlineUpvalueDeclarations() {
    return true;
  }

  @Override
  public Op getTForTarget() {
    return null;
  }

  @Override
  public Op getForTarget() {
    return Op.FORLOOP;
  }

  @Override
  public boolean isAllowedPreceedingSemicolon() {
    return false;
  }
  
  @Override
  public boolean isEnvironmentTable(String upvalue) {
    return false;
  }
  
  @Override
  public boolean usesIfBreakRewrite() {
    return false;
  }
  
  @Override
  public VarArgType getVarArgType() {
    return VarArgType.ARG;
  }
  
}

class Version51 extends Version {
  
  Version51() {
    super(0x51);
  }
  
  @Override
  public LHeaderType getLHeaderType() {
    return LHeaderType.TYPE51;
  }
  
  @Override
  public int getOuterBlockScopeAdjustment() {
    return -1;
  }
  
  @Override
  public boolean usesInlineUpvalueDeclarations() {
    return true;
  }
  
  @Override
  public Op getTForTarget() {
    return Op.TFORLOOP;
  }
  
  @Override
  public Op getForTarget() {
    return null;
  }

  @Override
  public boolean isAllowedPreceedingSemicolon() {
    return false;
  }
  
  @Override
  public boolean isEnvironmentTable(String upvalue) {
    return false;
  }
  
  @Override
  public boolean usesIfBreakRewrite() {
    return false;
  }
  
  @Override
  public VarArgType getVarArgType() {
    return VarArgType.HYBRID;
  }
  
}

class Version52 extends Version {
  
  Version52() {
    super(0x52);
  }
  
  @Override
  public LHeaderType getLHeaderType() {
    return LHeaderType.TYPE52;
  }
  
  @Override
  public int getOuterBlockScopeAdjustment() {
    return 0;
  }
  
  @Override
  public boolean usesInlineUpvalueDeclarations() {
    return false;
  }

  @Override
  public Op getTForTarget() {
    return Op.TFORCALL;
  }

  @Override
  public Op getForTarget() {
    return null;
  }

  @Override
  public boolean isAllowedPreceedingSemicolon() {
    return true;
  }
  
  @Override
  public boolean isEnvironmentTable(String name) {
    return name.equals("_ENV");
  }
  
  @Override
  public boolean usesIfBreakRewrite() {
    return true;
  }
  
  @Override
  public VarArgType getVarArgType() {
    return VarArgType.ELLIPSIS;
  }
  
}

class Version53 extends Version {
  
  Version53() {
    super(0x53);
  }
  
  @Override
  public LHeaderType getLHeaderType() {
    return LHeaderType.TYPE53;
  }
  
  @Override
  public int getOuterBlockScopeAdjustment() {
    return 0;
  }
  
  @Override
  public boolean usesInlineUpvalueDeclarations() {
    return false;
  }

  @Override
  public Op getTForTarget() {
    return Op.TFORCALL;
  }

  @Override
  public Op getForTarget() {
    return null;
  }

  @Override
  public boolean isAllowedPreceedingSemicolon() {
    return true;
  }
  
  @Override
  public boolean isEnvironmentTable(String name) {
    return name.equals("_ENV");
  }
  
  @Override
  public boolean usesIfBreakRewrite() {
    return true;
  }
  
  @Override
  public VarArgType getVarArgType() {
    return VarArgType.ELLIPSIS;
  }
  
}

