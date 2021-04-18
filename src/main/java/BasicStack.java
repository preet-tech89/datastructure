
public class BasicStack<T> implements Stack<T> {

  private T[] data;

  private int stackPointer;

  @SuppressWarnings("unchecked")
  public BasicStack() {
    data = (T[]) new Object[1000];
    stackPointer = 0;
  }

  public void push(T newItem) {
    data[stackPointer++] = newItem;
  }

  public T pop() {
    if (stackPointer == 0) {
      throw new IllegalStateException("No more items on the stack");
    }
    return data[--stackPointer];
  }

  public boolean contains(T item) {
    boolean found = false;

    for (int i = 0; i < stackPointer; i++) {
      if (data[i].equals(item)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public T access(T item) {
    while (stackPointer > 0) {
      T temItem = pop();
      if (item.equals(temItem)) {
        return temItem;
      }
    }
    throw new IllegalArgumentException("Could not find item on the stack:" + item);
  }

  public int size() {
    return stackPointer;
  }
}
