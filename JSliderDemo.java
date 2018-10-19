package com.vedisoft.jm1.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.*;

public class JSliderDemo extends JPanel implements ChangeListener {
	JSlider s1, s2, s3, s4, s5;
	JLabel l1;
	Hashtable<Integer, JLabel> h = new Hashtable<>();

	{
		h.put(0, new JLabel("Zero"));
		h.put(10, new JLabel("Ten"));
		h.put(20, new JLabel("Twenty"));
		h.put(30, new JLabel("Thirty"));
		h.put(40, new JLabel("Forty"));
		h.put(50, new JLabel("Fifty"));
	}

	public JSliderDemo() {
		setLayout(new FlowLayout());

		s1 = new JSlider();
		// orientation
		s2 = new JSlider(SwingConstants.VERTICAL);
		// min,max
		s3 = new JSlider(10, 90);
		// min,max,val
		s4 = new JSlider(0, 50, 10);
		// orientation, min,max,val
		s5 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
		l1 = new JLabel("Value : ");
		// Set value
		s1.setValue(20);
		s2.setValue(40);
		s3.setValue(20);

		// Set minimum,maximum
		s1.setMinimum(10);
		s1.setMaximum(40);

		// If you set more than maximum, then
		// maximum is considered, i.e.
		// here setValue(40) is substituted
		s1.setValue(42);

		System.out.println("Value of s1 is " + s1.getValue());

		// Set orientation
		s4.setOrientation(SwingConstants.VERTICAL);

		// Set border
		s1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, false));

		s1.setMinorTickSpacing(5);
		s1.setMajorTickSpacing(10);
		s4.setMajorTickSpacing(10);
		s5.setMinorTickSpacing(5);
		s5.setMajorTickSpacing(10);

		// Set paint labels
		s1.setPaintLabels(true);
		s1.setPaintTicks(true);
		s4.setPaintLabels(true);
		s5.setPaintLabels(true);
		s5.setPaintTicks(true);

		s1.setSnapToTicks(true);

		s1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		s3.setInverted(true);

		s4.setLabelTable(h);

		s5.setExtent(20);

		s1.addChangeListener(this);

		add(s1);
		add(s2);
		add(s3);
		add(s4);
		add(s5);
		add(l1);

		setSize(600, 400);
		setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider js = (JSlider) e.getSource();
		l1.setText("Value : " + js.getValue());
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("JSlider Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JSliderDemo());
		frame.pack();
		frame.setVisible(true);
	}
}