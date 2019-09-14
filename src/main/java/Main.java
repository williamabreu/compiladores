import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String...args) throws IOException {
        String filePath = "src/teste.alguma";
        ANTLRFileStream input = new ANTLRFileStream(filePath);
        Scanner scanner = new Scanner(input);
        scanner.removeErrorListeners();
        scanner.addErrorListener(ThrowingErrorListener.INSTANCE);
//        List<? extends Token> tokens = scanner.getAllTokens();

        while (!scanner._hitEOF) {
            try {
                Token token = scanner.nextToken();
                System.out.printf("{%s}\n", token.getText());
            }
            catch (ParseCancellationException e) {
                System.out.println(e.toString());
                System.exit(0);
            }
        }

//        for (Token token : tokens) {
//            System.out.printf("{%s}\n", token.getText());
//        }
    }
}
