package unluac.test;

import java.io.IOException;

public class RunTests {

  public static void main(String[] args) throws IOException {
    boolean result = true;
    TestReport report = new TestReport();
    for(int version = 0x50; version <= 0x53; version++) {
      LuaSpec spec = new LuaSpec(version);
      System.out.print("lua" + Integer.toHexString(version));
      result = result & TestFiles.suite.run(spec, report);
      System.out.println();
    }
    report.report(System.out);
    if(result) {
      System.exit(0);
    } else {
      System.exit(1);
    }
  }
  
}
