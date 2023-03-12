import com.sun.source.tree.ReturnTree;

import java.io.*;
import java.util.Scanner;

public class zooPopulation {
    public static void main(String[] args) throws IOException {
        System.out.println("\n\nWelcome to Mac Mac's Zoo program!\n\n" + "I will be using the following info:\n\n");
        String animalsNames = "animalNames.txt";
        String names;
        String arrivingAnimals = "arrivingAnimals.txt";
        String animals;

        try {
            BufferedReader br = new BufferedReader(new FileReader(animalsNames));

            while ((names = br.readLine()) != null) {
                String[][] values;
                values = new String[][]{names.split(":" + ",")};
                System.out.println(values[0][0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader(arrivingAnimals));

            while ((animals = br.readLine()) != null) {
                String[][] values;
                values = new String[][]{animals.split(":" + ",")};
                System.out.println(values[0][0]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("\nLet's begin!\n");
    }

    static String calcBirth(int yearsOld, String birthSeason) {

        int year = 2023 - yearsOld;
        String monthDay;
        String newDate;

        switch (birthSeason) {
            case "spring,":
                monthDay = "03-19";
                break;
            case "summer,":
                monthDay = "04-19";
                break;
            case "fall,":
                monthDay = "08-19";
                break;
            case "winter,":
                monthDay = "12-19";
                break;
            default:
                monthDay = "01-01";
                break;
        }
        newDate = Integer.toString(year) + "-" + monthDay;

        return newDate;
    }

    static String genUniqueID(String speciesName, int numOfSpecies) {
        String uniqueID;

        switch (speciesName) {
            case "hyena":
                uniqueID = "Hy0" + Integer.toString(numOfSpecies);
                break;
            case "lion":
                uniqueID = "Li0" + Integer.toString(numOfSpecies);
                break;
            case "tiger":
                uniqueID = "Ti0" + Integer.toString(numOfSpecies);
                break;
            case "bear":
                uniqueID = "Be0" + Integer.toString(numOfSpecies);
                break;
            default:
                uniqueID = "error";
                break;
        }
        return uniqueID;
    }

    int numOfHyenas = 0;
    int numOfLions = 0;
    int numOfTigers = 0;
    int numOfBears = 0;
    int lineNum = 0;

 String [] zooAnimals [] (zooAnimals =new String[16]) {
        try {
            File myAnimalsFile = new File("arrivingAnimals.txt");
            Scanner scanner = new Scanner(myAnimalsFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                zooAnimals[lineNum] = line;
                lineNum++;
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e ;){
            System.out.println("\n A file error occured...");
            e.printStackTrace();
        }
        //System.out.println("\n The array...\n");
        for (String line : zooAnimals) {
            System.out.println(line);
        }
    }
}
