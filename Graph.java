import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Graph
 */
public class Graph {
    public Graph() {

    }

    public void addAdj(HashMap<String, ArrayList<Node>> adj, String u, String v) {
        Main cityCoordinates = new Main();
        /**
         * getting coordinates for the source and destination from the CityCoordinates
         * class
         */
        Double x2 = cityCoordinates.getCoordinates().get(u).get(0);
        Double x1 = cityCoordinates.getCoordinates().get(v).get(0);
        Double y1 = cityCoordinates.getCoordinates().get(v).get(1);
        Double y2 = cityCoordinates.getCoordinates().get(u).get(1);
        double theta = y1 - y2;
        double dist = Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2))
                + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        /*
         * adding source name and destination name and coordinates and distance to the
         * adj hashmap
         * note: using undirected graph
         * u->v
         * v<-u
         */
        adj.get(u).add(new Node(v, cityCoordinates.getCoordinates().get(v).get(0),
                cityCoordinates.getCoordinates().get(v).get(1), dist));
        adj.get(v).add(new Node(u, cityCoordinates.getCoordinates().get(u).get(0),
                cityCoordinates.getCoordinates().get(u).get(1), dist));

    }

    List<Node> res = new ArrayList<>();
    double minDist = Double.MAX_VALUE;

    /* method for finding shortest path */

    public List<Node> path(String source, String destination, List<String> visited, List<Node> list,
            double distance, HashMap<String, ArrayList<Node>> hashMap) {
        /*
         * if we reach the destination then check the minimum distance and return the
         * result
         */
        if (source.equals(destination)) {
            if (minDist > distance) {
                minDist = distance;
                res = new ArrayList<>(list);
            }
            return res;
        }
        visited.add(source);
        for (Node node : hashMap.get(source)) {
            /* if the city is already visited then continue */
            if (!visited.contains(node.city)) {
                list.add(node);
                path(node.city, destination, visited, list, distance + node.dist, hashMap);
                list.remove(node);
            } else
                continue;

        }
        return res;
    }

}
