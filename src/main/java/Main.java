import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String...args) throws IOException {


        String filePath = "/Users/aluno/IdeaProjects/compiladores/src/teste.alguma";
        ANTLRFileStream input = new ANTLRFileStream(filePath);
        Scanner scanner = new Scanner(input);
        List<? extends Token> tokens = scanner.getAllTokens();

        for (Token token : tokens) {
            System.out.printf("{%s}\n", token.getText());
        }
    }
}
