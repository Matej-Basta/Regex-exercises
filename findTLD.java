import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class findTLD {

    private int com;
    private int ms;
    private int org;

    public findTLD() {
        com = 0;
        ms = 0;
        org = 0;
    }
    
    public void readInInternet(String locationOfInternet) {

        File fileOfPages = new File(locationOfInternet);
        
        try {
            Scanner scanner = new Scanner(fileOfPages);

            Pattern pattern = Pattern.compile("^(\\*PAGE:https?:).*");
            Pattern patternForSplitting = Pattern.compile("\\.");
            Pattern patternForGettingDomain = Pattern.compile("((.*)\\/?).*");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                String[] words = patternForSplitting.split(line);
                String first = words[words.length - 1];
                String domain = "";
                if (first.contains("/")) {
                    String[] array = first.split("/", 2);
                    domain = array[0];
                } else {
                    domain = first;
                }


                    
                switch (domain) {
                    case "com":
                        com++;
                        break;
                    case "ms":
                        ms++;
                        break;
                    case "org":
                        org++;
                        break;
                }
            }
        }
        
        
        scanner.close();

        System.out.println(".com: " + com);
        System.out.println(".ms: " + ms);
        System.out.println(".org: " + org);

        } catch (Exception e) {
            System.out.println("File not found.");
        }

    }


}