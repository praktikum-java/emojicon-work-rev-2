package ru.practicum.emojicon.mod;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Soundtrack {
    Clip clip;
    Long position;
    AudioInputStream audioInputStream;
    static String file;

    public Soundtrack(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file = fileName;
        audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        clip.start();
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
        clip.close();
    }

    public void pause() {
        this.position = this.clip.getMicrosecondPosition();
        clip.stop();
    }

    public void resume() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(position);
        this.play();
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
