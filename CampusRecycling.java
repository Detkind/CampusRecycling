public class CampusRecycling {
    public static void main(String[] args) {
        // testing
        Graph newGraph = new Graph();
        newGraph.addVertex("someVertex");
        newGraph.addVertex("someVertex1");
        newGraph.addVertex("someVertex2");
        newGraph.addEdge("someVertex", "someVertex1");
        newGraph.addEdge("someVertex", "someVertex2");
        System.out.println(newGraph.getDegree("someVertex"));
        // System.out.println(newGraph.getDegree("someVertex1"));
        // System.out.println(newGraph.getNumV());
        System.out.println(newGraph.incidentEdges("someVertex"));
        newGraph.removeEdge("someVertex", "someVertex2");
        System.out.println(newGraph.getDegree("someVertex"));
        System.out.println(newGraph.incidentEdges("someVertex").getValueAt(0).getEndPoint().getData());
        System.out.println(newGraph.getEdge("someVertex", "someVertex1").getEndPoint().getData());
    }
}

class Graph {
    private LinkedList adjList;
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

    public void removeEdge(String origin, String endPoint) {
        LinkedListEdges edges = adjList.traverseTo(origin).getEdges();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.getValueAt(i).getEndPoint().getData() == endPoint) {
                edges.deleteAt(i);
                break;
            }
        }
    }

    public Edge getEdge(String origin, String endPoint) {
        LinkedListEdges edges = adjList.traverseTo(origin).getEdges();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.getValueAt(i).getEndPoint().getData() == endPoint) {
                return edges.getValueAt(i);
            }
        }
        return null;
    }

    public LinkedListEdges incidentEdges(String vertex) {
        // returns the linked list of edges at vertex
        return adjList.traverseTo(vertex).getEdges();
    }
    
    public int getNumV() {
        return numV;
    }
}