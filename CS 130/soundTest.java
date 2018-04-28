import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class soundTest
{
	public static void main(String[] args)
	{
		String bip = "lunch.mp3";
		Media hit = new Media(bip);
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
	}
}