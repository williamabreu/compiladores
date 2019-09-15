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

    public ParsedToken(int idType, String nameType, Object value) {
        this.idType = idType;
        this.nameType = nameType;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("<%s, %s>", nameType, value);
    }
}
