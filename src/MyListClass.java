import java.util.Arrays;

public class MyListClass<E> implements MyList<E> {
    Object[] objectsList;
    private int size = 0;
    private int capacity = 10;

    MyListClass() {
        objectsList = new Object[size];
    }

    MyListClass(int size) {
        this.size = size;
        capacity = size + 10;
        objectsList = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (size == 0) {
            objectsList = new Object[capacity];
            objectsList[size++] = element;
        } else if (size + 1 == capacity) {
            capacity = capacity + 10;
            objectsList = Arrays.copyOf(objectsList, capacity);
            objectsList[size++] = element;
        } else {
            objectsList[size++] = element;
        }
        return true;
    }

    @Override
    public void add(E element, int index) {
        if (index < 0 || index > size + 1) {
            System.out.println("Wrong index");
        } else if (index == size + 1) {
            add(element);
        } else if (size + 1 == capacity) {
            capacity = capacity + 10;
            add(element, index);
        } else {
            Object[] newObjectList = new Object[capacity];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i == index) {
                    newObjectList[i] = element;
                    size++;
                    j--;
                    continue;
                }
                newObjectList[i] = objectsList[j];
            }
            objectsList = newObjectList;
        }
    }

    @Override
    public E removeByIndex(int index) {
        if (index < 0 || index > size-1) {
            System.out.println("Wrong index");
        } else if (index==size-1){
            size--;
        } else {
            Object[] newObjectList = new Object[capacity];
            for (int i = 0, j = 0; j < size; i++, j++) {
                if (i == index) {
                    j++;
                }
                newObjectList[i] = objectsList[j];
            }
            size--;
            objectsList = newObjectList;
        }

        return (E)objectsList[index];
    }

    @Override
    public <E>E[] toArray(E[] o) {
        return (E[])Arrays.copyOf(objectsList,size,o.getClass());
   }
    public Object[] toArray() {
        return Arrays.copyOf(objectsList,size);
    }

    @Override
    public boolean contains(E element) {
        for (int i=0;i<size;i++){
            if (objectsList[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String arrayToString = "[";
        for (int i = 0; i < size - 1; i++) {
            arrayToString += objectsList[i] + ", ";
        }
        arrayToString += objectsList[size - 1] + "]";
        return arrayToString;
    }
}
