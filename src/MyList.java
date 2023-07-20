public interface MyList<E> {
int size();
boolean add(E element);
void add(E element, int index);
E removeByIndex(int index);
<E>E[] toArray(E[] o);
boolean contains(E element);
}
