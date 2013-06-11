/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Phillipp
 *
 */
public class OutputPane {

	private JFrame frame;
	private JLabel labelX1;
	private JLabel labelX2;
	private JLabel labelX3;
	private JLabel labelX4;
	private JLabel labelX5;
	private JLabel labelX6;
	private JLabel labelX7;
	private JLabel labelX8;
	private JLabel labelSolutionX1;
	private JLabel labelSolutionX2;
	private JLabel labelSolutionX3;
	private JLabel labelSolutionX4;
	private JLabel labelSolutionX5;
	private JLabel labelSolutionX6;
	private JLabel labelSolutionX7;
	private JLabel labelSolutionX8;
	private JButton button;
	
	/**
	 * 
	 */
	public OutputPane() {
		frame = new JFrame("Search Output");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setComponents();
		showPane();
	}

	private void setComponents() {
		labelX1 = new JLabel("x1 = ");
		labelX2 = new JLabel("x2 = ");
		labelX3 = new JLabel("x3 = ");
		labelX4 = new JLabel("x4 = ");
		labelX5 = new JLabel("x5 = ");
		labelX6 = new JLabel("x6 = ");
		labelX7 = new JLabel("x7 = ");
		labelX8 = new JLabel("x8 = ");
		
		labelSolutionX1 = new JLabel();
		labelSolutionX2 = new JLabel();
		labelSolutionX3 = new JLabel();
		labelSolutionX4 = new JLabel();
		labelSolutionX5 = new JLabel();
		labelSolutionX6 = new JLabel();
		labelSolutionX7 = new JLabel();
		labelSolutionX8 = new JLabel();
		
		button = new JButton("Compute");
		
		frame.setLayout(new GridLayout(9, 2));
		
		frame.getContentPane().add(labelX1);
		frame.getContentPane().add(labelSolutionX1);
		frame.getContentPane().add(labelX2);
		frame.getContentPane().add(labelSolutionX2);
		frame.getContentPane().add(labelX3);
		frame.getContentPane().add(labelSolutionX3);
		frame.getContentPane().add(labelX4);
		frame.getContentPane().add(labelSolutionX4);
		frame.getContentPane().add(labelX5);
		frame.getContentPane().add(labelSolutionX5);
		frame.getContentPane().add(labelX6);
		frame.getContentPane().add(labelSolutionX6);
		frame.getContentPane().add(labelX7);
		frame.getContentPane().add(labelSolutionX7);
		frame.getContentPane().add(labelX8);
		frame.getContentPane().add(labelSolutionX8);
		frame.getContentPane().add(button);
	}
	
	private void showPane() {
		frame.pack();
		frame.setVisible(true);
	}
}
