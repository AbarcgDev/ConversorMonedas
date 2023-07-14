package dev.abargdev.oracleone.model.conversors;

public class CurrencyConversor {
  public double convert(CurrencyConversion conversionType, double originalCurrencyValue) {
    double exchangeRate = conversionType.getExchangeRate();
    return originalCurrencyValue * exchangeRate;
  }
}
