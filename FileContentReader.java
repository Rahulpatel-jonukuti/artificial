import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileContentReader
 */
public class FileContentReader {

    /* method to read and store content from the given Adjacencies file */
    public ArrayList<String> getContent(String file) throws IOException {
        ArrayList<String> content = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            content.add(line);
        }
        br.close();
        return content;
    }
}
