public abstract class IntRange {
    protected int value;
    protected int defaultValue;
    protected int minimumValue;
    protected int maximumValue;

    protected IntRange(
        int minimumValue, 
        int maximumValue, 
        int defaultValue,
        int initialValue
    ) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.defaultValue = defaultValue;
        setValue(initialValue);
    }

    public void setValue(int newValue) {
        if (newValue < minimumValue || newValue > maximumValue) {
            throw new IllegalArgumentException(
                String.format(
                    "Value must be %d...%d, was %d", 
                    minimumValue,
                    maximumValue,
                    newValue
                )
            );
        }
        this.value = newValue;
    }

    public int getValue() {
        return value;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public int getMinimumValue() {
        return minimumValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }
}
