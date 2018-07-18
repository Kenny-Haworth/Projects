import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class progress extends JPanel
{
	JProgressBar pbar;
	
	static int min = 0;
	static int max = 100;
	
	public progress()
	{
		pbar = new JProgressBar();
		pbar.setMinimum(min);
		pbar.setMaximum(max);
		add(pbar);
		
		JFrame frame = new JFrame("Progress Bar Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
		
		/**for (int i = min; i <= max; i++)
		{
			final int percent = i;
			try
			{
				SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						updateBar(percent);
					}
				});
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void updateBar(int newValue)
	{
		pbar.setValue(newValue);
	}
	
	public static void main(String args[])
	{
		new progress();
		for (int i = 0; i < 1000; i++)
		{
			pbar.updateBar(i);
		}
	}
}*/


/**import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class progress 
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("Progress");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = f.getContentPane();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setStringPainted(true);
		Border border = BorderFactory.createTitledBorder("Reading...");
		progressBar.setBorder(border);
		content.add(progressBar, BorderLayout.NORTH);
		f.setSize(500, 100);
		f.setVisible(true);
		System.exit(0);
	}
}*/
