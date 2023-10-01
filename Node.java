/**
 * Node
 */
public class Node {
    String city;
    Double coordinateX;
    Double CoordinateY;
    Double dist;

    // Node non-parametrized constructor
    public Node() {
    }

    // Node constructor
    public Node(String city) {
        this.city = city;
    }

    // Node constructor
    public Node(String city, Double coordinateX, Double coordinateY, Double dist) {
        this.city = city;
        this.coordinateX = coordinateX;
        this.CoordinateY = coordinateY;
        this.dist = dist;
    }
}
