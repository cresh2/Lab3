
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String url, wordToFind, urlText, remainingText;
        int urlTextLength, currentIndex, totalWordCount = 0;
        Scanner getInput;
        getInput = new Scanner(System.in);

        // Gets the url and word from the user
        System.out.println("Enter an url you want to search: ");
        url = getInput.nextLine();
        System.out.println("Enter a word you want to search for: ");
        wordToFind = getInput.nextLine();
        getInput.close();
        // Converts url to string and finds the length
        urlText = urlToString(url);
        urlText.trim();
        urlTextLength = urlText.length();
        currentIndex = 0;
        while (currentIndex != -1) {
            currentIndex = urlText.indexOf(" ", currentIndex+1);
            totalWordCount++;
        }

        System.out.println(currentIndex);
        System.out.print(totalWordCount);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
