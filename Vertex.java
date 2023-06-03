import java.util.Objects;

public class Vertex<V> {
    private V vertex;
    private double weight;

    public Vertex(V vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public V getVertex() {
        return vertex;
    }

    public void setVertex(V vertex) {
        this.vertex = vertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(vertex, other.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }
}