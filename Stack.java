public class Stack {
    private LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    public void push(VertexEdgeListPair value) {
        list.append(value);
    }

    public VertexEdgeListPair pop() {
        if (!isEmpty()) {
            VertexEdgeListPair topValue = peek();
            list.deleteAt(list.positionOf(topValue));
            return topValue;
        }
        else {
            return null;
        }
    }

    public VertexEdgeListPair peek() {
        if (!isEmpty()) {
            return list.getValueAt(list.positionOf(list.tail.getData()));
        }
        else {
            return null;
        }
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}