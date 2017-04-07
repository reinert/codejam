import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new LinkedList<>();
        Scanner out = new Scanner(new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("resources/A.out"))));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("resources/A.in"))));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int input = in.nextInt();
            String expected = out.nextLine();

//            System.out.println(input);
//            System.out.println(expected);

            if (input == 0) {
                append(lines, i, -1, expected);
                continue;
            }

            append(lines, i, calc(input), expected);
        }
        write(Main.class.getResource("./resources/Aa.out"), lines);
    }

    static int calc(int n) {
        int f = 1;
        boolean[] digits = new boolean[10];
        int digitsAppeared = 0;

        while (digitsAppeared < 10) {
            int x = n * f;
//            System.out.println("x: " + x);
            while (x > 0) {
                int d = x % 10;
                if (!digits[d]) {
                    digitsAppeared++;
                    digits[d] = true;
                }
                x = (x - d) / 10;
            }
            f++;
        }

        return n * (f-1);
    }

    static void append(List<String> lines, int counter, int result, String expected) {
        String line = format(counter, result);
//        System.out.println(line);
        assert line.equals(expected);
        lines.add(line);
    }

    static String format(int counter, int result) {
        return "Case #" + counter + ": " + (result == -1 ? "INSOMNIA" : result);
    }

    static void write(URL path, List<String> lines) {
        try {
            Path file = Paths.get(path.toURI());
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("Error while writing file. See stack trace above.");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("Path not found. See stack trace above.");
        }
    }
}