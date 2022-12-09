import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q2 {
    public static void main(String[] args) {
        HashSet<Integer> vertices = new HashSet<>();
        vertices.addAll(List.of(1,2,3,4,5));
        Pair e1 = new Pair(1, 2);
        Pair e2 = new Pair(3, 4);
        Pair e3 = new Pair(1, 5);
        Pair e4 = new Pair(3, 2);
        List<Pair> edges = List.of(e1,e2,e3,e4);
        Graph graph = new Graph(vertices, edges);

        graph.printGraph();


        System.out.println("add edge 1-4");
        graph.addEdge(new Pair(1, 4));
        graph.printGraph();

        System.out.println("remove edge 1-5");
        graph.removeEdge(new Pair(1, 5));
        graph.printGraph();

        System.out.println("remove vertex 1");
        graph.removeVertex(1);
        graph.printGraph();

        System.out.println("add vertex 6");
        graph.addVertex(6);
        graph.printGraph();

        System.out.println("\nAll Vertex");
        System.out.println(graph.getVertices());

        System.out.println("\nAll Edges");
        System.out.println(graph.getEdges());


    }    
}

class Graph {
    public HashSet<Integer> vertices;
    public List<Pair> edges;
    HashMap<Integer, Set<Integer>> graph = new HashMap<>();

    private void buildGraph(List<Pair> edges) {
        for(Pair p: edges) {
            graph.putIfAbsent(p.src, new HashSet<Integer>());
            graph.putIfAbsent(p.dest, new HashSet<Integer>());
            graph.get(p.src).add(p.dest);
            graph.get(p.dest).add(p.src);
        }
    }
    public void addEdge(Pair p) {
        graph.putIfAbsent(p.src, new HashSet<Integer>());
        graph.putIfAbsent(p.dest, new HashSet<Integer>());
        graph.get(p.src).add(p.dest);
        graph.get(p.dest).add(p.src);

        this.vertices.add(p.src);
        this.vertices.add(p.dest);
        this.edges.add(p);
    }

    public void removeEdge(Pair p) {
        if(graph.containsKey(p.src) && graph.get(p.src).contains(p.dest)) {
            graph.get(p.src).remove(p.dest);
        }
        if(graph.containsKey(p.dest) && graph.get(p.dest).contains(p.src)) {
            graph.get(p.dest).remove(p.src);
        }
        edges.removeIf((item) -> item.src == p.src && item.dest == p.dest);
    }

    public void removeVertex(int v) {
        if(vertices.contains(v)) vertices.remove(v);
        if(graph.containsKey(v)) {
            for(int neighbor: graph.get(v)) {
                graph.get(neighbor).remove(v);
            }
            graph.remove(v);
        }
    }
    public void addVertex(int v) {
        this.vertices.add(v);
        graph.putIfAbsent(v, new HashSet<>());
    }

    public Set<Integer> getVertices() { return this.vertices; }

    public List<Pair> getEdges() { return this.edges; }

    public void printGraph() {
        for(int v: vertices) {
            System.out.print(v + " --> ");
            if(graph.containsKey(v)) {
                System.out.println(graph.get(v));
            }
        }
    }

    public Graph(HashSet<Integer> vertices, List<Pair> edges) {
        this.vertices = vertices;
        this.edges = new ArrayList<>(edges);
        buildGraph(edges);
    }


}
class Pair {
    int src;
    int dest;
    public Pair(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
    public String toString() {
        return "(" + this.src + "," + this.dest + ")";
    }
}
