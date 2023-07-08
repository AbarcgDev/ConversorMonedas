package dev.abargdev.oracleone.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class ConversorWindow extends JFrame {
	private JPanel textDisplays;
	private JPanel controlPanel;
	private JTextField currencyToConvert;
	private JTextField convertedCurrency;
	private JMenu conversionType;
	private JButton makeConversion;

	public ConversorWindow() {
		setSize(400,200);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		instantiateComponents();
		initializeComponents();
		buildLayout();
		setVisible(true);
	}

	private void instantiateComponents() {
		textDisplays = new JPanel();
		controlPanel = new JPanel();
		currencyToConvert = new JTextField();
		convertedCurrency = new JTextField();
		conversionType = new JMenu("Conversion Type");
		makeConversion = new JButton("Convert");
	}

	private void initializeComponents() {
		currencyToConvert.setColumns(20);
		currencyToConvert.setHorizontalAlignment(JTextField.RIGHT);
		convertedCurrency.setColumns(20);
		convertedCurrency.setHorizontalAlignment(JTextField.RIGHT);
	}

	private void buildLayout() {
		buildInputPanel();
		buildControlPanel();
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(textDisplays, BorderLayout.CENTER);
		pane.add(controlPanel, BorderLayout.EAST);
	}

	private void buildInputPanel() {
		textDisplays.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 100;
		textDisplays.add(currencyToConvert, constraints);
		constraints.gridy = 1;
		textDisplays.add(convertedCurrency,constraints);
	}

	private void buildControlPanel() {
		controlPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 50;
		controlPanel.add(conversionType, constraints);
		constraints.gridy = 1;
		controlPanel.add(makeConversion,constraints);
	}
}
