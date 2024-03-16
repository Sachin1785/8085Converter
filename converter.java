// Purpose: Convert 8085 assembly instructions to machine code

import java.util.Map;
import java.io.BufferedReader;

public class converter extends text2Hash
{
    // Define ANSI color codes
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m"; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        boolean exit = true;
        Map<String, String> map = readHexCodesFromFile("hexcodes.txt");
        while (exit) {
            // ANSI_YELLOW for prompt
            System.out.println(ANSI_YELLOW + "Enter the instruction. Type \"/Exit\" to exit" + ANSI_RESET);
            String input = br.readLine();
            input = input.toUpperCase();

            String hex = map.get(input);
            if (input.equals("/EXIT")) {
                exit = false;
            } else if (hex == null) {
                //ANSI_RED for error messages
                System.out.println(ANSI_RED + "Invalid Input" + ANSI_RESET);
            } else {
                //ANSI_GREEN for successful conversions
                System.out.println(ANSI_GREEN + hex + ANSI_RESET);
            }
        }
    }

}
