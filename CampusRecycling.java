import java.io.*;
import java.util.Scanner;

public class CampusRecycling {
    public static void main(String[] args) throws Exception {
        String[] buildings = new String[21];
        buildings[0] = "Memorial Gymnasium";
        buildings[1] = "Hale Hall";
        buildings[2] = "George T. Madison Hall";
        buildings[3] = "Robinson Hall";
        buildings[4] = "Woodard Hall";
        buildings[5] = "Band Building";
        buildings[6] = "University Hall";
        buildings[7] = "Jay Taylor Visual Arts Center";
        buildings[8] = "Phillips Laboratory School";
        buildings[9] = "Institute for Micromanufacturing";
        buildings[10] = "Biomedical Engineering Building";
        buildings[11] = "Davison Hall";
        buildings[12] = "Adams Classroom";
        buildings[13] = "Howard Center";
        buildings[14] = "Bogard Hall";
        buildings[15] = "College of Business";
        buildings[16] = "Carson-Taylor Hall";
        buildings[17] = "Engineering Annex";
        buildings[18] = "Nethken Hall";
        buildings[19] = "Early Childhood Education Center";
        buildings[20] = "Integrated Engineering and Science Building";
        
        Graph campusMapGraph = new Graph();
        campusMapGraph.addVertex("Memorial Gymnasium");
        campusMapGraph.addVertex("Hale Hall");
        campusMapGraph.addVertex("George T. Madison Hall");
        campusMapGraph.addVertex("Robinson Hall");
        campusMapGraph.addVertex("Woodard Hall");
        campusMapGraph.addVertex("Band Building");
        campusMapGraph.addVertex("University Hall");
        campusMapGraph.addVertex("Jay Taylor Visual Arts Center");
        campusMapGraph.addVertex("Phillips Laboratory School");
        campusMapGraph.addVertex("Institute for Micromanufacturing");
        campusMapGraph.addVertex("Biomedical Engineering Building");
        campusMapGraph.addVertex("Davison Hall");
        campusMapGraph.addVertex("Adams Classroom");
        campusMapGraph.addVertex("Howard Center");
        campusMapGraph.addVertex("Bogard Hall");
        campusMapGraph.addVertex("College of Business");
        campusMapGraph.addVertex("Carson-Taylor Hall");
        campusMapGraph.addVertex("Engineering Annex");
        campusMapGraph.addVertex("Nethken Hall");
        campusMapGraph.addVertex("Early Childhood Education Center");
        campusMapGraph.addVertex("Integrated Engineering and Science Building");
        // edges from Memorial Gymnasium
        campusMapGraph.addEdge("Memorial Gymnasium", "Hale Hall", 370);
        campusMapGraph.addEdge("Memorial Gymnasium", "Robinson Hall", 250);
        campusMapGraph.addEdge("Memorial Gymnasium", "Jay Taylor Visual Arts Center", 508);
        // edges from Hale Hall
        campusMapGraph.addEdge("Hale Hall", "Memorial Gymnasium", 370);
        campusMapGraph.addEdge("Hale Hall", "George T. Madison Hall", 550);
        // edges from George T. Madison Hall
        campusMapGraph.addEdge("George T. Madison Hall", "Hale Hall", 550);
        campusMapGraph.addEdge("George T. Madison Hall", "University Hall", 1500);
        campusMapGraph.addEdge("George T. Madison Hall", "College of Business", 1500);
        // edges from Robinson Hall
        campusMapGraph.addEdge("Robinson Hall", "Memorial Gymnasium", 250);
        // edges from Woodard Hall
        campusMapGraph.addEdge("Woodard Hall", "Hale Hall", 1380);
        campusMapGraph.addEdge("Woodard Hall", "George T. Madison Hall", 1140);
        // edges from Band Building
        campusMapGraph.addEdge("Band Building", "Memorial Gymnasium", 710);
        campusMapGraph.addEdge("Band Building", "Jay Taylor Visual Arts Center", 430);
        // edges from University Hall
        campusMapGraph.addEdge("University Hall", "College of Business", 1200);
        campusMapGraph.addEdge("University Hall", "Engineering Annex", 920);
        // edges from Jay Taylor Visual Arts Center
        campusMapGraph.addEdge("Jay Taylor Visual Arts Center", "Memorial Gymnasium", 508);
        campusMapGraph.addEdge("Jay Taylor Visual Arts Center", "Band Building", 430);
        campusMapGraph.addEdge("Jay Taylor Visual Arts Center", "Phillips Laboratory School", 521);
        campusMapGraph.addEdge("Jay Taylor Visual Arts Center", "Institute for Micromanufacturing", 1200);
        // edges from Phillips Laboratory School
        campusMapGraph.addEdge("Phillips Laboratory School", "Institute for Micromanufacturing", 980);
        campusMapGraph.addEdge("Phillips Laboratory School", "Davison Hall", 715);
        // edges from Institute for Micromanufacturing
        campusMapGraph.addEdge("Institute for Micromanufacturing", "Jay Taylor Visual Arts Center", 1200);
        campusMapGraph.addEdge("Institute for Micromanufacturing", "Biomedical Engineering Building", 550);
        // edges from Biomedical Engineering Building
        campusMapGraph.addEdge("Biomedical Engineering Building", "Davison Hall", 1753);
        // edges from Davison Hall
        campusMapGraph.addEdge("Davison Hall", "Woodard Hall", 1070);
        campusMapGraph.addEdge("Davison Hall", "Biomedical Engineering Building", 1753);
        campusMapGraph.addEdge("Davison Hall", "Adams Classroom", 200);
        campusMapGraph.addEdge("Davison Hall", "Carson-Taylor Hall", 1650);
        // edges from Adams Classroom
        campusMapGraph.addEdge("Adams Classroom", "Davison Hall", 200);
        // edges from Howard Center
        campusMapGraph.addEdge("Howard Center", "Davison Hall", 1850);
        campusMapGraph.addEdge("Howard Center", "Adams Classroom", 1680);
        campusMapGraph.addEdge("Howard Center", "Engineering Annex", 450);
        // edges from Bogard Hall
        campusMapGraph.addEdge("Bogard Hall", "Howard Center", 350);
        campusMapGraph.addEdge("Bogard Hall", "Carson-Taylor Hall", 250);
        // edges from College of Business
        campusMapGraph.addEdge("College of Business", "George T. Madison Hall", 1500);
        campusMapGraph.addEdge("College of Business", "University Hall", 420);
        campusMapGraph.addEdge("College of Business", "Early Childhood Education Center", 490);
        campusMapGraph.addEdge("College of Business", "Integrated Engineering and Science Building", 910);
        // edges from Carson-Taylor Hall
        campusMapGraph.addEdge("Carson-Taylor Hall", "Engineering Annex", 450);
        // edges from Engineering Annex
        campusMapGraph.addEdge("Engineering Annex", "Bogard Hall", 380);
        campusMapGraph.addEdge("Engineering Annex", "Nethken Hall", 210);
        // edges from Nethken Hall
        campusMapGraph.addEdge("Nethken Hall", "Integrated Engineering and Science Building", 320);
        // edges from Early Childhood Education Center
        campusMapGraph.addEdge("Early Childhood Education Center", "Integrated Engineering and Science Building", 1160);
        // edges from Integrated Engineering and Science Building
        campusMapGraph.addEdge("Integrated Engineering and Science Building", "College of Business", 910);
        campusMapGraph.addEdge("Integrated Engineering and Science Building", "Nethken Hall", 320);
        campusMapGraph.addEdge("Integrated Engineering and Science Building", "Early Childhood Education Center", 490);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("\nWhich building do you want to start with? (Type 'list' for a list of buildings) ");
            input = scanner.nextLine();
            if (input.compareTo("list") == 0) {
                for (int i = 0; i < buildings.length; i++) {
                    System.out.println(buildings[i]);
                }
            }
            if (input.compareTo("list") != 0) {
                boolean inputIsCorrect = false;
                for (int i = 0; i < buildings.length; i++) {
                    if (buildings[i].compareTo(input) == 0) {
                        inputIsCorrect = true;
                        break;
                    }
                }
                if (inputIsCorrect == true) {
                    break;
                }
                System.out.println("\nInput incorrect. Please select a building from 'list'.");
            }
        }
        // create output file
        File outputFile = new File("output.txt");
        outputFile.createNewFile();
        FileWriter writer = new FileWriter(outputFile);

        writer.write("User input: " + input + "\n");

        long startTimeBFS;
        long endTimeBFS;
        long totalTimeBFS;

        long startTimeDFS;
        long endTimeDFS;
        long totalTimeDFS;

        long startTimeDijkstras;
        long endTimeDijkstras;
        long totalTimeDijkstras;

        long startTimePrimsShort;
        long endTimePrimsShort;
        long totalTimePrimsShort;
        
        long startTimePrimsLong;
        long endTimePrimsLong;
        long totalTimePrimsLong;

        startTimeBFS = System.nanoTime();
        LinkedList BFSPath = campusMapGraph.BFS(input);
        endTimeBFS = System.nanoTime();
        totalTimeBFS = endTimeBFS - startTimeBFS;

        startTimeDFS = System.nanoTime();
        LinkedList DFSPath = campusMapGraph.DFS(input);
        endTimeDFS = System.nanoTime();
        totalTimeDFS = endTimeDFS - startTimeDFS;

        startTimeDijkstras = System.nanoTime();
        LinkedList dijkstrasPath = campusMapGraph.dijkstrasAlgorithm(input);
        endTimeDijkstras = System.nanoTime();
        totalTimeDijkstras = endTimeDijkstras - startTimeDijkstras;

        startTimePrimsShort = System.nanoTime();
        LinkedList primsShortPath = campusMapGraph.PrimsAlgorithmshort(input);
        endTimePrimsShort = System.nanoTime();
        totalTimePrimsShort = endTimePrimsShort - startTimePrimsShort;
        
        startTimePrimsLong = System.nanoTime();
        LinkedList primsLongPath = campusMapGraph.PrimsAlgorithmlong(input);
        endTimePrimsLong = System.nanoTime();
        totalTimePrimsLong = endTimePrimsLong - startTimePrimsLong;

        long fastestTime = Math.min(Math.min(totalTimeBFS, totalTimeDFS), Math.min(totalTimeDijkstras, Math.min(totalTimePrimsShort, totalTimePrimsLong)));
        // long fastestTime = Math.min(totalTimeBFS, Math.min(totalTimeDijkstras, totalTimeDFS));

        // BFS
        writer.write("\nBFS:\n");
        for (int i = 0; i < BFSPath.size(); i++) {
            writer.write("\t" + BFSPath.getValueAt(i).getVertex().getData() + "\n");
        }
        writer.write("BFS total cost: " + campusMapGraph.BFSTotalCost + "\n");
        writer.write("BFS time: " + totalTimeBFS + " nanoseconds\n");

        // DFS
        writer.write("\nDFS:\n");
        for (int i = 0; i < DFSPath.size(); i++) {
            writer.write("\t" + DFSPath.getValueAt(i).getVertex().getData() + "\n");
        }
        writer.write("DFS total cost: " + campusMapGraph.DFSTotalCost + "\n");
        writer.write("DFS time: " + totalTimeDFS + " nanoseconds\n");

        // Dijkstras
        writer.write("\nDijkstras:\n");
        for (int i = 0; i < dijkstrasPath.size(); i++) {
            writer.write("\t" + dijkstrasPath.getValueAt(i).getVertex().getData() + "\n");
        }
        writer.write("Dijkstras total cost: " + campusMapGraph.dijkstrasTotalCost + "\n");
        writer.write("Dijkstras time: " + totalTimeDijkstras + " nanoseconds\n");

        // Prims minimum
        writer.write("\nPrims minimum:\n");
        for (int i = 0; i < primsShortPath.size(); i++) {
            writer.write("\t" + primsShortPath.getValueAt(i).getVertex().getData() + "\n");
        }
        writer.write("Prims minimum total cost: " + campusMapGraph.primsShortTotalCost + "\n");
        writer.write("Prims minimum time: " + totalTimePrimsShort + " nanoseconds\n");

        // Prims maximum
        writer.write("\nPrims maximum:\n");
        for (int i = 0; i < primsLongPath.size(); i++) {
            writer.write("\t" + primsLongPath.getValueAt(i).getVertex().getData() + "\n");
        }
        writer.write("Prims maximum total cost: " + campusMapGraph.primsLongTotalCost + "\n");
        writer.write("Prims maximum time: " + totalTimePrimsLong + " nanoseconds\n");

        writer.write("\nRecommendations:\n");
        writer.write("\tWorkers want to empty bins as fast as possible: \n");
        if (fastestTime == totalTimeBFS) {
            writer.write("\t\tFastest path (BFS): \n");
            for (int i = 0; i < BFSPath.size(); i++) {
                writer.write("\t\t\t" + BFSPath.getValueAt(i).getVertex().getData() + "\n");
            }
            writer.write("\t\tTotal cost: " + campusMapGraph.BFSTotalCost + "\n");
        }
        if (fastestTime == totalTimeDFS) {
            writer.write("\t\tFastest path (DFS): \n");
            for (int i = 0; i < DFSPath.size(); i++) {
                writer.write("\t\t\t" + DFSPath.getValueAt(i).getVertex().getData() + "\n");
            }
            writer.write("\t\tTotal cost: " + campusMapGraph.DFSTotalCost + "\n");
        }
        if (fastestTime == totalTimeDijkstras) {
            writer.write("\t\tFastest path (dijkstras): \n");
            for (int i = 0; i < dijkstrasPath.size(); i++) {
                writer.write("\t\t\t" + dijkstrasPath.getValueAt(i).getVertex().getData() + "\n");
            }
            writer.write("\t\tTotal cost: " + campusMapGraph.dijkstrasTotalCost + "\n");
        }
        if (fastestTime == totalTimePrimsShort) {
            writer.write("\t\tFastest path (Prims minimum): \n");
            for (int i = 0; i < primsShortPath.size(); i++) {
                writer.write("\t\t\t" + primsShortPath.getValueAt(i).getVertex().getData() + "\n");
            }
            writer.write("\t\tTotal cost: " + campusMapGraph.primsShortTotalCost + "\n");
        }
        if (fastestTime == totalTimePrimsLong) {
            writer.write("\t\tFastest path (Prims maximum): \n");
            for (int i = 0; i < primsLongPath.size(); i++) {
                writer.write("\t\t\t" + primsLongPath.getValueAt(i).getVertex().getData() + "\n");
            }
            writer.write("\t\tTotal cost: " + campusMapGraph.primsLongTotalCost + "\n");
        }

        writer.write("\n\tWorkers want to drag out the task as long as possible without being obvious: \n");
        writer.write("\t\tBest path: \n");
        for (int i = 0; i < primsLongPath.size(); i++) {
            writer.write("\t\t\t" + primsLongPath.getValueAt(i).getVertex().getData() + "\n");
        }
        writer.write("\t\tTotal cost: " + campusMapGraph.primsLongTotalCost + "\n");

        writer.write("\nEfficiency (least distance): \n");
        if (campusMapGraph.dijkstrasTotalCost > campusMapGraph.primsShortTotalCost) {
            writer.write("\tPrims minimum is more efficient.\n");
        }
        if (campusMapGraph.dijkstrasTotalCost < campusMapGraph.primsShortTotalCost) {
            writer.write("\tDijkstras is more efficient.\n");
        }

        writer.write("\nEfficiency (time analysis): \n");
        if (totalTimeDijkstras > totalTimePrimsShort) {
            writer.write("\tPrims minimum is more efficient.\n");
        }
        if (totalTimeDijkstras < totalTimePrimsShort) {
            writer.write("\tDijkstras is more efficient.\n");
        }

        writer.close();
    }
}

class Graph {
    public LinkedList adjList;
    private boolean directed;
    private int numV;

    public int BFSTotalCost;
    public int DFSTotalCost;
    public int dijkstrasTotalCost;
    public int primsShortTotalCost;
    public int primsLongTotalCost;
    
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
        BFSTotalCost = 0;
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
                    BFSTotalCost += getEdge(curPair.getVertex().getData(),neighborVertexEdgeListPair.getVertex().getData()).getWeight();
                    queue.enqueue(neighborVertexEdgeListPair);
                    visited[adjList.positionOf(neighborVertexEdgeListPair)] = true;
                }
            }
        }
        // return visited list of vertex edge list pairs
        return visitedList;
    }

    public LinkedList DFS(String vertex) {
        DFSTotalCost = 0;
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
                    DFSTotalCost += getEdge(curPair.getVertex().getData(),neighborVertexEdgeListPair.getVertex().getData()).getWeight();
                    stack.push(neighborVertexEdgeListPair);
                    visited[adjList.positionOf(neighborVertexEdgeListPair)] = true;
                }
            }
        }
        // return visited list of vertex edge list pairs
        return visitedList;
    }

    public LinkedList dijkstrasAlgorithm(String vertex) {
        LinkedList shortestPath = new LinkedList();
        boolean[] known = new boolean[adjList.size()];
        int[] cost = new int[adjList.size()];
        VertexEdgeListPair[] path = new VertexEdgeListPair[adjList.size()];
        Stack[] paths = new Stack[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            known[i] = false;
            cost[i] = Integer.MAX_VALUE;
            path[i] = null;
        }
        
        VertexEdgeListPair curPair = adjList.traverseTo(vertex);
        cost[adjList.positionOf(curPair)] = 0;
        
        while (true) {
            int curPairIndex = adjList.positionOf(curPair);

            known[curPairIndex] = true;
    
            LinkedListEdges edges = curPair.getEdges();
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.getValueAt(j);
                int edgeEndPointIndex = adjList.positionOf(adjList.traverseTo(edge.getEndPoint().getData()));
                if (cost[edgeEndPointIndex] > cost[curPairIndex] + edge.getWeight() && known[edgeEndPointIndex] == false) {
                    cost[edgeEndPointIndex] = cost[curPairIndex] + edge.getWeight();
                    path[edgeEndPointIndex] = curPair;
                }
            }

            int minUnknownIndex = 0;
            int min = Integer.MAX_VALUE;
            boolean shortestPathFound = true;
            for (int k = 0; k < cost.length; k++) {
                if (cost[k] < min && cost[k] != 0 && known[k] == false) {
                    min = cost[k];
                    minUnknownIndex = k;
                    shortestPathFound = false;
                }
            }
            if (shortestPathFound == true) {
                break;
            }
            curPair = adjList.getValueAt(minUnknownIndex);
        }

        // build stacks of paths
        for (int i = 0; i < adjList.size(); i++) {
            paths[i] = new Stack();
            paths[i].push(adjList.getValueAt(i));

            if (path[i] != null) {
                paths[i].push(path[i]);
                int j = adjList.positionOf(path[i]);
                while (path[j] != null) {
                    paths[i].push(path[j]);
                    j = adjList.positionOf(path[j]);
                }
            } 
        }
        
        // find the biggest stack with the lowest cost
        Stack biggestStackWithLowestCost = paths[0];
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < adjList.size(); i++) {
            if (paths[i].size() == biggestStackWithLowestCost.size() && cost[i] < minCost) {
                biggestStackWithLowestCost = paths[i];
                minCost = cost[i];
            }
            if (paths[i].size() > biggestStackWithLowestCost.size()) {
                biggestStackWithLowestCost = paths[i];
                minCost = cost[i];
            }
        }

        dijkstrasTotalCost = minCost;
        
        // pop everything in stack to a linked list of shortest path
        while (!biggestStackWithLowestCost.isEmpty()) {
            shortestPath.append(biggestStackWithLowestCost.pop());
        }

        return shortestPath;
    }
    
    public int minKey(int cost[], boolean visited[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, minindex = 0;
  
        for (int k = 0; k < adjList.size(); k++) {
            if (cost[k] < min && visited[k] == false) {
                min = cost[k];
                minindex = k;
            }
        }

        return minindex;
    }

    public int maxKey(int cost[], boolean visited[]) {
        // Initialize min value
        int max = 0, maxindex = 0;
  
        for (int k = 0; k < adjList.size(); k++) {
            if (cost[k] > max && visited[k] == false) {
                max = cost[k];
                maxindex = k;
            }
        }
  
        return maxindex;
    }

    public LinkedList PrimsAlgorithmshort(String vertex) {
        LinkedList visitedList = new LinkedList();
        int parent[] = new int[adjList.size()];
        boolean[] known = new boolean[adjList.size()];
        int[] cost = new int[adjList.size()];
        primsShortTotalCost = 0;

        for (int i = 0; i < adjList.size(); i++) {
            known[i] = false;
            cost[i] = Integer.MAX_VALUE;
        }
        
        VertexEdgeListPair curPair = adjList.traverseTo(vertex);
        cost[adjList.positionOf(curPair)] = 0;
        parent[adjList.positionOf(curPair)] = -1;
        for(int v = 0; v < adjList.size()-1; v++) {
            
            int minUnknownIndex = minKey(cost,known);
            known[minUnknownIndex] = true;

            curPair = adjList.getValueAt(minUnknownIndex);
            visitedList.append(curPair);
            primsShortTotalCost += cost[adjList.positionOf(curPair)];
        
            LinkedListEdges neighbors = curPair.getEdges();
            for (int i = 0; i < neighbors.size(); i++) {
            
                Vertex nextVertex = neighbors.getValueAt(i).getOpposite(curPair.getVertex());
                int weightofEdge = getEdge(curPair.getVertex().getData(),nextVertex.getData()).getWeight();
                VertexEdgeListPair neighborPair = adjList.traverseTo(nextVertex.getData());
                if(weightofEdge != 0 && known[adjList.positionOf(neighborPair)] == false && weightofEdge < cost[adjList.positionOf(neighborPair)]){
                    parent[adjList.positionOf(neighborPair)] = adjList.positionOf(curPair);
                    cost[adjList.positionOf(neighborPair)] = weightofEdge;
                }
            }
        }
        return visitedList;
    }

    public LinkedList PrimsAlgorithmlong(String vertex) {
        LinkedList visitedList = new LinkedList();
        int parent[] = new int[adjList.size()];
        boolean[] known = new boolean[adjList.size()];
        int[] cost = new int[adjList.size()];
        primsLongTotalCost = 0;

        for (int i = 0; i < adjList.size(); i++) {
            known[i] = false;
            cost[i] = 0;
        }
        
        VertexEdgeListPair curPair = adjList.traverseTo(vertex);
        cost[adjList.positionOf(curPair)] = 0;
        parent[adjList.positionOf(curPair)] = -1;
        for(int v = 0; v < adjList.size()-1; v++) {
            if(v == 0){
                curPair = adjList.getValueAt(adjList.positionOf(curPair));
                known[adjList.positionOf(curPair)] = true;
            }
            else{
                int maxUnkownIndex = maxKey(cost,known);
                known[maxUnkownIndex] = true;
                curPair = adjList.getValueAt(maxUnkownIndex);
            }
            visitedList.append(curPair);
            primsLongTotalCost += cost[adjList.positionOf(curPair)];
        
            LinkedListEdges neighbors = curPair.getEdges();
            for (int i = 0; i < neighbors.size(); i++) {
            
                Vertex nextVertex = neighbors.getValueAt(i).getOpposite(curPair.getVertex());
                int weightofEdge = getEdge(curPair.getVertex().getData(),nextVertex.getData()).getWeight();
                VertexEdgeListPair neighborPair = adjList.traverseTo(nextVertex.getData());
                if(weightofEdge != 0 && known[adjList.positionOf(neighborPair)] == false && weightofEdge > cost[adjList.positionOf(neighborPair)]){
                    parent[adjList.positionOf(neighborPair)] = adjList.positionOf(curPair);
                    cost[adjList.positionOf(neighborPair)] = weightofEdge;
                }
            }
        }
        return visitedList;
    }
            
}
