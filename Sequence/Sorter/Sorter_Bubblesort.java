
package Sequence.Sorter;

import Sequence.List.List.List;
import Sequence.Sequence;
import Sequence.Comparator.Comparator;
import Sequence.Comparator.ComparatorDefault;
import Sequence.Vector.Vector;

public class Sorter_Bubblesort<T> implements Sorter<T> {

   private Comparator C;

   public Sorter_Bubblesort()
   {  this(new ComparatorDefault()); }

   public Sorter_Bubblesort(Comparator comp)
   {  C = comp; }

   @Override
   public void sort(Vector<T> vector) {
      int n = vector.getSize();
      for (int i = 0; i < n; i++)
         for (int j = 0; j < n - i - 1; j++)
            if (0 < C.compare(vector.get(j), vector.get(j + 1))) {
               T temp = vector.get(j);
               vector.replace(j, vector.get(j + 1));
               vector.replace(j + 1, temp);
            }
   }

   @Override
   public void sort(List s) {

   }


}