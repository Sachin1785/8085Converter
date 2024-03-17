import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class fileconverter  extends text2Hash{
        // Define ANSI color codes
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) throws IOException {
        // Path to the input file
        String inputFilePath = "input.txt";
        // Path to the output file
        String outputFilePath = "output.txt";

        // Read hex codes from file
        Map<String, String> map = readHexCodesFromFile("hexcodes.txt");

        // Initialize BufferedReader to read from the input file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            // Initialize FileWriter to write to the output file
            try (FileWriter fw = new FileWriter(outputFilePath)) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.toUpperCase();
                    line=line.trim();
                    String hex = map.get(line);
                    if (line.equals("/EXIT")) {
                        break;
                    } else if (hex == null) {
                        // Write error message to the output file
                        fw.write( "Invalid Input" + "\n");
                    } else {
                        // Write successful conversion to the output file
                        fw.write(hex + "\n");
                    }
                }
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
    System.out.println(ANSI_GREEN + "Conversion successful!" + ANSI_RESET);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input from file");
            e.printStackTrace();
        }
    }
}