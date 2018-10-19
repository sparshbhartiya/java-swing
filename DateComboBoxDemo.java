package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;

public class DateComboBoxDemo extends JPanel {

	JLabel jlbResult;
	String datePattern_Current;
	JLabel jlbHeading;
	JComboBox<String> patternList;
	
	public DateComboBoxDemo() {
		String[] datePatterns = { "dd MMMMM yyyy", "dd.MM.yy", "MM/dd/yy", "yyyy.MM.dd G 'at' hh:mm:ss z",
				"EEE, MMM d, ''yy", "h:mm a", "H:mm:ss:SSS", "K:mm a,z", "yyyy.MMMMM.dd GGG hh:mm aaa" };
		datePattern_Current = datePatterns[0];

		jlbHeading = new JLabel("Enter Date pattern /Select from list:");
		patternList = new JComboBox<String>(datePatterns);
		patternList.setEditable(true);
		patternList.setAlignmentX(Component.LEFT_ALIGNMENT);
		patternList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox jcmbDates = (JComboBox) e.getSource();
				String seletedDate = (String) jcmbDates.getSelectedItem();
				datePattern_Current = seletedDate;
				showDateinLabel();
			}
		});
		// Create the UI for displaying result
		JLabel jlbResultHeading = new JLabel("Current Date/Time", JLabel.LEFT);
		jlbResult = new JLabel(" ");
		jlbResult.setForeground(Color.black);
		jlbResult.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		// Lay out everything
		JPanel jpnDate = new JPanel();
		jpnDate.setLayout(new BoxLayout(jpnDate, BoxLayout.Y_AXIS));
		jpnDate.add(jlbHeading);
		jpnDate.add(patternList);
		JPanel jpnResults = new JPanel();
		jpnResults.setLayout(new GridLayout(0, 1));
		jpnResults.add(jlbResultHeading);
		jpnResults.add(jlbResult);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		jpnDate.setAlignmentX(Component.LEFT_ALIGNMENT);
		jpnResults.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(jpnDate);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(jpnResults);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		showDateinLabel();
	} // constructor

	/** Formats and displays today's date. */
	public void showDateinLabel() {
		Date today = new Date();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(datePattern_Current);
			String dateString = formatter.format(today);
			jlbResult.setForeground(Color.black);
			jlbResult.setText(dateString);
		} catch (IllegalArgumentException e) {
			jlbResult.setForeground(Color.red);
			jlbResult.setText("Error: " + e.getMessage());
		}
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("JComboBox Date Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DateComboBoxDemo());
		frame.pack();
		frame.setVisible(true);
	}
}