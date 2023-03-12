import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class zooPopulationIoTest {
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
    /*static String genUniqueID (String speciesName, int numOfSpecies){
        String uniqueID;
        Switch (speciesName); {
            case "hyena"
                uniqueID = "Hy0" + numOfSpecies;
            break;
            case "lion"
                uniqueID = "Li0" + numOfSpecies;
            break;
            case "tiger"
                uniqueID = "Ti0" + numOfSpecies;
            break;
            case "bear"
                uniqueID = "Be0" + numOfSpecies;
            break;
        }
        return uniqueID;
    }
}
*/
