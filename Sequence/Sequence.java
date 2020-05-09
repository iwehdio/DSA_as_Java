
package Sequence;

import Sequence.List.List.List;
import Sequence.List.Node.Position;
import Sequence.Vector.Vector;
import Exception.ExceptionPositionInvalid;
import Exception.ExceptionBoundaryViolation;

public interface Sequence<T> extends Vector<T>, List<T> {

   public Position<T> rank2Pos(int r)
   throws ExceptionBoundaryViolation;

   public int pos2Rank(Position<T> p)
   throws ExceptionPositionInvalid;

}