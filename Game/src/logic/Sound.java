package logic;

import java.util.ArrayList;

import javafx.scene.media.AudioClip;

public class Sound {
	
	AudioClip clip;
	ArrayList<AudioClip> soundURL = new ArrayList<AudioClip>();
	
	public Sound() {
		try {
			soundURL.add(0,new AudioClip(ClassLoader.getSystemResource("sound/ThemeSong.wav").toString()));
			
		} catch (Exception e) {
			System.out.println("Load Sound Fail!");
		}
	}
	
	public void setFile(int i ) {
		clip = soundURL.get(i);
	}
	
	public void play() {
		clip.setVolume(0.07);
		clip.play();
	}
	
	public void loop() {
		clip.setCycleCount(-1);
	}
	
	public void stop() {
		clip.stop();
	}
}
