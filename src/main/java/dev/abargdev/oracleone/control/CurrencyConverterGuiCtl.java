package dev.abargdev.oracleone.control;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import dev.abargdev.oracleone.model.conversors.CurrencyConversion;
import dev.abargdev.oracleone.model.conversors.CurrencyConversor;
import lombok.Getter;
import lombok.Setter;
import dev.abargdev.oracleone.gui.ConversorWindow;

@Getter
@Setter
public class CurrencyConverterGuiCtl {
  private ConversorWindow view;
  private CurrencyConversor conversor;
  private CurrencyConversion selectedConversion;

  public void handleConversionTypeMenuEvent(ActionEvent e) {
    view.clear();
    view.clearLog();
    JMenuItem source = (JMenuItem) e.getSource();
    selectedConversion = CurrencyConversion.getConversion(source.getMnemonic());
    view.setOriginalCurrencyLabel(selectedConversion.getOriginalCurrency().getLabel());
    view.setConvertedCurrencyLabel(selectedConversion.getConvertedCurrency().getLabel());
  }

  public void handleMakeConversionButtonEvent() {
    try {
      String input = view.getInputFieldValue();
      double originalCurrencyValue = Double.parseDouble(input);
      double convertedCurrencyValue = conversor.convert(selectedConversion, originalCurrencyValue);
      view.setInputFieldValue(String.valueOf(convertedCurrencyValue));
      view.clearLog();
    } catch (NumberFormatException e) {
      view.clear();
      view.displayErrorMsg("Ingrese un valor numerico");
    } catch (NullPointerException e) {
      view.displayErrorMsg("Selecciona un tipo de conversion");
    }
  }

}
