package dev.abargdev.oracleone.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dev.abargdev.oracleone.model.CurrencyConversion;

import java.awt.*;
import java.util.EnumSet;

public class ConversorWindow extends JFrame {
  private JPanel textDisplays;
  private JPanel controlPanel;
  private JTextField currencyToConvert;
  private JTextField convertedCurrency;
  private JMenu conversionType;
  private JMenuBar menuBar;
  private JButton makeConversion;
  private JLabel currencyToConvertLabel;
  private JLabel convertedCurrencyLabel;

  public ConversorWindow() {
    setSize(400, 200);
    setResizable(false);
    setTitle("Conversor De Monedas");
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
    menuBar = new JMenuBar();
    conversionType = new JMenu("Conversion Type");
    makeConversion = new JButton("Convert");
    convertedCurrencyLabel = new JLabel("USD", JLabel.RIGHT);
    currencyToConvertLabel = new JLabel("MXN", JLabel.RIGHT);
  }

  private void initializeComponents() {
    currencyToConvert.setColumns(20);
    currencyToConvert.setHorizontalAlignment(JTextField.RIGHT);
    convertedCurrency.setColumns(20);
    convertedCurrency.setHorizontalAlignment(JTextField.RIGHT);
    convertedCurrency.setEditable(false);
    convertedCurrency.setBackground(Color.WHITE);
    convertedCurrency.setFocusable(false);

    conversionType.setVisible(true);
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
    constraints.gridwidth = 3;
    constraints.insets = new Insets(5, 5, 2, 2);
    textDisplays.add(currencyToConvertLabel, constraints);
    constraints.gridx = 4;
    constraints.gridwidth = 100;
    textDisplays.add(currencyToConvert, constraints);

    constraints.gridy = 1;
    constraints.gridx = 0;
    constraints.gridwidth = 10;
    textDisplays.add(convertedCurrencyLabel, constraints);
    constraints.gridx = 4;
    constraints.gridwidth = 100;
    textDisplays.add(convertedCurrency, constraints);
  }

  private void buildControlPanel() {
    controlPanel.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 50;
    constraints.insets = new Insets(10, 10, 2, 2);
    buildMenuBar();
    controlPanel.add(menuBar, constraints);
    constraints.gridy = 1;
    controlPanel.add(makeConversion, constraints);
  }

  private void buildMenuBar() {
    EnumSet.allOf(CurrencyConversion.class).forEach(conversion -> {
      JMenuItem newMenuItem = new JMenuItem(conversion.toString(), conversion.getIndex());
      // newMenuItem.addActionListener();
      conversionType.add(newMenuItem);
    });
    menuBar.add(conversionType);
  }
}
