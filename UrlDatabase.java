
import java.util.Scanner;

public class UrlDatabase {
	private static final int MAX_URLS = 100; 
    private static String[] urls = new String[MAX_URLS];
    private static String[] shortKeys = new String[MAX_URLS];
    private static int[] counts = new int[MAX_URLS];
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            if (command.startsWith("storeurl ")) {
                String url = command.substring(9);
                storeUrl(url);
            } else if (command.startsWith("get ")) {
                String url = command.substring(4);
                getUrl(url);
            } else if (command.startsWith("count ")) {
                String url = command.substring(6);
                getCount(url);
            } else if (command.equals("list")) {
                listUrls();
            } else if (command.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }

    private static void storeUrl(String url) {
        if (counter < MAX_URLS) {
            String shortKey = generateShortKey();
            urls[counter] = url;
            shortKeys[counter] = shortKey;
            counts[counter] = 0;
            System.out.println("URL stored with short key: " + shortKey);
            counter++;
        } else {
            System.out.println("Storage limit reached. Cannot store more URLs.");
        }
    }

    private static void getUrl(String url) {
        for (int i = 0; i < counter; i++) {
            if (urls[i] != null && urls[i].equals(url)) {
                counts[i]++;
                System.out.println("Short key: " + shortKeys[i]);
                return;
            }
        }
        System.out.println("URL not found.");
    }

    private static void getCount(String url) {
        for (int i = 0; i < counter; i++) {
            if (urls[i] != null && urls[i].equals(url)) {
                System.out.println("Usage count: " + counts[i]);
                return;
            }
        }
        System.out.println("URL not found.");
    }

    private static void listUrls() {
        System.out.println("URLs and Counts:");
        for (int i = 0; i < counter; i++) {
            if (urls[i] != null) {
                System.out.println("Short key: " + shortKeys[i] + ", URL: " + urls[i] + ", Count: " + counts[i]);
            }
        }
    }

    private static String generateShortKey() {
        return "key" + counter;
    }
}
