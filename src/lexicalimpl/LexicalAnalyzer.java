package lexicalimpl;

import lexicaldata.Token;
import lexicaldata.TokenList;
import lexicaldata.TokenType;
import lexicaldata.TransferTable;
import lexicalservice.Analyzer;

import java.util.List;

public class LexicalAnalyzer implements Analyzer{
    private TokenList tokenList;
    private final String path="./resource/transfertable.txt";
    private TransferTable transferTable;

    LexicalAnalyzer(){
        tokenList=new TokenList();
        transferTable=new TransferTable(path);
    }

    //暂时只能分析赋值语句
    @Override
    public TokenList lexicalAnalyzer(List<String> inputs) {
        int loc=1;
        for(String input:inputs){
            int state=0;
            StringBuilder litrName= new StringBuilder();
            TokenType tokenType=TokenType.NOTYPE;
            for(int i=0;i<input.length();i++){
                char c=input.charAt(i);
                if(isWhiteSpace(c)){
                    continue;
                }
                litrName.append(c);
                int tempState=transferTable.nextState(state,c);
                if(tempState==-2||tempState==-1){
                    if(tempState==-2) {
                        if(state==0) {
                            break;//换行，该行结束
                        }
                        tokenType = TokenType.values()[state];
                        litrName = new StringBuilder(litrName.substring(0, litrName.length() - 1));//多加了一个字符
                    }
                    Token token=new Token(tokenType,loc, litrName.toString());
                    tokenList.add(token);

                    loc++;
                    state=0;
                    litrName = new StringBuilder();
                    tokenType=TokenType.NOTYPE;
                    if(tempState!=-1) {
                        i--;
                    }
                } else {
                    state=tempState;
                }
            }
        }
        return tokenList;
    }

    private boolean isWhiteSpace(char c){
        return (c=='\t'||c==' ');//换行符是语句结束的标志
    }
}
