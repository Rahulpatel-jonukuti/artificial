import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * CityCoordinates
 */
public class CityCoordinates {
    HashMap<String, ArrayList<Double>> hashMap = new HashMap<>();

    /* method to get the coordinates from the given coordinates file. */
    public HashMap<String, ArrayList<Double>> coordinates(String file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("\\s+", ",");
            String[] s = line.split(",");
            /* storing city name and its coordinates */
            this.hashMap.put(s[0], new ArrayList<>(Arrays.asList(Double.parseDouble(s[1]),
                    Double.parseDouble(s[2]))));
        }
        br.close();
        return hashMap;
    }

}
