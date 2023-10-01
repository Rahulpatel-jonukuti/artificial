import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * Main
 */
public class Main {
    static java.util.HashMap<String, ArrayList<Double>> hashMap;
    static Main m;
    static HashMap<String, ArrayList<Node>> adj;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // storing content given in the Adjacencies text file.
        ArrayList<String> content = new FileContentReader().getContent(".\\Adjacencies.txt");

        m = new Main();
        /**
         * storing city names and its coordinates from the given coordinates text file
         * key=> city name value=> list of city
         * coordinates.
         */
        hashMap = new CityCoordinates().coordinates(".\\coordinates.txt");
        /*
         * for storing adjacent cities for the each city.
         */
        adj = new HashMap<>();
        for (String city : hashMap.keySet()) {
            adj.put(city, new ArrayList<>());
        }
        Graph graph = new Graph();

        for (String edges : content) {
            /**
             * splitting the content that we got form the Adjacencies file and add
             * respective adjacent cities to it.
             */
            String edge[] = edges.replaceAll("\\s+", " ").strip().split(" ");
            String u = edge[0];

            if (adj.containsKey(u)) {
                for (int i = 1; i < edge.length; i++) {
                    if (adj.containsKey(edge[i]))
                        graph.addAdj(adj, u, edge[i]);
                }
            }

        }
        // source and destination values
        String source = "Anthony ";
        String destination = "Mayfield ";
        if (source.length() == 0 || destination.length() == 0) {
            System.out.println("please enter source and destination");
            return;
        }
        // result
        List<Node> path = (graph.path(source.strip(), destination.strip(), new ArrayList<>(), new ArrayList<>(), 0,
                adj));
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        if (path.size() > 0) {

            System.out.print(source + "-> ");
            for (Node node : path) {
                System.out.print(node.city + "-> ");
            }
            System.out.println("End");
        } else {
            System.out.println("No path was found!");
            return;
        }

    }

    public HashMap<String, ArrayList<Double>> getCoordinates() {

        return hashMap;
    }

}