public class ParsedToken {
    private int idType;
    private String nameType;
    private Object value;

    public int getIdType() {
        return idType;
    }

    public String getNameType() {
        return nameType;
    }

    public Object getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getLexeme() {
        return lexeme;
    }

    private int line;
    private int column;
    private String lexeme;

    public ParsedToken(int idType, String nameType, Object value, int line, int column, String lexeme) {
        this.idType = idType;
        this.nameType = nameType;
        this.value = value;
        this.line = line;
        this.column = column + 1;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return String.format("<%s, %s>  %d:%d", nameType, value, line, column);
    }
}
