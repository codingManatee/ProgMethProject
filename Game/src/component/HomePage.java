package component;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.GameLogic;
import main.GamePanel;
import main.Main;
import sharedObject.RenderableHolder;

public class HomePage extends StackPane {
	private Button newgameButton;
	private String newgameURL;

	private Button tutorialButton;
	private String tutorialURL;

	private Button quitButton;
	private String quitURL;

	private Button soundButton;
	private String soundURL;

	private String unmuteURL;
	private ImageView unmute;

	private String muteURL;
	private ImageView mute;

	private boolean isMute;
	private AudioClip sound;

	public HomePage() {
		this.setMinSize(1344, 832);
		this.setMaxSize(1344, 832);
		this.setPadding(new Insets(10));
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

		initializeSoundButton();
		this.setAlignment(soundButton, Pos.TOP_LEFT);

		VBox allButton = new VBox();
		initializeNewGameButton();
		initializeTutorialButton();
		initializeQuitButton();

		allButton.setSpacing(50);
		allButton.setAlignment(Pos.CENTER);
		allButton.getChildren().addAll(newgameButton, tutorialButton, quitButton);

		this.getChildren().addAll(allButton, soundButton);
	}

	public void initializeNewGameButton() {
		newgameButton = new Button();
		newgameButton.setMinSize(300, 55);
		newgameButton.setMaxSize(300, 55);

		newgameURL = ClassLoader.getSystemResource("test/newgame.png").toString();
		ImageView newgame = new ImageView(new Image(newgameURL));
		newgameButton.setGraphic(newgame);

		String startsoundURL = ClassLoader.getSystemResource("test/startsound.mp3").toString();
		AudioClip startsound = new AudioClip(startsoundURL);

		newgameButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				sound.stop();
				startsound.play();
				newgameButtonHandler();
			}
		});
	}

	public void newgameButtonHandler() {

		GameLogic logic = new GameLogic();
		GamePanel gamePanel = new GamePanel();

		this.setVisible(true);
		this.getChildren().clear();
		this.getChildren().add(gamePanel);

		gamePanel.requestFocus();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {

				gamePanel.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
		animation.start();
	}

	public void initializeTutorialButton() {
		tutorialButton = new Button();
		tutorialButton.setMinSize(300, 55);
		tutorialButton.setMaxSize(300, 55);

		tutorialURL = ClassLoader.getSystemResource("test/tutorial.png").toString();
		ImageView tutorial = new ImageView(new Image(tutorialURL));
		tutorialButton.setGraphic(tutorial);

		String buttonsoundURL = ClassLoader.getSystemResource("test/buttonsound.mp3").toString();
		AudioClip buttonsound = new AudioClip(buttonsoundURL);

		tutorialButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				sound.stop();
				buttonsound.play();
				tutorialButtonHandler();
			}
		});
	}

	public void tutorialButtonHandler() {
		TutorialPage tutorialpage = new TutorialPage();
		this.setVisible(true);
		this.getChildren().clear();
		this.getChildren().add(tutorialpage);
	}

	public void initializeQuitButton() {
		quitButton = new Button();
		quitButton.setMinSize(300, 55);
		quitButton.setMaxSize(300, 55);

		quitURL = ClassLoader.getSystemResource("test/quit.png").toString();
		ImageView quit = new ImageView(new Image(quitURL));
		quitButton.setGraphic(quit);

		String buttonsoundURL = ClassLoader.getSystemResource("test/buttonsound.mp3").toString();
		AudioClip buttonsound = new AudioClip(buttonsoundURL);

		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				buttonsound.play();
				quitButtonHandler();
			}
		});
	}

	public void quitButtonHandler() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "QUIT GAME?");
		alert.setTitle("QUIT GAME");
		alert.setHeaderText("");

		alert.getDialogPane().getButtonTypes().clear();
		alert.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
		alert.showAndWait().ifPresent(response -> {
			if (response == ButtonType.YES) {
				Platform.exit();
				// System.exit(0);
			} else {
				String buttonsoundURL = ClassLoader.getSystemResource("test/buttonsound.mp3").toString();
				AudioClip buttonsound = new AudioClip(buttonsoundURL);
				buttonsound.play();
			}
		});
	}

	public void initializeSoundButton() {
		soundButton = new Button();
		soundButton.setMinSize(55, 55);
		soundButton.setMaxSize(55, 55);

		unmuteURL = ClassLoader.getSystemResource("test/unmute.png").toString();
		unmute = new ImageView(new Image(unmuteURL));

		muteURL = ClassLoader.getSystemResource("test/mute.png").toString();
		mute = new ImageView(new Image(muteURL));

		soundButton.setGraphic(unmute);

		soundURL = ClassLoader.getSystemResource("test/titlesong.wav").toString();
		sound = new AudioClip(soundURL);
		sound.setVolume(0.2);
		sound.play();

		soundButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				soundButtonHandler();
			}
		});
	}

	public void soundButtonHandler() {
		if (!isMute) {
			soundButton.setGraphic(mute);
			isMute = true;
			sound.stop();
		} else {
			soundButton.setGraphic(unmute);
			isMute = false;
			sound.play();
		}
	}
}