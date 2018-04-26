import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class test
{
	public static void main(String []args)
	{
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(getResource("music.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
	}
}