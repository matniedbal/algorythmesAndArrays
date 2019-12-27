import java.util.Comparator;

public interface Lista<E> {

    public E get(int index);
    public void add(E elem);
    public void remove(E elem);
    public boolean isEmpty();
    public int size();
    public boolean isSorted(Comparator<E> comparator);
    public boolean exist(E elem);
    public int getIndex(E elem);
    public String toString();
    public E getFirstNode();
    public E getLastNode();

}
