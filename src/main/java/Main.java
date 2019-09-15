import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static int id = 0xff00;

    public static void main(String...args) throws IOException {
        // Arquivo de entrada
        String filePath = "src/teste.alguma";
        ANTLRFileStream input = new ANTLRFileStream(filePath);

        // Parser, Scanner
        Scanner scanner = new Scanner(input);
        scanner.removeErrorListeners();
        scanner.addErrorListener(ThrowingErrorListener.INSTANCE);

        // Lista de Tokens
        List<ParsedToken> tokens = new LinkedList<>();

        // Tabela de símbolos
        Hashtable<String, Integer> symbolTable = new Hashtable<>();

        while (!scanner._hitEOF) {
            try {
                Token token = scanner.nextToken();
                switch (token.getType()) {
                    case Scanner.DEC:
                        tokens.add(new ParsedToken(token.getType(), "DEC", token.getText()));
                        break;
                    case Scanner.ALG:
                        tokens.add(new ParsedToken(token.getType(), "ALG", token.getText()));
                        break;
                    case Scanner.INT:
                        tokens.add(new ParsedToken(token.getType(), "INT", token.getText()));
                        break;
                    case Scanner.REA:
                        tokens.add(new ParsedToken(token.getType(), "REA", token.getText()));
                        break;
                    case Scanner.ATR:
                        tokens.add(new ParsedToken(token.getType(), "ATR", token.getText()));
                        break;
                    case Scanner.LER:
                        tokens.add(new ParsedToken(token.getType(), "LER", token.getText()));
                        break;
                    case Scanner.IMP:
                        tokens.add(new ParsedToken(token.getType(), "IMP", token.getText()));
                        break;
                    case Scanner.SE:
                        tokens.add(new ParsedToken(token.getType(), "SE", token.getText()));
                        break;
                    case Scanner.ENT:
                        tokens.add(new ParsedToken(token.getType(), "ENT", token.getText()));
                        break;
                    case Scanner.ENQ:
                        tokens.add(new ParsedToken(token.getType(), "ENQ", token.getText()));
                        break;
                    case Scanner.INI:
                        tokens.add(new ParsedToken(token.getType(), "INI", token.getText()));
                        break;
                    case Scanner.FIM:
                        tokens.add(new ParsedToken(token.getType(), "FIM", token.getText()));
                        break;
                    case Scanner.A:
                        tokens.add(new ParsedToken(token.getType(), "A", token.getText()));
                        break;
                    case Scanner.OpArit:
                        tokens.add(new ParsedToken(token.getType(), "OpArit", token.getText()));
                        break;
                    case Scanner.OpRel:
                        tokens.add(new ParsedToken(token.getType(), "OpRel", token.getText()));
                        break;
                    case Scanner.Delim:
                        tokens.add(new ParsedToken(token.getType(), "Delim", token.getText()));
                        break;
                    case Scanner.AP:
                        tokens.add(new ParsedToken(token.getType(), "AP", token.getText()));
                        break;
                    case Scanner.FP:
                        tokens.add(new ParsedToken(token.getType(), "FP", token.getText()));
                        break;
                    case Scanner.Var:
                        String identifier = token.getText();
                        if (symbolTable.get(identifier) == null) {
                            symbolTable.put(token.getText(), id++);
                        }
                        tokens.add(new ParsedToken(token.getType(), "Var", symbolTable.get(identifier)));
                        break;
                    case Scanner.NumI:
                        tokens.add(new ParsedToken(token.getType(), "NumI", token.getText()));
                        break;
                    case Scanner.NumR:
                        tokens.add(new ParsedToken(token.getType(), "NumR", token.getText()));
                        break;
                    case Scanner.Str:
                        tokens.add(new ParsedToken(token.getType(), "Str", token.getText()));
                        break;
                    case Scanner.NEWLINE:
                        tokens.add(new ParsedToken(token.getType(), "NEWLINE", token.getText()));
                        break;
                    case Scanner.WS:
                        tokens.add(new ParsedToken(token.getType(), "WS", token.getText()));
                        break;
                    case Scanner.COMMENT:
                        tokens.add(new ParsedToken(token.getType(), "COMMENT", token.getText()));
                        break;
                }
            }
            catch (ParseCancellationException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        for (ParsedToken token : tokens) {
            System.out.println(token);
        }

        System.out.println(symbolTable);
    }
}
