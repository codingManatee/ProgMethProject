package component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;

public class TutorialPage extends StackPane {
    public final String descriptionURL;
    private Button backButton;
    private String backURL;

    public TutorialPage() {
        this.setMinSize(1344, 832);
        this.setMaxSize(1344, 832);
        this.setPadding(new Insets(10));

        AnchorPane allButton = new AnchorPane();
        initializeBackButton();
        allButton.setLeftAnchor(backButton, 0.0);
        allButton.getChildren().add(backButton);

        backURL = ClassLoader.getSystemResource("test/back.png").toString();
        descriptionURL = ClassLoader.getSystemResource("test/description.png").toString();
        ImageView description = new ImageView(new Image(descriptionURL));
        description.setFitHeight(500);
        description.setFitWidth(500);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(description);

        VBox page = new VBox();
        page.getChildren().addAll(borderpane, allButton);

        this.getChildren().add(page);
    }
    
    public void initializeBackButton() {
        backButton = new Button();
        backButton.setMinSize(80, 30);
        backButton.setMaxSize(80, 30);

        backURL = ClassLoader.getSystemResource("test/back.png").toString();
        ImageView back = new ImageView(new Image(backURL));
        backButton.setGraphic(back);

        String buttonsoundURL = ClassLoader.getSystemResource("test/buttonsound.mp3").toString();
        AudioClip buttonsound = new AudioClip(buttonsoundURL);

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonsound.play();
                backButtonHandler();
            }
        });
    }

    public void backButtonHandler() {
        HomePage homepage = new HomePage();
        this.setVisible(true);
        this.getChildren().clear();
        this.getChildren().add(homepage);
    }
}