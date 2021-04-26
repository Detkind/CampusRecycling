public class Queue {
    private LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(VertexEdgeListPair value) {
        list.append(value);
    }

    public VertexEdgeListPair dequeue() {
        if (!isEmpty()) {
            VertexEdgeListPair value = front();
            list.deleteAt(list.positionOf(value));
            return value;
        }
        else {
            return null;
        }
    }

    public VertexEdgeListPair front() {
        if (!isEmpty()) {
            return list.getValueAt(list.positionOf(list.head.getData()));
        }
        else {
            return null;
        }
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void reverse() {
        Stack stack = new Stack();
        while (!isEmpty()) {
            stack.push(dequeue());
        }
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }
    }
}