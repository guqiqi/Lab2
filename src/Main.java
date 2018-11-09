import entity.Token;

import java.io.IOException;
import java.util.ArrayList;

import static lexicalAnalyzer.Analyzer.analyze;
import static lexicalAnalyzer.OutputFile.fileOutput;
import static lexicalAnalyzer.ReadFile.readFile;


public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "test.txt";
        ArrayList<Character> chars = readFile(filename);
        ArrayList<Token> tokens = analyze(chars);
        fileOutput(tokens, filename);
    }
}
