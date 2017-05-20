package Media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundControl {
    String[] soundName;
    Media[] sounds;
    Media music;
    MediaPlayer mediaPlayer, musicPlayer;
    public SoundControl(){
        soundName = new String[6];
        soundName[0] = "leftInfantry.mp3";
        soundName[1] = "leftArcher.mp3";
        soundName[2] = "leftCavalryman.mp3";
        soundName[3] = "rightInfantry.mp3";
        soundName[4] = "rightArcher.mp3";
        soundName[5] = "rightCavalryman.mp3";
        sounds = new Media[soundName.length];
        for(int i = 0;i < soundName.length;i++){
            sounds[i] = new Media(SoundControl.class.getResource("/audio/" + soundName[i]).toString());
        }
        music = new Media(SoundControl.class.getResource("/audio/bgm.mp3").toString());

    }

    public void play(int index){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(sounds[index]);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.play();
    }
    public void music(){
        musicPlayer = new MediaPlayer(music);
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        musicPlayer.play();

    }
}
