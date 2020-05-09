package Iterator;

import Sequence.List.List.List;
import Sequence.List.Node.Position;
import Exception.ExceptionNoSuchElement;

public class IteratorPosition<T> implements Iterator<T> {

    private List<T> list;
    private Position<T> nextPosition;

    public IteratorPosition() {
        list = null;
    }

    public IteratorPosition(List<T> L) {
        this.list = L;
        if (list.isEmpty())
            nextPosition = null;
        else
            nextPosition = list.first();
    }

    @Override
    public boolean hasNext() {
        return (nextPosition != null);
    }

    @Override
    public Position<T> getNext() throws ExceptionNoSuchElement {
        if (!hasNext()) throw new ExceptionNoSuchElement("错误9：迭代器中没有下一元素");
        Position<T> currentPosition = nextPosition;
        if (currentPosition == list.last())
            nextPosition = null;
        else
            nextPosition = list.getNext(currentPosition);
        return currentPosition;
    }
}
