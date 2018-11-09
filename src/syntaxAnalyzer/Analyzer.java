package syntaxAnalyzer;

import constant.PPT;
import entity.Production;
import entity.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Analyzer {
    public List<String> syntaxAnalyzer(List<Token> tokens){
        // 给输入串加一个终结符号
        tokens.add(new Token(22, "$", "保留字"));

        // 返回结果
        List<String> result = new ArrayList<>();

        // 栈
        Stack<String> stack = new Stack<>();
        // 左边开始符
        stack.push("$");
        // 第一个开始状态
        stack.push("S");

        PPT ppt = new PPT();

        while (tokens.size() > 0 && stack.size() > 0){
            Token currentToken = tokens.get(0);
            String currentTokenString = (currentToken.getCode() == 83) ? "id" :
                    ((currentToken.getCode() == 81 || currentToken.getCode() == 82) ? "num" : currentToken.getString());
            String v = stack.pop();

            // 匹配, 弹出
            if (currentTokenString.equals(v)) {
                tokens.remove(0);
            }
            // 不匹配, v为终结符
            else {
                Production production = ppt.findProduction(currentTokenString, v);
                if (production == null) {
                    result.add("ERROR: invalid input \"" + currentTokenString + "\"");
                    break;
                } else {
                    result.add(production.toString());
                    String[] right = production.getRight();
                    if (right != null) {
                        // 倒序插入
                        for (int i = right.length - 1; i >= 0; i--) {
                            stack.push(right[i]);
                        }
                    }
                }
            }
        }

        if (tokens.size() == 0 && stack.size() == 0) {
            System.out.println("SUCCESS: finish syntax parsing");
        } else {
            System.out.println("ERROR: invalid input");
        }

        return result;
    }
}
