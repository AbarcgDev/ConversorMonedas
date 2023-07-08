package dev.abargdev.oracleone;

import javax.swing.SwingUtilities;

import dev.abargdev.oracleone.gui.ConversorWindow;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ConversorWindow view = new ConversorWindow();
			}
		});
	}
}
