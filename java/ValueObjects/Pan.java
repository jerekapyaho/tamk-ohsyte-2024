public class Pan extends IntRange implements Parameter {
    private String identifier;
    private String name;

    public Pan(int initialValue) {
        super(
            -7, 
            7, 
            0, 
            initialValue
        );

        this.name = "Pan";
        this.identifier = "bk84fh";
        setValue(initialValue);
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
            "%s/%s=%d",
            name,
            identifier,
            getValue()
        ); 
    }    
}
