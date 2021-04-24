public class VertexEdgeListPair {
    private Vertex vertex;
    private LinkedListEdges edges;
    
    public VertexEdgeListPair(Vertex vertex, LinkedListEdges edges) {
        this.vertex = vertex;
        this.edges = edges;
    }
    
    public Vertex getVertex() {
        return vertex;
    }
    public LinkedListEdges getEdges() {
        return edges;
    }
    
    public void setEdges(LinkedListEdges edges) {
        this.edges = edges;
    }
}