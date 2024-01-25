import java.util.List;
import java.util.ArrayList;

public class TestVolume {
    public static void main(String[] args) {
        Volume volume = new Volume(25);
        System.out.println(volume);

        Pan pan = new Pan(-3);
        System.out.println(pan);

        //pan.setValue(1000);

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(volume);
        parameters.add(pan);

        System.out.println("\nParameter list:");
        for (Parameter p : parameters) {
            System.out.println(p);
        }

        //Year year = new Year(2024);
        //parameters.add(year);
        // won't work because Year does not implement Parameter
    }
}
