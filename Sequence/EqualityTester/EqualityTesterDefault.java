
package Sequence.EqualityTester;

public class EqualityTesterDefault implements EqualityTester {
   public EqualityTesterDefault() {}
   public boolean isEqualTo(Object a, Object b)
   {  return (a.equals(b)); }
}