public class LinkedListEdges {
    public NodeEdge head;
	public NodeEdge tail;
	private int endPosition = 0;

    public LinkedListEdges() {
		head = tail = null;
	}

	public void append(Edge value) {
		NodeEdge temp = new NodeEdge(value);
		if (tail == null) {
			head = tail = temp;
		}
		else {
			tail.setNext(temp);
			temp.setPrev(tail);
            tail = temp;
		}
		endPosition++;
	}

	public void prepend(Edge value) {
		NodeEdge temp = new NodeEdge(value);
		if (tail == null) {
			head = tail = temp;
		}

		else {
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
		}
		endPosition++;
	}

	public void deleteAt(int position) {
		if (position >= 0 && position < size()) {
			NodeEdge temp = head;
			if (size() == 1) {
				head.setNext(null);
				tail.setPrev(null);
				head = tail = null;
			}

			else {
				for (int i = 0; i < position; i++) {
					temp = temp.getNext();
				}

				if (temp == head) {
					head = temp.getNext();
					head.setPrev(null);
				}

				else if (temp == tail) {
					tail = tail.getPrev();
					tail.setNext(null);
				}

				else {
					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev());
				}
			}
			endPosition--;
		}
	}

	public int size() {
		return endPosition;
	}

	public Edge getValueAt(int position) {
		if (position >= 0 && position < size()) {
			NodeEdge temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			return temp.getData();
		}
		else {
			return null;
		}
	}

	public int positionOf(Edge value) {
		NodeEdge temp = head;
		for (int i = 0; i < size(); i++) {
			if (temp.getData() == value) {
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}

	public void printBackwards() {
		NodeEdge temp = tail;
		for (int i = size(); i > 0; i--) {
			System.out.print(temp.getData());
			temp = temp.getPrev();
		}
	}

	public void print() {
		NodeEdge temp = head;
		for (int i = 0; i < size(); i++) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}
}

class NodeEdge {
    private Edge data;
	private NodeEdge next;
	private NodeEdge prev;

	public NodeEdge(Edge data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

    // put all methods from NodeEdge class here
    public Edge getData() { 
		return data;
	}

	public void setData(Edge data) { 
		this.data = data; 
	}

	public NodeEdge getNext() {
		return next; 
	}

	public void setNext(NodeEdge next) {
		this.next = next; 
	}

	public NodeEdge getPrev() {
		return prev;
	}

	public void setPrev(NodeEdge prev) {
		this.prev = prev;
	}  
}