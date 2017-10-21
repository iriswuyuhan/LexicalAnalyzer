package lexicaldata;

import java.util.ArrayList;
import java.util.List;

public class TokenList {
    private List<Token> tokens;

    public TokenList(){
        tokens=new ArrayList<>();
    }

    public void add(Token token){
        tokens.add(token);
    }

    public void printAll(){
        for (Token token:tokens) {
            token.print();
            System.out.println();
        }
    }
}
