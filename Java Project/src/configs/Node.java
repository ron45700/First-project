package configs;
//package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Fields:
// - name (String): The name of the node.
// - edges (List<Node>): A list of other nodes connected to this node (outgoing edges).
// - message (String): Optional data or message associated with the node.

// Methods:
// - Node(String newName): Constructor that initializes the node's name and its edges list.
// - addEdge(Node node): Adds an edge (connection) from this node to the specified node.
// - hasCycles(): Returns true if this node belongs to a connected component in the graph that contains a cycle.
//   - This method should check all descendants recursively. If one of them leads back to this node, there is a cycle.
// - reset(): Clears all edges or resets the node's state (if needed, depending on implementation).


public class Node {
    private String name;
    private List<Node> edges;
    private graph.Message message;
    //private test.Message message;


    //constructor for the Node object, the constructor must get String name for creating
    public Node(String newName) {
        this.name = newName;
        this.edges = new ArrayList<Node>();
        this.message = null;
    }

    //sets & gets methods for each field
    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getEdges() {
        return edges;
    }
    public void setEdges(List<Node> edges) {
        this.edges = edges;
    }
/// _______________________________________
    public graph.Message getMsg(){
        return message;
    }
    public void setMsg(graph.Message message) {
        this.message = message;
    }
/// ______________________________
    public void addEdge(Node newNode) {
        edges.add(newNode);
    }

    public boolean hasCycles() {
        Set<Node> visited = new HashSet<Node>();
        Set<Node> stack = new HashSet<Node>();
        return isCyclic(this, visited, stack);
    }

    private boolean isCyclic(Node currentNode, Set<Node> visited, Set<Node> stack) {
        if (visited.contains(currentNode)) {
            return true; // Cycle detected
        }
        // If the node was already visited, skip further processing (mean the Node was 'black' AND NOT 'gray' which sign for having cycle)
        if (stack.contains(currentNode)) {
            return false; // Already processed
        }
        // Mark the current node as visited and add it to the recursion stack
        visited.add(currentNode);
        stack.add(currentNode);
        // Recursively check all neighboring nodes
        for (Node neighbor : currentNode.getEdges()) {
            if (isCyclic(neighbor, visited, stack)) {
                return true;
            }
        }

        stack.remove(currentNode);
        return false; // No cycle detected
    }


}