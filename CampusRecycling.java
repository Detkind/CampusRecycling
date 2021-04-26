public class CampusRecycling {
    public static void main(String[] args) {
        // testing
        Graph newGraph = new Graph();
        newGraph.addVertex("someVertex");
        newGraph.addVertex("someVertex1");
        newGraph.addVertex("someVertex2");
        newGraph.addEdge("someVertex", "someVertex1", 1);
        newGraph.addEdge("someVertex", "someVertex2", 2);
        newGraph.addEdge("someVertex1", "someVertex2", 3);
        System.out.println("degree of someVertex: " + newGraph.getDegree("someVertex"));
        System.out.println("degree of someVertex1: " + newGraph.getDegree("someVertex1"));
        System.out.println("numV: " + newGraph.getNumV());
        System.out.println("incident edges: " + newGraph.incidentEdges("someVertex"));
        newGraph.removeEdge("someVertex", "someVertex2");
        System.out.println("degree of someVertex after remove edge: " + newGraph.getDegree("someVertex"));
        System.out.println("incident edges after remove edge: " + newGraph.incidentEdges("someVertex").getValueAt(0).getEndPoint().getData());
        System.out.println("get edge of someVertex and someVertex1: " + newGraph.getEdge("someVertex", "someVertex1"));
        System.out.println("edge sum: " + newGraph.edgeSum());
        System.out.println("all edges: " + newGraph.getAllEdges().size());
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
    
    public void addEdge(String origin, String endPoint, int weight) {
        // get the vertex edge pair at origin
        VertexEdgeListPair VertexEdgesPair = adjList.traverseTo(origin);
        // create edge from origin to endpoint and add edge to the linked list of edges at origin
        VertexEdgesPair.getEdges().append(new Edge(VertexEdgesPair.getVertex(), adjList.traverseTo(endPoint).getVertex(), weight));
        
        // if graph is undirected, add edge from endpoint to origin to the linked list of edges at endpoint
        if (directed == false) {
            VertexEdgesPair = adjList.traverseTo(endPoint);
            VertexEdgesPair.getEdges().append(new Edge(VertexEdgesPair.getVertex(), adjList.traverseTo(origin).getVertex(), weight));
        }
    }

    public void removeEdge(String origin, String endPoint) {
        // retreive edges at origin vertex
        LinkedListEdges edges = adjList.traverseTo(origin).getEdges();
        // find edge that corresponds with given endpoint and delete it
        for (int i = 0; i < edges.size(); i++) {
            if (edges.getValueAt(i).getEndPoint().getData() == endPoint) {
                edges.deleteAt(i);
                break;
            }
        }
    }

    public Edge getEdge(String origin, String endPoint) {
        // retreive edges at origin vertex
        LinkedListEdges edges = adjList.traverseTo(origin).getEdges();
        // find edge that corresponds with given endpoint and return it
        for (int i = 0; i < edges.size(); i++) {
            if (edges.getValueAt(i).getEndPoint().getData() == endPoint) {
                return edges.getValueAt(i);
            }
        }
        // return null if edge not found
        return null;
    }

    public int edgeSum() {
        // declare and initialize the sum of weights of edges
        int edgeWeightSum = 0;
        // iterate through all the vertices in the adjlist
        for (int i = 0; i < adjList.size(); i++) {
            // retreive edges of vertex
            LinkedListEdges edges = adjList.getValueAt(i).getEdges();
            // sum up weights of edges
            for (int j = 0; j < edges.size(); j++) {
                edgeWeightSum += edges.getValueAt(j).getWeight();
            }
        }
        // return the sum of weights of edges 
        return edgeWeightSum;
    }

    public LinkedListEdges incidentEdges(String vertex) {
        // returns the linked list of edges at vertex
        return adjList.traverseTo(vertex).getEdges();
    }
    
    
    public LinkedListEdges getAllEdges() {
        // declare and initialize a linked list of all edges 
        LinkedListEdges allEdges = new LinkedListEdges();
        // iterate through all vertices in the adjlist
        for (int i = 0; i < adjList.size(); i++) {
            // retreive edges of vertex
            LinkedListEdges edges = adjList.getValueAt(i).getEdges();
            // add all the edges of the vertex to linked list of all edges
            for (int j = 0; j < edges.size(); j++) {
                allEdges.append(edges.getValueAt(j));
            }
        }
        // return a linked list of all the edges
        return allEdges;
    }
    
    public int getNumV() {
        return numV;
    }
}