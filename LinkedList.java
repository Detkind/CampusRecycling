public class LinkedList {
    public Node head;
	public Node tail;
	private int endPosition = 0;

    public LinkedList() {
		head = tail = null;
	}

	public void append(VertexEdgeListPair value) {
		Node temp = new Node(value);
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

	public void prepend(VertexEdgeListPair value) {
		Node temp = new Node(value);
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
			Node temp = head;
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

	public VertexEdgeListPair getValueAt(int position) {
		if (position >= 0 && position < size()) {
			Node temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			return temp.getData();
		}
		else {
			return null;
		}
	}

	public int positionOf(VertexEdgeListPair value) {
		Node temp = head;
		for (int i = 0; i < size(); i++) {
			if (temp.getData() == value) {
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}

	public VertexEdgeListPair traverseTo(String vertex) {
		Node temp = head;
		for (int i = 0; i < size(); i++) {
			if (temp.getData().getVertex().getData().compareTo(vertex) == 0) {
				return temp.getData();
			}
			temp = temp.getNext();
		}
		return null;
	}

	public void printBackwards() {
		Node temp = tail;
		for (int i = size(); i > 0; i--) {
			System.out.print(temp.getData());
			temp = temp.getPrev();
		}
	}

	public void print() {
		Node temp = head;
		for (int i = 0; i < size(); i++) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}
}

class Node {
    private VertexEdgeListPair data;
	private Node next;
	private Node prev;

	public Node(VertexEdgeListPair data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

    // put all methods from Node class here
    public VertexEdgeListPair getData() { 
		return data;
	}

	public void setData(VertexEdgeListPair data) { 
		this.data = data; 
	}

	public Node getNext() {
		return next; 
	}

	public void setNext(Node next) {
		this.next = next; 
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}  
}