package Iterator;

import Sequence.List.List.List;
import Sequence.List.Node.Position;
import Exception.ExceptionNoSuchElement;

public class IteratorElement<T> implements Iterator<T> {

    private List<T> list;
    private Position<T> nextPosition;

    public IteratorElement() {
        this.list = null;
    }

    public IteratorElement(List<T> L) {
        this.list = L;
        if (this.list.isEmpty())
            this.nextPosition = null;
        else
            this.nextPosition = this.list.first();
    }

    @Override
    public boolean hasNext() {
        return (this.nextPosition != null);
    }

    @Override
    public T getNext() throws ExceptionNoSuchElement {
        if (!hasNext()) throw new ExceptionNoSuchElement("错误9：迭代器中没有下一元素");
        Position<T> currentPosition = this.nextPosition;
        if (currentPosition == this.list.last())
            this.nextPosition = null;
        else
            this.nextPosition = list.getNext(currentPosition);
        return currentPosition.getElem();
    }
}
