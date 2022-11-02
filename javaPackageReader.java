import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class javaPackageReader {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(".*(java\\.util\\.regex).*");

        Matcher matcher = pattern.matcher(scanner.nextLine());

        if (matcher.matches()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

}
