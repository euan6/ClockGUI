package LayoutManagers;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

class ProgressFrame extends JFrame {
	
	// Declare labels
	JLabel[] progressMeter = new JLabel[10];
	JLabel percentLabel;
	
	public ProgressFrame() {
		
		// Set up panel
		JPanel panel = new JPanel(new GridLayout(11, 1));
		
		// Add 10 progress labels
		for (int i = 0; i < progressMeter.length; i++) {
			progressMeter[i] = new JLabel();
			progressMeter[i].setOpaque(true);
			progressMeter[i].setBackground(Color.red);
			panel.add(progressMeter[i]);
		}
		
		// Add bottom label and panel
		percentLabel = new JLabel("0%", JLabel.CENTER);
		panel.add(percentLabel);
		add(panel);
	}
	
	public void percentage() {
		
		// Initialise input scanner and progress %
		Scanner scanner = new Scanner(System.in);
		int progress = 0;
		int labelNum = 0;
		percentLabel.setText(String.valueOf(progress) + "%");
		
		// Update the progress every time enter is clicked
		while (progress < 100) {
			System.out.println("> Press enter to increase the progress!");
			scanner.nextLine();
			progress += 10;
			percentLabel.setText(String.valueOf(progress) + "%");
			labelNum++;
			update(labelNum);
		}
		System.out.println("> Progress 100%");
		scanner.close();
	}
	
	public void update(int labelNum) {
		for (int i = 0; i < labelNum; i++) {
			progressMeter[i].setBackground(Color.green);
		}
	}
}

public class TestProgress {

	public static void main(String[] args) {
		ProgressFrame pf = new ProgressFrame();
		pf.setSize(200,550);
		pf.setTitle("Progress GUI");
		pf.setVisible(true);
		pf.percentage();
		pf.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
			}
		});
	}

}
