import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by beinf on 4/23/2017.
 */
public class Main
{
    public static void main(String args[]) throws IOException
    {
        Scanner inScan = new Scanner(System.in);
        System.out.println("Input URL");
        String input = inScan.next();
        URL addr = new URL(input);

        String pattern = ".*\\@.*\\....";
        Pattern emailPattern = new Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);


        InputStream inStream = addr.openStream();
        Scanner inContent = new Scanner(inStream);
        while(inContent.hasNext())
        {
            Matcher emailMatch = emailPattern.matcher(inContent.next());
            if(emailMatch.find())
            {
                String patternFound = emailMatch.group();
                System.out.println(patternFound);
            }
        }
    }
}
