import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

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
        /*
          int idLine = 0;
        int listName = 0;
        String[][] id = new String[][]{new String[7]};
        try {
            File animalId = new File(animalsNames);
            Scanner scanner = new Scanner(animalId);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                id[idLine][listName] = Arrays.toString(new String[]{line});
                idLine++;
                listName++;
                //out.println(line);
            }
                    int idLine = 0;
        int listName = 0;
        String[][] id = new String[][]{new String[7]};
        try {
            File animalId = new File(animalsNames);
            Scanner scanner = new Scanner(animalId);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                id[idLine][listName] = new String[][]{line};
                idLine++;
                listName++;
                //out.println(line);
            }
            scanner.close();
        */
        try {
            BufferedReader br = new BufferedReader(new FileReader(arrivingAnimals));
            while ((arriving = br.readLine()) != null) {
                String[][] values;
                values = new String[][]{arriving.split(":" + ",")};
                out.println(values[0][0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        out.println("\n");

        int idLine = 0;
        String[] id = new String[7];
        try {
            File animalId = new File(animalsNames);
            Scanner scanner = new Scanner(animalId);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                id[idLine] = line;
                idLine++;
                //out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            out.println("\n A file error occured...");
            e.printStackTrace();
        }
        int lineNum = 0;
        String[] animals = new String[16];
        try {
            File myAnimals = new File(arrivingAnimals);
            Scanner scanner = new Scanner(myAnimals);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                animals[lineNum] = line;
                lineNum++;
                //out.println(line);
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
        for (int i = 0; i < 16; i++) {
            String[] splitAnimals = animals[i].split(" ", 0);
            String[] splitStrComma = animals[i].split(",", 0);
/*            for (String a: splitAnimals) {
                System.out.println(a);
            }
            out.println("\n\n");
            for (String s: splitStrComma) {
            System.out.println(s);
            }
*/
            String yearsOld = splitAnimals[0];
            species = splitAnimals[4];
            int position = species.indexOf(",");
            species = species.substring(0, position);
            out.println("species is: " + species);
            //System.out.println("position of comma is: " + position);
            String birthdate = calcBirth(Integer.parseInt(splitAnimals[0]), splitAnimals[7]);
            out.println("birthDate is: " + birthdate);
            out.println("age is: " + yearsOld);
            sex = splitAnimals[3];
            out.println("sex is: " + sex);
            color = splitStrComma[2];
            out.println("color ; " + color);
            weight = splitStrComma[3];
            origin = splitStrComma[4] + "," + splitStrComma[5];
            out.println("weight ; " + weight);
            out.println("origin ; " + origin);
            if (species.equals("hyena")) {
                numOfHyenas++;
                uniqueID = genUniqueID(species, numOfHyenas);
                out.println("uniqueID = " + uniqueID);
            } else if (species.equals("lion")) {
                numOfLions++;
                uniqueID = genUniqueID(species, numOfLions);
                out.println("uniqueID = " + uniqueID);
            } else if (species.equals("tiger")) {
                numOfTigers++;
                uniqueID = genUniqueID(species, numOfTigers);
                out.println("uniqueID = " + uniqueID);
            } else if (species.equals("bear")) {
                numOfBears++;
                uniqueID = genUniqueID(species, numOfBears);
                out.println("uniqueID = " + uniqueID);
            } else {
                out.println("Error tabulating number of species");
            }
            out.println("\n");
            //return;
        }
        for (int i = 0; i < 7; i++) {
            String[] hab = new String[]{id[i].replace("Names", "Habitat")};
            String[] noBlankLns = new String[] {hab[0].replace(" /n", " ")};
            String[] splitTxt = new String[]{Arrays.toString(noBlankLns[0].split(" ",0))};
            String[] nullHabTxt = new String[]{splitTxt[0].substring(2)};
            String[] newChar = new String[]{nullHabTxt[0].replace(",", " ")};
            for (String h: hab) out.println(h);
            for (String nH : nullHabTxt) out.println(nH);
            for (String s : splitTxt) out.println(s);
            for (String n: newChar) out.println(n);
        }
            out.println("\n");
            out.println("numOfHyenas = " + numOfHyenas);
            out.println("numOfLions = " + numOfLions);
            out.println("numOfTigers = " + numOfTigers);
            out.println("numOfBears = " + numOfBears);
        }
    }