package lexicalAnalyzer;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    // 处理输入文件,转换成char链表
    public static ArrayList<Character> readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
        String line;
        ArrayList<Character> input = new ArrayList<>();
        char[] tempChars;

        while (null != (line = br.readLine())) {
            tempChars = line.toCharArray();
            for (char c : tempChars) {
                if (c == '\t') {
                    continue;
                }
                input.add(c);
            }
            input.add('\n');
        }

        br.close();

        return input;
    }
}
