import entity.Token;
import syntaxAnalyzer.Analyzer;
import syntaxAnalyzer.OutputFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lexicalAnalyzer.Analyzer.analyze;
import static lexicalAnalyzer.ReadFile.readFile;


public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "test.txt";
        ArrayList<Character> chars = readFile(filename);
        ArrayList<Token> tokens = analyze(chars);
//        OutputFile.fileOutput(tokens, "test2.txt");
        List<String> result = new Analyzer().syntaxAnalyzer(tokens);
        new OutputFile().output(result, "test.txt");
    }
}
