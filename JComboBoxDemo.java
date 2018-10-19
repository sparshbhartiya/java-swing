package com.vedisoft.jm1.swing;

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	public class JComboBoxDemo extends JPanel {

		JComboBox<String>comboTypesList;
		JLabel jlbPicture;
		
		public JComboBoxDemo() {
			String[] comboTypes = { "Numbers", "Alphabets", "Symbols" };
			
			comboTypesList = new JComboBox<String>(comboTypes);
			comboTypesList.setSelectedIndex(2);
			comboTypesList.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					JComboBox jcmbType = (JComboBox) e.getSource();
					String cmbType = (String) jcmbType.getSelectedItem();
					jlbPicture.setIcon(new ImageIcon(getClass().getResource("/images/"	+ cmbType.trim().toLowerCase() + ".jpg")));
				}
			});

			// Set up the picture
			jlbPicture = new JLabel(new ImageIcon(getClass().getResource("/images/"+ comboTypes[comboTypesList.getSelectedIndex()] + ".jpg")));
			jlbPicture.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			jlbPicture.setPreferredSize(new Dimension(177, 122 + 10));
			
			// Layout the demo
			setLayout(new BorderLayout());
			add(comboTypesList, BorderLayout.NORTH);
			add(jlbPicture, BorderLayout.SOUTH);
			setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		}
		public static void main(String s[]) {
			JFrame frame = new JFrame("JComboBox Demo");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new JComboBoxDemo());
			frame.pack();
			frame.setVisible(true);
		}
	}

