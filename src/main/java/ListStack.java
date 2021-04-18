import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements Stack<T> {

  private List<T> data;

  private int stackPointer;

  public ListStack() {
    data = new ArrayList<>();
    stackPointer = 0;
  }

  public void push(T newItem) {
    data.add(stackPointer++, newItem);
  }

  public T pop() {
    if (stackPointer == 0) {
      throw new IllegalStateException("No more items on the stack");
    }
    return data.remove(--stackPointer);
  }

  public boolean contains(T item) {
    return data.contains(item);
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
