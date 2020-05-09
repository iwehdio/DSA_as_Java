
package Sequence.Sorter;

import Sequence.List.List.List;
import Sequence.Sequence;
import Sequence.Vector.Vector;

public interface Sorter<T> {
   public void sort(Vector<T> vector);
   public void sort(List<T> list);
}