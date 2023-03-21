import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;
public class zooPopulation {
    static String calcBirth(int yearOld, String birthSeason) {
        int year = 2023 - yearOld;
        String monthDay = switch (birthSeason) {
            case "spring," -> "03-19";
            case "summer," -> "5-21";
            case "fall," -> "08-19";
            case "winter," -> "12-19";
            default -> "01-01";
        };
        String newDate = year + "-" + monthDay;
        return newDate;
    }
     /*static String Arriving (int day, int curMonth, String birthSeason) {
        day = 20;
        curMonth = 03;
         LocalDate arrival = LocalDate.now();
         LocalDate arrived = switch (birthSeason) {
            case "spring," -> 2023-01-10;
            case "summer," -> "5-21";
            case "fall," -> "08-19";
            case "winter," -> "12-19";
            default -> arrival;
        };
        String newDate = year + "-" + monthDay;
        return newDate;
    }
*/
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

                I will be using the info below:

                """);
        String animalsNames = "animalNames.txt";
        String namesRdr;
        String arrivingAnimals = "arrivingAnimals.txt";
        String arriving;
        try {
            BufferedReader br = new BufferedReader(new FileReader(animalsNames));
            while ((namesRdr = br.readLine()) != null) {
                String[][] values;
                values = new String[][]{namesRdr.split(":" + ",")};
                out.println(values[0][0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        out.println("\n");
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
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
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
//    Buffered Writer
      try {
          FileWriter file = new FileWriter("zooPopulation.txt");
          BufferedWriter output = new BufferedWriter(file);
          output.write("Quarterly Arrival Schedule:" + "\n\n" + "New Animals to the Following Habitats." + "\n\n");
          int yearsOld = 0;
          int numOfHyenas = 0;
          int numOfLions = 0;
          int numOfTigers = 0;
          int numOfBears = 0;
          int j;
          int indexKey;
          int endKey;
          String birthdate;
          String season;
          String sex;
          String species;
          String color;
          String origin;
          String weight;
          String uniqueID = "xyz";
          LocalDate arrival = LocalDate.now();
          LocalDate inTaking = arrival.minusDays(7);
          LocalDate preQuart = arrival.minusMonths(4).minusDays(12);
          String tBA = "To-Be-Announced";
          out.println("FYI the following String took 1 week out of my life...#justsayin'" + "\n");
          String hab;
          String newChar;
          String splitTxt;
          String noBlankLns;
          String hyenaHabitat = "";
          String lionHabitat = "";
          String tigerHabitat = "";
          String bearHabitat = "";
          String[][] names = new String[4][4];
          //*  here's my index for names   *//
          for (j = 0; j < 4; j++) {
              hab = id[j].replace("Names", "Habitat");
              newChar = hab.replace(",", "");
              splitTxt = Arrays.toString(newChar.split(" ", 14));
              //noBlankLns = splitTxt.replace("[]", "");
              //out.print(splitTxt);
              indexKey = splitTxt.indexOf("[");
              endKey = splitTxt.indexOf("]");
              out.print("\n");
            /*int commaIndexFinder = noBlankLns.indexOf(",");
            out.print(commaIndexFinder);
            out.print("\n");
            out.print("\n" + "These are for Habitat arrays by indexing them from my scanner " + "\n" + indexKey + "\n" + endKey+ "\n");
            */
              if (indexKey == -1) {
                  out.print("");
              } else if (splitTxt.startsWith("[Hyena")) {

                  hyenaHabitat = splitTxt.substring(18, 41);
                  //hyenaHabitat.replace(",", "");
                  hyenaHabitat.split(",", 4);
                  out.print(hyenaHabitat + "\n" + "These names are for Hyena Habitat array. I have indexed them from my" +
                          " " + "scanner." + "\n"/*
                +indexKey + "\n" + endKey*/);
                  endKey++;
              } else if (splitTxt.startsWith("[Lion")) {

                  lionHabitat = splitTxt.substring(17, 43);
                  //lionHabitat.replace(",", "");
                  lionHabitat.split(",", 4);
                  out.print(lionHabitat + "\n" + "These names are for Lion Habitat array. I have indexed them from my " +
                          "scanner." + "\n"/*
                +indexKey + "\n" + endKey*/);
              } else if (splitTxt.startsWith("[Tiger")) {
                  tigerHabitat = splitTxt.substring(18, 46);
                  //tigerHabitat.replace(",", "");
                  tigerHabitat.split(",", 4);
                  out.print(tigerHabitat + "\n" + "These names are for Tiger Habitat array. I have indexed them from my" +
                          " " +
                          "scanner." + "\n"/*
                +indexKey + "\n" + endKey*/);
              } else if (splitTxt.startsWith("[Bear")) {
                  bearHabitat = splitTxt.substring(17, 48);
                  //bearHabitat.replace(",", "");
                  bearHabitat.split(",", 4);
                  out.print(bearHabitat + "\n" + "These names are for Bear Habitat array. I have indexed them from my" +
                          " scanner." + "\n"/*
                +indexKey + "\n" + endKey*/);
              } else {
                  //out.print("\n");
                  //return;
              }
              //out.print(hyenaHabitat + lionHabitat + tigerHabitat +bearHabitat);
          }
// end of Habitat Splitter //
          out.print("\n");

          for (int i = 0; i < 16; i++) {
              String[] splitAnimals = animals[i].split(" ", 0);
              String[] splitStrComma = animals[i].split(",", 0);
/*
              for (String a: splitAnimals) {
              out.println( a + "\n\n");}
              for (String s: splitStrComma) {
              System.out.println(s);
              }
*/
              yearsOld = Integer.parseInt(splitAnimals[0]);
              //String arrived = splitStrComma[4];
              season = splitAnimals[7];
              species = splitStrComma[0].split(" ")[4];
              //out.print (splitAnimals[7]);
              out.println("species is: " + species);
              //System.out.println("position of comma is: " + position);
              birthdate = calcBirth(yearsOld, season);
              out.println("birthDate is: " + birthdate);
              out.println(yearsOld + " years old");
              sex = splitAnimals[3];
              out.println("sex is: " + sex);
              color = splitStrComma[2];
              out.println("color ; " + color);
              weight = splitStrComma[3];
              origin = splitStrComma[4] + "," + splitStrComma[5];
              out.println("weight ; " + weight);
              out.println("origin ; " + origin);
              switch (species) {
                  case "hyena" -> {
                      out.print("Arriving "+ arrival +"\n");
                      output.write("Arriving " + String.valueOf(arrival) + "\n");
                      numOfHyenas++;
                      uniqueID = genUniqueID(species, numOfHyenas);
                      out.println(uniqueID + ": " + hyenaHabitat.split(", ")[numOfHyenas - 1]);
                      output.write(uniqueID + ": " + hyenaHabitat.split(", ")[numOfHyenas - 1]);
                  }
                  case "lion" -> {
                      out.print("Intaking "+ inTaking +"\n");
                      output.write("Intaking " + String.valueOf(inTaking) + "\n");
                      numOfLions++;
                      uniqueID = genUniqueID(species, numOfLions);
                      out.println(uniqueID + ": " + lionHabitat.split(", ")[numOfLions - 1]);
                      output.write(uniqueID + ": " + lionHabitat.split(", ")[numOfLions - 1]);
                  }
                  case "tiger" -> {
                      out.print("Previous quarter "+ preQuart +"\n");
                      output.write("Previous quarter " + preQuart + "\n");
                      numOfTigers++;
                      uniqueID = genUniqueID(species, numOfTigers);
                      out.println(uniqueID + ": " + tigerHabitat.split(", ")[numOfTigers - 1]);
                      output.write(uniqueID + ": " + tigerHabitat.split(", ")[numOfTigers - 1]);
                  }
                  case "bear" -> {
                      out.print(tBA +"\n");
                      output.write(tBA + preQuart + "\n");
                      numOfBears++;
                      uniqueID = genUniqueID(species, numOfBears);
                      out.println(uniqueID + ": " + bearHabitat.split(", ")[numOfBears - 1]);
                      output.write(uniqueID + ": " + bearHabitat.split(", ")[numOfBears - 1]);
                  }
                  default -> out.println("Error tabulating number of species");
              }


              /*
              names = new String[4][4]; -> (hyenaHabitat, lionHabitat, tigerHabitat, bearHabitat);
              out.print(names[16]);
              for (int f = 0; f < 4; f++) {
                  for (int n = 0; n < 4; n++) {
                      names[f][n] = habitatNames[f].split("")[n];
                      out.print(names [i][j]);
                  }
              }
                */
              out.println("\n");

              output.write(", " + yearsOld + " yearsOld" +"\n");
          }
          out.println("numOfHyenas = " + numOfHyenas);
          out.println("numOfLions = " + numOfLions);
          out.println("numOfTigers = " + numOfTigers);
          out.println("numOfBears = " + numOfBears);

          output.close();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      // buffered Writer
        // main
    }
//zooPopulation
}
        /*
        *the following is literally just crap that wasted my time. Take a gander*

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

            String[] habArray = new String []{StringToarray.noBlanknLs};
            String splitTxt0 = Arrays.toString(hab[0].split("\n\n", 0));
            String noBlankLns = splitTxt0 + 0splitTxt2 + splitTxt4 + splitTxt6;
            String noBlankLns = splitTxt.replaceAll("\n\n" + "\r\n" + "\n" + "\r", "hello");
            out.println(lineBreak);
            String[] nullHabTxt = new String[]{noBlankLns[0].substring(2)};
            out.println(splitTxt);
            out.println(noBlank);
            for (String s: splitTxt) out.println(s);
            for (String h: hab) out.println(h);
            for (String n: newChar) out.println(n);
            for (String nB : noBlankLns) out.println(nB);
            for (String nH : nullHabTxt) out.println(nH);
            //*this is another iteration of crap*
        for (int i = 0; i < 7; i++) {
            String[] hab = new String[]{id[i].replace("Names", "Habitat")};
            String[] noBlankLns = new String[] {hab[0].replace(" /n", " ")};
            String[] splitTxt = new String[]{Arrays.toString(noBlankLns[0].split(" ",0))};
            String[] newChar = new String[]{nullHabTxt[0].replace(",", " ")};
            String[] nullHabTxt = new String[]{newChar[0].substring(2)};
            out.println(hab);
            out.println(splitTxt);
            out.println(nullHabTxt);
            out.println(n);
            //for (String h: hab) out.println(h);
            //for (String nB : noBlankLns) out.println(nB);
            //for (String s: splitTxt) out.println(s);
            //for (String n: newChar) out.println(n);
            //for (String nH : nullHabTxt) out.println(nH);
        }
         */
/*
                    *More Junk*

for (int i = 0; i < 4; i++) {
                     String hyenaHab = new String(noBlankLns[indexKey]);

            if (noBlankLns[0].length)
            }*/
//int LionIndex = ;
//String arrayHabNames = Arrays.toString(noBlankLns.split(" ", 14));
//int namePos = arrayHabNames.indexOf(" ");
//String fourNames = Arrays.toString(arrayHabNames[j].substring(0,4);
//out.print(hab);
//out.print(newChar);
//out.print(splitTxt);

//out.println(arrayHabNames);
//out.println(fourNames);
// return noBlankLns;