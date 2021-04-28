public class CampusRecycling {
    public static void main(String[] args) {
        Graph newGraph = new Graph();
        newGraph.addVertex("Memorial Gymnasium");
        newGraph.addVertex("Hale Hall");
        newGraph.addVertex("George T. Madison Hall");
        newGraph.addVertex("Robinson Hall");
        newGraph.addVertex("Woodard Hall");
        newGraph.addVertex("Band Building");
        newGraph.addVertex("University Hall");
        newGraph.addVertex("Jay Taylor Visual Arts Center");
        newGraph.addVertex("Phillips Laboratory School");
        newGraph.addVertex("Institute for Micromanufacturing");
        newGraph.addVertex("Biomedical Engineering Building");
        newGraph.addVertex("Davison Hall");
        newGraph.addVertex("Adams Classroom");
        newGraph.addVertex("Howard Center");
        newGraph.addVertex("Bogard Hall");
        newGraph.addVertex("College of Business");
        newGraph.addVertex("Carson-Taylor Hall");
        newGraph.addVertex("Engineering Annex");
        newGraph.addVertex("Nethken Hall");
        newGraph.addVertex("Early Childhood Education Center");
        newGraph.addVertex("Integrated Engineering and Science Building");
        // edges from Memorial Gymnasium
        newGraph.addEdge("Memorial Gymnasium", "Hale Hall", 370);
        newGraph.addEdge("Memorial Gymnasium", "Robinson Hall", 250);
        newGraph.addEdge("Memorial Gymnasium", "Jay Taylor Visual Arts Center", 508);
        // edges from Hale Hall
        newGraph.addEdge("Hale Hall", "Memorial Gymnasium", 370);
        newGraph.addEdge("Hale Hall", "George T. Madison Hall", 550);
        // edges from George T. Madison Hall
        newGraph.addEdge("George T. Madison Hall", "Hale Hall", 550);
        newGraph.addEdge("George T. Madison Hall", "University Hall", 1500);
        newGraph.addEdge("George T. Madison Hall", "College of Business", 1500);
        // edges from Robinson Hall
        newGraph.addEdge("Robinson Hall", "Memorial Gymnasium", 250);
        // edges from Woodard Hall
        newGraph.addEdge("Woodard Hall", "Hale Hall", 1380);
        newGraph.addEdge("Woodard Hall", "George T. Madison Hall", 1140);
        // edges from Band Building
        newGraph.addEdge("Band Building", "Memorial Gymnasium", 710);
        newGraph.addEdge("Band Building", "Jay Taylor Visual Arts Center", 430);
        // edges from University Hall
        newGraph.addEdge("University Hall", "College of Business", 1200);
        newGraph.addEdge("University Hall", "Engineering Annex", 920);
        // edges from Jay Taylor Visual Arts Center
        newGraph.addEdge("Jay Taylor Visual Arts Center", "Memorial Gymnasium", 508);
        newGraph.addEdge("Jay Taylor Visual Arts Center", "Band Building", 430);
        newGraph.addEdge("Jay Taylor Visual Arts Center", "Phillips Laboratory School", 521);
        newGraph.addEdge("Jay Taylor Visual Arts Center", "Institute for Micromanufacturing", 1200);
        // edges from Phillips Laboratory School
        newGraph.addEdge("Phillips Laboratory School", "Institute for Micromanufacturing", 980);
        newGraph.addEdge("Phillips Laboratory School", "Davison Hall", 715);
        // edges from Institute for Micromanufacturing
        newGraph.addEdge("Institute for Micromanufacturing", "Jay Taylor Visual Arts Center", 1200);
        newGraph.addEdge("Institute for Micromanufacturing", "Biomedical Engineering Building", 550);
        // edges from Biomedical Engineering Building
        newGraph.addEdge("Biomedical Engineering Building", "Davison Hall", 1753);
        // edges from Davison Hall
        newGraph.addEdge("Davison Hall", "Woodard Hall", 1070);
        newGraph.addEdge("Davison Hall", "Biomedical Engineering Building", 1753);
        newGraph.addEdge("Davison Hall", "Adams Classroom", 200);
        newGraph.addEdge("Davison Hall", "Carson-Taylor Hall", 1650);
        // edges from Adams Classroom
        newGraph.addEdge("Adams Classroom", "Davison Hall", 200);
        // edges from Howard Center
        newGraph.addEdge("Howard Center", "Davison Hall", 1850);
        newGraph.addEdge("Howard Center", "Adams Classroom", 1680);
        newGraph.addEdge("Howard Center", "Engineering Annex", 450);
        // edges from Bogard Hall
        newGraph.addEdge("Bogard Hall", "Howard Center", 350);
        newGraph.addEdge("Bogard Hall", "Carson-Taylor Hall", 250);
        // edges from College of Business
        newGraph.addEdge("College of Business", "George T. Madison Hall", 1500);
        newGraph.addEdge("College of Business", "University Hall", 420);
        newGraph.addEdge("College of Business", "Early Childhood Education Center", 490);
        newGraph.addEdge("College of Business", "Integrated Engineering and Science Building", 910);
        // edges from Carson-Taylor Hall
        newGraph.addEdge("Carson-Taylor Hall", "Engineering Annex", 450);
        // edges from Engineering Annex
        newGraph.addEdge("Engineering Annex", "Bogard Hall", 380);
        newGraph.addEdge("Engineering Annex", "Nethken Hall", 210);
        // edges from Nethken Hall
        newGraph.addEdge("Nethken Hall", "Integrated Engineering and Science Building", 320);
        // edges from Early Childhood Education Center
        newGraph.addEdge("Early Childhood Education Center", "Integrated Engineering and Science Building", 1160);
        // edges from Integrated Engineering and Science Building
        newGraph.addEdge("Integrated Engineering and Science Building", "College of Business", 910);
        newGraph.addEdge("Integrated Engineering and Science Building", "Nethken Hall", 320);
        newGraph.addEdge("Integrated Engineering and Science Building", "Early Childhood Education Center", 490);
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

    // public LinkedList dijkstrasAlgorithm(String vertex) {
    //     LinkedList visitedList = new LinkedList();
    //     boolean[] known = new boolean[adjList.size()];
    //     int[] cost = new int[adjList.size()];
    //     VertexEdgeListPair[] path = new VertexEdgeListPair[adjList.size()];
        
    // }
}