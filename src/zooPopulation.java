import java.io.*;
import java.util.Scanner;
import static java.lang.Integer.*;
import static java.lang.System.*;
public class zooPopulation {
    static String calcBirth(int yearOld, String birthSeason) {
        int year = 2023 - yearOld;
        //java.lang.String birthSeason = "01-01";
        java.lang.String monthDay = switch (birthSeason) {
            case "spring," -> "03-19";
            case "summer," -> "5-21";
            case "fall," -> "08-19";
            case "winter," -> "12-19";
            default -> birthSeason;
        };
        String newDate = (year + "-" + monthDay);
        return newDate;
    }

    static String genUniqueID(String speciesName, int numOfSpecies) {
        return switch (speciesName) {
            case "hyena" -> "Hy0" + numOfSpecies;
            case "lion" -> "Li0" + numOfSpecies;
            case "tiger" -> "Ti0" + numOfSpecies;
            case "bear" -> "Be0" + numOfSpecies;
            default -> "error";
        };
    }

    public static void main(String[] args) throws IOException {
        out.println("""

                Welcome to Mac Mac's Zoo program!

                I will be using the info above:

                """);
        String animalsNames = "animalNames.txt";
        String names;
        String arrivingAnimals = "arrivingAnimals.txt";
        String arriving;
        try {
            BufferedReader br = new BufferedReader(new FileReader(animalsNames));
            while ((names = br.readLine()) != null) {
                String[][] values;
                values = new String[][]{names.split(":" + ",")};
                out.println(values[0][0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        out.println("\n");
        int lineNum = 0;
        String[] animals = new String[16];
        try {
            File myAnimals = new File("arrivingAnimals.txt");
            Scanner scanner = new Scanner(myAnimals);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                animals[lineNum] = line;
                lineNum++;
                out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            out.println("\n A file error occured...");
            e.printStackTrace();
        }
        out.println("\nLet's begin!\n");

        int numOfHyenas = 0;
        int numOfLions = 0;
        int numOfTigers = 0;
        int numOfBears = 0;
        int years = 0;
        String season;
        String sex;
        String species;
        String color;
        String origin;
        String weight;
        String name;
        String uniqueID = "xyz";
        String arrived;
        for (int i = 0; i<16; i++) {
            String[] splitAnimals = animals[i].split(" ", 0);
            String[] splitStrComma = animals[i].split(",",0);
        /*for (String s: splitAnimals) {
            System.out.println(s);
        }*/
            String birthdate = calcBirth(Integer.parseInt(splitAnimals[0]), splitAnimals[7]);;
            System.out.println("birthDate is: " + birthdate);
            sex = splitAnimals[3];
            System.out.println("sex is: " + sex);
            species = splitAnimals[4];
            System.out.println("species is: " + species);
            int position = species.indexOf(",");
            System.out.println("position of comma is: " + position);
            species = species.substring(0, position);
            System.out.println("species is now: " + species);
            color = splitStrComma[2];
            System.out.println("color = " + color);
            weight = splitStrComma[3];
            origin = splitStrComma[4] + "," + splitStrComma[5];
            System.out.println("weight = " + weight);
            System.out.println("origin = " + origin);
            if (species.equals("hyena")) {
                numOfHyenas++;
                uniqueID = genUniqueID(species, numOfHyenas);
            } else if (species.equals("lion")) {
                numOfLions++;
                uniqueID = genUniqueID(species, numOfLions);
            } else if (species.equals("tiger")) {
                numOfTigers++;
                uniqueID = genUniqueID(species, numOfTigers);
            } else if (species.equals("bear")) {
                numOfBears++;
                uniqueID = genUniqueID(species, numOfBears);
            } else {
                out.println("Error tabulating number of species");
            }
            out.println("\n");
        }
        System.out.println("numOfHyenas = " + numOfHyenas);
        System.out.println("numOfLions = " + numOfLions);
        System.out.println("numOfTigers = " + numOfTigers);
        System.out.println("numOfBears = " + numOfBears);
        System.out.println("uniqueID = " + uniqueID);
    }
}