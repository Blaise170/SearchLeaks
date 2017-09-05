/*
Authored by: Blaise Cannon

This basic file was created to easily and quickly search a text file line-by-line in order to find matches.
This works particularly well for large text files that can be so massive that normal text editors cannot open them,
much less search them. I became interested in writing this software when I found that several of my online accounts had
been compromised through both Exploit.In and also in the Anti Public leaks.

Due to the sensitivity of the leaks, the files are not included with this software. They are easily found on the internet
however and you can download and search them for yourself. I am not responsible for any misuse of this software and I
provide absolutely no warranty, express or implied, for its use. By using this program, you agree to indemnify, to the
extent permitted by law, any authors or editors of this software.

Current Version: 1.1

Changes from v1.0
> Searches from user input instead of it being hard-coded into the design.
> Checks for found flag and will return false if the key is not found.
> Searching is now based on partial matches, so one could search @example.com to find all emails that has been compromised
on their domain.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchLeaks {
    private static void readFile(String target) {

        try (BufferedReader br = new BufferedReader(new FileReader("anti.txt"))) {
            System.out.print("\n");
            int x = 0; // just doing this to show that the program is actually running (see below)
            boolean found = false;
            while (br.readLine() != null) {
                String line = br.readLine();
                line = line.toUpperCase(); // instead of trying to match case, just make everything capital
                if (line.contains(target)) {
                    System.out.println("\n\nMATCH FOUND. Please press enter to continue... \n\n" + line);
                    System.in.read();
                    found = true;
                }

                // this portion of the code is useful for showing work time in the console. because calculations are
                // completed so fast, I set the number to mod by a rather large prime number
                x++;
                if (x % 1299721 == 0)
                {
                    System.out.print(".");
                }
            }

            if (!found) {
                System.out.println("\nNo matches found.");
            }
        }


        // typically would not use this, but it covers both IO and FNF errors and I wanted this software completed as
        // quickly as possible. i'll look into updating it in a potential future release
        catch (Exception exception) {
            System.err.print("File not found.");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email. If you need to cancel at any time, press Ctrl+C.");
        String email = sc.next().toUpperCase();

        readFile(email);
    }
}