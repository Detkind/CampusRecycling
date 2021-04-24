public class CampusRecycling {
    public static void main(String[] args) {
        Graph newGraph = new Graph();
        newGraph.addVertex("someVertex");
        newGraph.addVertex("someVertex1");
        newGraph.addVertex("someVertex2");
        newGraph.addEdge("someVertex", "someVertex1");
        // System.out.println(newGraph.getDegree("someVertex2"));
        System.out.println(newGraph.getDegree("someVertex"));
        System.out.println(newGraph.getDegree("someVertex1"));
        System.out.println(newGraph.getNumV());
        System.out.println(newGraph.incidentEdges("someVertex"));
    }
}

class Graph {
    private LinkedList adjList;
    private int degree;
    private boolean directed;
    private int numV;

    public Graph() {
        adjList = new LinkedList();
        directed = true;
        numV = 0;
    }

    
    public void addVertex(String vertex) {
        // appends a vertex edge pair with the new vertex and a linked list of edges
        adjList.append(new VertexEdgeListPair(new Vertex(vertex), new LinkedListEdges()));
        numV++;
    }
    
    public int getDegree(String vertex) {
        // returns the size of the linked list of edges at a vertex
        return adjList.traverseTo(vertex).getEdges().size();
    }
    
    public void addEdge(String origin, String endPoint) {
        // get the vertex edge pair at origin
        VertexEdgeListPair VertexEdgesPair = adjList.traverseTo(origin);
        // create edge from origin to endpoint and add edge to the linked list of edges at origin
        VertexEdgesPair.getEdges().append(new Edge(VertexEdgesPair.getVertex(), adjList.traverseTo(endPoint).getVertex()));
        
        // if graph is undirected, add edge from endpoint to origin to the linked list of edges at endpoint
        if (directed == false) {
            VertexEdgesPair = adjList.traverseTo(endPoint);
            VertexEdgesPair.getEdges().append(new Edge(VertexEdgesPair.getVertex(), adjList.traverseTo(origin).getVertex()));
        }
    }

    public LinkedListEdges incidentEdges(String vertex) {
        // returns the linked list of edges at vertex
        return adjList.traverseTo(vertex).getEdges();
    }
    
    public int getNumV() {
        return numV;
    }
}