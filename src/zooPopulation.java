import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class zooPopulation {
    public static void main(String[] args) throws IOException {
        String path = "animalNames.txt";
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[][] values;
                values = new String[][]{line.split(":" + ",")};
                System.out.println(values[0][0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
