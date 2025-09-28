// Adapter Pattern Example

interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee
class AdvancedMediaPlayer {
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
    }
}

// Concrete MediaPlayer
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

// Demo
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
    }
}
