public class Edge {
    private Vertex origin;
    private Vertex endPoint;
    private int weight;

    public Edge(Vertex origin, Vertex endPoint) {
        this.origin = origin;
        this.endPoint = endPoint;
        this.weight = 0;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Vertex endPoint) {
        this.endPoint = endPoint;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getOpposite(Vertex vertex) {
        if (vertex == origin) {
            return endPoint;
        }
        else {
            return origin;
        }
    }
}