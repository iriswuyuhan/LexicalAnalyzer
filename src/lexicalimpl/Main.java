package lexicalimpl;

import lexicaldata.Token;
import lexicaldata.TokenList;
import lexicalservice.InputProcess;

public class Main {
    public static void main(String[] args) {
        InputProcess input=new ConsoleInput();
        LexicalAnalyzer lexAnalyze=new LexicalAnalyzer();
        TokenList tokenList=lexAnalyze.lexicalAnalyzer(input.readInput());
        if(tokenList!=null) {
            tokenList.printAll();
        }else {
            System.out.println("ERROR!");
        }
    }
}
