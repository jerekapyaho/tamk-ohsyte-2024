public class Volume extends IntRange implements Parameter {
    private String identifier;
    private String name;

    public Volume(int initialValue) {
        super(
            0, 
            99, 
            50, 
            initialValue
        );

        this.name = "Volume";
        this.identifier = "xk3zy4";
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
