package lexicalservice;

import lexicaldata.Token;
import lexicaldata.TokenList;

import java.util.List;

public interface Analyzer {
    TokenList lexicalAnalyzer(List<String> inputs);
}
