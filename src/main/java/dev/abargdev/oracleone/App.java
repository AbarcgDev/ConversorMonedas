package dev.abargdev.oracleone;

import javax.swing.SwingUtilities;

import dev.abargdev.oracleone.gui.ConversorWindow;
import dev.abargdev.oracleone.model.conversors.CurrencyConversor;
import dev.abargdev.oracleone.control.CurrencyConverterGuiCtl;

public class App {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        CurrencyConverterGuiCtl controller = new CurrencyConverterGuiCtl();
        ConversorWindow view = new ConversorWindow(controller);
        CurrencyConversor model = new CurrencyConversor();
        controller.setView(view);
        controller.setConversor(model);
      }
    });
  }
}
