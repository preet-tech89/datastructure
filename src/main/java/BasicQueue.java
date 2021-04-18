
public class BasicQueue<T> {

  private T[] data;

  private int front;

  private int end;

  public BasicQueue() {
    this(1000);
  }

  @SuppressWarnings("unchecked")
  public BasicQueue(int size) {
    data = (T[]) new Object[size];
    this.front = this.end = -1;
  }

  public int size() {
    if (front == -1 && end == -1) {
      return 0;
    }
    else {
      return end - front + 1;
    }
  }

  public void enQueue(T item) {
    // check if queue is full
    if ((end + 1) % data.length == front) {
      throw new IllegalStateException("Queue is full");
    }
    else if (size() == 0) {
      front++;
      end++;
      data[end] = item;
    }
    else {
      end++;
      data[end] = item;
    }
  }

  public T deQueue() {
    T item = null;
    if (size() == 0) {
      throw new IllegalStateException("Cant dequeue as Queue is empty");
    }
    else if (front == end) {
      item = data[front];
      data[front] = null;
      front = end = -1;
    }
    else {
      item = data[front];
      data[front] = null;
      front++;
    }
    return item;
  }

  public boolean contains(T item) {
    boolean found = false;

    if (size() == 0) {
      return found;
    }

    for (int i = front; i < end; i++) {
      if (data[i].equals(item)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public T access(int position) {
    int size = size();
    if (size == 0 || position > size) {
      throw new IllegalStateException("No item in the queue or position is greater than size");
    }
    
    int trueIdx = 0;
    for (int i = front; i < end; i++) {
      if (trueIdx == position) {
        return data[i];
      }
      trueIdx++;
    }

    throw new IllegalStateException("Could not get queue item at position: " + position);
  }

}
