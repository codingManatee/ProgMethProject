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
		this.setPadding(new Insets(30));

		AnchorPane allButton = new AnchorPane();
		initializeBackButton();
		allButton.setLeftAnchor(backButton, 0.0);
		allButton.getChildren().add(backButton);

		backURL = ClassLoader.getSystemResource("pagegui/back.png").toString();
		descriptionURL = ClassLoader.getSystemResource("pagegui/description.png").toString();
		ImageView description = new ImageView(new Image(descriptionURL));
		description.setFitHeight(350);
		description.setFitWidth(490);

		BorderPane borderpane = new BorderPane();
		borderpane.setCenter(description);

		VBox page = new VBox();
		StackPane s = new StackPane();
		s.setMinSize(200, 200);
		s.setMaxSize(200, 200);
		StackPane p = new StackPane();
		p.setMinSize(175, 175);
		p.setMaxSize(175, 175);
		page.getChildren().addAll(s, borderpane, p, allButton);

<<<<<<< Updated upstream
        this.getChildren().add(page);
    }
    public void initializeBackButton() {
        backButton = new Button();
        backButton.setMinSize(80, 30);
        backButton.setMaxSize(80, 30);
=======
		this.getChildren().add(page);
	}
>>>>>>> Stashed changes

	public void initializeBackButton() {
		backButton = new Button();
		backButton.setMinSize(175, 40);
		backButton.setMaxSize(175, 40);

		backURL = ClassLoader.getSystemResource("pagegui/goback.png").toString();
		ImageView back = new ImageView(new Image(backURL));
		backButton.setGraphic(back);

		String buttonsoundURL = ClassLoader.getSystemResource("sound/buttonsound.mp3").toString();
		AudioClip buttonsound = new AudioClip(buttonsoundURL);

<<<<<<< Updated upstream
    public void backButtonHandler() {
        HomePage homepage = new HomePage();
        this.setVisible(true);
        this.getChildren().clear();
        this.getChildren().add(homepage);
    }
}
=======
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
>>>>>>> Stashed changes
