public class CampusRecycling {
    public static void main(String[] args) {
        // testing
        Graph newGraph = new Graph();
        newGraph.addVertex("someVertex");
        newGraph.addVertex("someVertex1");
        newGraph.addVertex("someVertex2");
        newGraph.addVertex("someVertex3");
        newGraph.addEdge("someVertex", "someVertex1", 1);
        newGraph.addEdge("someVertex", "someVertex2", 2);
        newGraph.addEdge("someVertex1", "someVertex2", 3);
        newGraph.addEdge("someVertex1", "someVertex", 3);
        newGraph.addEdge("someVertex2", "someVertex3", 3);
        newGraph.addEdge("someVertex1", "someVertex3", 3);
        System.out.println("degree of someVertex: " + newGraph.getDegree("someVertex"));
        System.out.println("degree of someVertex1: " + newGraph.getDegree("someVertex1"));
        System.out.println("numV: " + newGraph.getNumV());
        System.out.println("incident edges: " + newGraph.incidentEdges("someVertex"));
        // newGraph.removeEdge("someVertex", "someVertex2");
        System.out.println("degree of someVertex after remove edge: " + newGraph.getDegree("someVertex"));
        System.out.println("incident edges after remove edge: " + newGraph.incidentEdges("someVertex").getValueAt(0).getEndPoint().getData());
        System.out.println("get edge of someVertex and someVertex1: " + newGraph.getEdge("someVertex", "someVertex1"));
        System.out.println("edge sum: " + newGraph.edgeSum());
        System.out.println("all edges: " + newGraph.getAllEdges().size());
        // newGraph.removeVertex("someVertex");
        System.out.println("numv " + newGraph.getNumV());
        System.out.println("all edges: " + newGraph.getAllEdges().size());
        System.out.print("BFS: ");
        LinkedList bfs = newGraph.BFS("someVertex");
        for (int i = 0; i < bfs.size(); i++) {
            System.out.print(bfs.getValueAt(i).getVertex().getData() + " ");
        }
        System.out.print("\nDFS: ");
        LinkedList dfs = newGraph.DFS("someVertex");
        for (int i = 0; i < dfs.size(); i++) {
            System.out.print(dfs.getValueAt(i).getVertex().getData() + " ");
        }
    }
}

class Graph {
    private LinkedList adjList;
    private boolean directed;
    private int numV;
    
    public Graph() {
        adjList = new LinkedList();
        directed = true;
        numV = adjList.size();
    }
    
    public int getNumV() {
        return numV;
    }

    public void addVertex(String vertex) {
        // appends a vertex edge pair with the new vertex and a linked list of edges
        adjList.append(new VertexEdgeListPair(new Vertex(vertex), new LinkedListEdges()));
        // adjust numV
        numV = adjList.size();
    }

    public void removeVertex(String vertex) {
        // delete vertex edge pair 
        adjList.deleteAt(adjList.positionOf(adjList.traverseTo(vertex)));
        // iterate through all the vertices in the adjlist
        for (int i = 0; i < adjList.size(); i++) {
            // retreive edges of vertex
            LinkedListEdges edges = adjList.getValueAt(i).getEdges();
            // delete all edges at vertex that point to removed vertex
            for (int j = 0; j < edges.size(); j++) {
                if (edges.getValueAt(j).getEndPoint().getData() == vertex) {
                    edges.deleteAt(j);
                }
            }
        }
        // adjust numV
        numV = adjList.size();
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

    public LinkedList BFS(String vertex) {
        // declare and initialize linked list of visited vertex edge list pairs
        LinkedList visitedList = new LinkedList();
        // declare and initialize queue
        Queue queue = new Queue();
        // declare and initialize visited boolean array to represent visited vertices
        boolean[] visited = new boolean[adjList.size()];

        // set everything in visited array to false since no vertex has been visited yet
        for (int i = 0; i < adjList.size(); i++) {
            visited[i] = false;
        }

        // enqueue the first vertex
        queue.enqueue(adjList.traverseTo(vertex));
        // set element in visited array at vertex as true to represent visited vertex
        visited[adjList.positionOf(adjList.traverseTo(vertex))] = true;

        // perform BFS
        while (!queue.isEmpty()) {
            // dequeue from queue
            VertexEdgeListPair curPair = queue.dequeue();
            // append the dequeued vertex edge list pair to the visited list
            visitedList.append(curPair);
            // retreive edges of vertex
            LinkedListEdges edgesAtCurPair = curPair.getEdges();
            // iterate through all the edges of vertex
            for (int j = 0; j < edgesAtCurPair.size(); j++) {
                // retreive vertex edge list pair neighbor of vertex
                VertexEdgeListPair neighborVertexEdgeListPair = adjList.traverseTo(edgesAtCurPair.getValueAt(j).getEndPoint().getData());
                // if neighbor hasn't been visited, enqueue neighbor to queue and set it as true in visited array
                if (visited[adjList.positionOf(neighborVertexEdgeListPair)] == false) {
                    queue.enqueue(neighborVertexEdgeListPair);
                    visited[adjList.positionOf(neighborVertexEdgeListPair)] = true;
                }
            }
        }
        // return visited list of vertex edge list pairs
        return visitedList;
    }

    public LinkedList DFS(String vertex) {
        // declare and initialize linked list of visited vertex edge list pairs
        LinkedList visitedList = new LinkedList();
        // declare and initialize stack
        Stack stack = new Stack();
        // declare and initialize visited boolean array to represent visited vertices
        boolean[] visited = new boolean[adjList.size()];

        // set everything in visited array to false since no vertex has been visited yet
        for (int i = 0; i < adjList.size(); i++) {
            visited[i] = false;
        }

        // push the first vertex
        stack.push(adjList.traverseTo(vertex));
        // set element in visited array at vertex as true to represent visited vertex
        visited[adjList.positionOf(adjList.traverseTo(vertex))] = true;

        // perform DFS
        while (!stack.isEmpty()) {
            // pop from stack
            VertexEdgeListPair curPair = stack.pop();
            // append the popped vertex edge list pair to the visited list
            visitedList.append(curPair);
            // retreive edges of vertex
            LinkedListEdges edgesAtCurPair = curPair.getEdges();
            // iterate through all the edges of vertex
            for (int j = 0; j < edgesAtCurPair.size(); j++) {
                // retreive vertex edge list pair neighbor of vertex
                VertexEdgeListPair neighborVertexEdgeListPair = adjList.traverseTo(edgesAtCurPair.getValueAt(j).getEndPoint().getData());
                // if neighbor hasn't been visited, push neighbor to stack and set it as true in visited array
                if (visited[adjList.positionOf(neighborVertexEdgeListPair)] == false) {
                    stack.push(neighborVertexEdgeListPair);
                    visited[adjList.positionOf(neighborVertexEdgeListPair)] = true;
                }
            }
        }
        // return visited list of vertex edge list pairs
        return visitedList;
    }
}