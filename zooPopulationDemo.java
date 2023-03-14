/* JavaMidtermSpr23.java
 * dH 3/9/23
 *
 * open arrivingAnimals
 * read into a 1-D array
 * process line by line to specified output
 *
 * Sample Input from arrivingAnimals.txt:
 *   4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia
 *
 * Sample Output line:
 *   Hy01; Kamari; 4 years old; birth date Mar 21, 2018; tan color; female; 70 pounds; from Friguia Park, Tunisia;
 *   arrived March 10, 2023
 *
 * References:
 *   https://www.w3schools.com/java/java_user_input.asp
 *   https://www.w3schools.com/java/java_files.asp
 *   https://www.w3schools.com/java/java_arrays.asp
 *   https://www.w3schools.com/java/java_ref_string.asp
 *   https://www.geeksforgeeks.org/different-ways-for-integer-to-string-conversions-in-java/
 *   https://www.w3schools.com/java/java_date.asp
 *   https://www.quickprogrammingtips.com/java/how-to-calculate-age-from-date-of-birth-in-java.html
 *   https://scccd.instructure.com/courses/91040/files/19296433?module_item_id=5741763
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;


public class zooPopulationDemo {
    static String calcBirthdate(int yearsOld, String birthSeason) {

        int year = 2023 - yearsOld;
        String monthDay;
        String newDate;

        switch (birthSeason) {
            case "spring,":
                monthDay = "03-21";
                break;
            case "summer,":
                monthDay = "06-21";
                break;
            case "fall,":
                monthDay = "09-21";
                break;
            case "winter,":
                monthDay = "12-21";
                break;
            default:
                monthDay = "01-01";
                break;
        }
        newDate =  Integer.toString(year) + "-" + monthDay;

        return newDate;
    }

    static String genUniqueID(String speciesName, int numOfSpecies) {
        String uniqueID;

        switch (speciesName) {
            case "hyena":
                uniqueID = "Hy0" + Integer.toString(numOfSpecies);
                break;
            case "lion":
                uniqueID = "Li0" +  Integer.toString(numOfSpecies);
                break;
            case "tiger":
                uniqueID = "Ti0" +  Integer.toString(numOfSpecies);
                break;
            case "bear":
                uniqueID = "Be0" +  Integer.toString(numOfSpecies);
                break;
            default:
                uniqueID = "error";
                break;
        }
        return uniqueID;
    }


    public static void main(String[] args) {
        System.out.println("\n\nWelcome to Dennis's Zoo program!\n\n");

        // Global variables used for species populations
        int numOfHyenas = 0;
        int numOfLions = 0;
        int numOfTigers = 0;
        int numOfBears = 0;

        // Read the file, line by line, output each line to demonstrate a properly working program
        // Open arrivingAnimals.txt - this is input for your program
        // Create an array for the input file
        int lineNum = 0;
        String arrivingAnimals[];
        arrivingAnimals = new String[16];

        try {
            File myAnimalsFile = new File("C:/2023spring/midtermProgram/arrivingAnimals.txt");
            Scanner scanner = new Scanner(myAnimalsFile);
            System.out.println("\n The arrivingAnimals.txt file...\n");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                arrivingAnimals[lineNum] = line;
                lineNum++;
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n A file error occured...");
            e.printStackTrace();
        }

        // Output the array.
        System.out.println("\n The array...\n");
        for (String line:arrivingAnimals) {
            System.out.println(line);
        }
        // Input: 4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia
        // Output:  Hy01; Kamari; 4 years old; birth date Mar 21, 2018; tan color; female; 70 pounds;
        //   from Friguia Park, Tunisia; arrived March 10, 2022
        /*
         *  Hy01;
         *  Kamari;
         *  4 years old;
         *  birth date Mar 21, 2018;
         *  tan color;
         *  female;
         *  70 pounds;
         *  from Friguia Park, Tunisia;
         *  arrived March 9, 2023
         */

        // Variables needed for string processing.
        int position = 0;

        // Variables needed to process the array.

        int years = 0;

        String season;
        String sex;
        String species;
        String birthdate;
        String color;
        String origin;
        String weight;
        String name;
        String uniqueID = "xyz";
        String arrived;

        // Split the string into words
        // When testing, note that the index of arrivingAnimals[99] is the element index of the array. 0-3: hyena,
        //   4-7: lion, 8-11: tiger, 12-15: bear
        String splitStr[] = arrivingAnimals[4].split(" ",0);

        // Output the split
        for (String s:splitStr) {
            System.out.println(s);
        }

        // Calculate a birthday using years old and birth season
        birthdate = calcBirthdate(Integer.parseInt(splitStr[0]), splitStr[7]);
        System.out.println("birthDate is: " + birthdate);

        // Find incoming animal sex.
        sex = splitStr[3];
        System.out.println("sex is: " + sex);

        // Find incoming animal species.
        species = splitStr[4];
        System.out.println("species is: " + species);
        // Delete the trailing comma.
        position = species.indexOf(",");
        System.out.println("position of comma is: " + position);
        // substring() arguments: beginning index, ending index-1
        species = species.substring(0, position);
        System.out.println("species is now: " + species);

        // Now that we know the species, we update the global variable corresponding to the species
        // (we will solve this global variable issue when we code this program up with classes and lists after midterm)
        if (species.equals("hyena")) {
            numOfHyenas++;
            uniqueID = genUniqueID(species, numOfHyenas);
        }
        else if (species.equals("lion")) {
            numOfLions++;
            uniqueID = genUniqueID(species, numOfLions);
        }
        else if (species.equals("tiger")) {
            numOfTigers++;
            uniqueID = genUniqueID(species, numOfTigers);
        }
        else if (species.equals("bear")) {
            numOfBears++;
            uniqueID = genUniqueID(species, numOfBears);
        }
        else {
            System.out.println("Error tabulating number of species");
        }

        System.out.println("numOfHyenas = " + numOfHyenas);
        System.out.println("numOfLions = " + numOfLions);
        System.out.println("numOfTigers = " + numOfTigers);
        System.out.println("numOfBears = " + numOfBears);

        System.out.println("uniqueID = " + uniqueID);

        // Find color
        // We can't use the index from splitStr() because the color of each arriving animal could have different
        //   number of words.
        // so... we split() on the commas, and find the color that way!
        // make sure to use the same index (8 for our tiger with a long color)
        String splitStrComma[] = arrivingAnimals[4].split(",",0);

        // Output the split
        for (String s:splitStrComma) {
            System.out.println(s);
        }

        // After examining the output of this split on comma, we see that color is element 2
        color = splitStrComma[2];
        System.out.println("color = " + color);

        // get weight and origin this way and then we are almost done!
        weight = splitStrComma[3];

        origin = splitStrComma[4] + "," +  splitStrComma[5];

        System.out.println("weight = " + weight);
        System.out.println("origin = " + origin);

        // You must name your new animal friend.
        // Quickest way to do this is to create four 1-D string arrays with names.
        String hyenaNames[] = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou", "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
        String lionNames[] = {"Scar", "Mufasa", "Simba", "Kiara", "King", "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
        String bearNames[] = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle", "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};
        String tigerNames[] = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles", "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};

        // Use uniqueID to get a name!
        String uniqueIDPrefix = uniqueID.substring(0,2);
        System.out.println("uniqueIDPrefix = " + uniqueIDPrefix);
        String uniqueIDSuffix = uniqueID.substring(2);
        System.out.println("uniqueIDSuffix = " + uniqueIDSuffix);
        int suffixAsInt = Integer.parseInt(uniqueIDSuffix);
        System.out.println("suffixAsInt = " + suffixAsInt);
        // Now that we have information from the unique ID as a species indicator and an ordinal, we can get a name
        //   that has not been used.
        // Use a switch statement because java is string-switch friendly!

        switch (uniqueIDPrefix) {
            case "Hy":
                name = hyenaNames[suffixAsInt];
                break;
            case "Li":
                name = lionNames[suffixAsInt];
                break;
            case "Ti":
                name = tigerNames[suffixAsInt];
                break;
            case "Be":
                name = bearNames[suffixAsInt];
                break;
            default:
                name = "error in name switch statement";
                break;
        }

        System.out.println("name is: "+ name);

        // Almost done....
        // use system date for arrival and to calculate animal's age in years
        String arrivalDate;
        LocalDate curDate = LocalDate.now();
        arrivalDate = curDate.toString();
        System.out.println("arrivalDate: " + arrivalDate);
        LocalDate bDate = LocalDate.parse(birthdate);

        // Age is easy with the LocalDate class, but birthdate and arrivalDate must be in same format (YEAR-MM-DD)
        int animalAge =  Period.between(bDate, curDate).getYears();
        System.out.println(" Age is: " + animalAge) ;

        // Now... I think we have everything. Check sample output to get everything in the right order.
        String outputLine;
        outputLine =  uniqueID + "; " +
                name + "; " +
                animalAge + " years old" + "; " +
                "birth date " + birthdate + "; " +
                color + "; " +
                sex + "; " +
                weight + "; " +
                origin + "; " +
                "arrived " + arrivalDate;

        System.out.println("\n\n" + outputLine + "\n\n");


    }
}