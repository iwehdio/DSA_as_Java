
package Sequence.Sorter;

import Sequence.List.List.List;
import Sequence.Sequence;
import Sequence.Comparator.Comparator;
import Sequence.Comparator.ComparatorDefault;
import Sequence.Vector.Vector;

public class Sorter_Quicksort<T> implements Sorter<T> {

   private Comparator C;

   public Sorter_Quicksort()
   {  this(new ComparatorDefault()); }

   public Sorter_Quicksort(Comparator comp)
   {  C = comp; }

   @Override
   public void sort(Vector<T> vector)
   {  qsort(vector, 0, vector.getSize() - 1); }

   @Override
   public void sort(List<T> s) {

   }

   public void qsort(Vector<T> vector, int lo, int hi) {
      if (lo >= hi)  return;
      int mi = createPivot(vector, lo, hi);
      qsort(vector, lo, mi - 1);
      qsort(vector, mi + 1, hi);
   }

   public int createPivot(Vector<T> vector, int lo, int hi) {
      while (lo < hi) {
         while ((lo < hi) && (C.compare(vector.get(lo), vector.get(hi)) <= 0)) hi--;
         swap(vector, lo, hi);
         while ((lo < hi) && (C.compare(vector.get(lo), vector.get(hi)) <= 0)) lo++;
         swap(vector, lo, hi);
      }
      return lo;
   }

   private void swap(Vector vector, int i, int j) {
      Object temp = vector.get(i);
      vector.replace(i, vector.get(j));
      vector.replace(j, temp);
   }


}