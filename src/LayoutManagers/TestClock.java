package LayoutManagers;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

class ClockFrame extends JFrame {
	
	// Declare labels and calendar
	JLabel hourLabel, minLabel, secLabel, amPmLabel;
	
	
	public ClockFrame() {
		
		// Set layout and background colour
		getContentPane().setBackground(Color.white);
		setLayout(new GridLayout(2, 1));
		
		// Set up panel
		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.setBackground(Color.white);
		
		// Initialise labels with text
		hourLabel = new JLabel("HH", JLabel.CENTER);
		minLabel = new JLabel("MM", JLabel.CENTER);
		secLabel = new JLabel("SS", JLabel.CENTER);
		amPmLabel = new JLabel("AM/PM", JLabel.CENTER);
		
		// Create font and assign to labels
		Font f1 = new Font("Serif", Font.ITALIC, 36);
		hourLabel.setFont(f1);
		minLabel.setFont(f1);
		secLabel.setFont(f1);
		amPmLabel.setFont(f1);
		
		// Add elements to the frame
		panel.add(hourLabel);
		panel.add(minLabel);
		panel.add(secLabel);
		add(panel);
		add(amPmLabel);
		update();
	}
	
	public void update() {
		
		Calendar calendar = Calendar.getInstance();
		
		// Initialise current hour, minute and second
		int hours = calendar.get(Calendar.HOUR);
		int mins = calendar.get(Calendar.MINUTE);
		int secs = calendar.get(Calendar.SECOND);
		
		// Set current hour, minute and second to the text on the labels
		hourLabel.setText(String.valueOf(hours));
		minLabel.setText(String.valueOf(mins));
		secLabel.setText(String.valueOf(secs));
		
		// Display either AM or PM depending on current time
		amPmLabel.setText(calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM");
	}
	
}

public class TestClock {

	public static void main(String[] args) {
		ClockFrame cf = new ClockFrame();
		cf.setSize(600,300);
		cf.setTitle("Clock GUI");
		cf.setVisible(true);
		cf.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		while(true) {
			cf.update();
		}
	}
}
