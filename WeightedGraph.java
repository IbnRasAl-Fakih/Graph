import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, List<Vertex<V>>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(new Vertex<>(dest, weight));

        if (undirected)
            map.get(dest).add(new Vertex<>(source, weight));
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) return false;

        List<Vertex<V>> edges = map.get(source);
        for (Vertex<V> vertex : edges) {
            if (vertex.getVertex().equals(dest)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        List<V> vertices = new LinkedList<>();
        for (Vertex<V> e : map.get(v)) {
            vertices.add(e.getVertex());
        }
        return vertices;
    }

    public Iterable<Vertex<V>> getEdges(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }
}