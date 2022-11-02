import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;

public class lazyMatch {
    
    public static void readInFile(String fileName) {

        Pattern pattern = Pattern.compile(".*?(if\\s*\\((.*)\\)).*");
        try {

            int count = 0;
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()) {
                count++;
                Matcher matcher = pattern.matcher(scanner.nextLine());

                if (matcher.matches()) {
                    System.out.println(count + " " + matcher.group(2));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

}
