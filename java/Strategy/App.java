import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class App extends Application {
    private DatePicker datePicker;
    private ComboBox<String> categoryComboBox;
    private TextField descriptionTextField;
    private Button addButton;

    private EventManager eventManager;

    private boolean ok = false;

    private boolean isValid() {
        LocalDate date = datePicker.getValue();
        String categoryValue = (String) categoryComboBox.getValue();
        String description = descriptionTextField.getText();

        return date != null
                && (description != null && !description.isBlank())
                && (categoryValue != null && !categoryValue.isBlank());
    }

    @Override
    public void init() throws Exception {
        this.eventManager = EventManager.getInstance();
        this.eventManager.setEventProvider(new TestEventProvider());

        //Path eventsPath = eventManager.getEventsPath();
        //boolean success = eventManager.loadEvents(eventsPath);

        this.datePicker = new DatePicker();

        this.categoryComboBox = new ComboBox<String>();
        this.categoryComboBox.setEditable(true);
        this.categoryComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String oldValue, String newValue) {
                App.this.addButton.setDisable(!isValid());
            }
        });

        List<String> categories = this.eventManager.getCategories();
        //System.out.println("categories = " + categories);
        for (String categoryString: categories) {
            this.categoryComboBox.getItems().add(categoryString);
        }

        this.descriptionTextField = new TextField();
        descriptionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            this.addButton.setDisable(!isValid());
        });

        this.addButton = new Button("Add Event");
        this.addButton.setDisable(true);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LocalDate date = datePicker.getValue();
                Description description = new Description(descriptionTextField.getText());
                String categoryValue = (String) categoryComboBox.getValue();
                Category category = new Category(categoryValue);
                System.out.println("Adding event: date = " + date.toString() + ", category = " + category + ", description = " + description);
                Event newEvent = new Event(date, description, category);
                eventManager.getEvents().add(newEvent);
                //eventManager.saveEvents(eventsPath);
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        // If you did the UI in FXML, you would load it like this:
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("myview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        */

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.addRow(0, new Label("Date"), this.datePicker);
        gridPane.addRow(1, new Label("Category"), this.categoryComboBox);
        gridPane.addRow(2, new Label("Description"), this.descriptionTextField);
        gridPane.add(this.addButton, 1, 3);
        GridPane.setHalignment(this.addButton, HPos.CENTER);

        stage.setTitle("Days Helper");
        stage.setScene(new Scene(gridPane, 400, 200));
        stage.show();
    }

    public static void main(String[] args) {
        App.launch();
    }
}