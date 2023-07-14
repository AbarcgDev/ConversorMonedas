package dev.abargdev.oracleone.model.conversors;

import java.util.EnumSet;
import java.util.HashMap;

import lombok.Getter;

import dev.abargdev.oracleone.model.currency.Currency;

@Getter
public enum CurrencyConversion {
  MXN_TO_USD(1, Currency.MXN, Currency.USD, 0.059),
  USD_TO_MXN(2, Currency.USD, Currency.MXN, 16.84),
  MXN_TO_EUR(3, Currency.MXN, Currency.EUR, 0.053),
  EUR_TO_MXN(4, Currency.EUR, Currency.MXN, 18.92),
  MXN_TO_YEN(5, Currency.MXN, Currency.YEN, 8.17),
  YEN_TO_MXN(6, Currency.YEN, Currency.MXN, 0.12),
  MXN_TO_WON(7, Currency.MXN, Currency.WON, 75.02),
  WON_TO_MXN(8, Currency.WON, Currency.MXN, 0.013);

  private int index;
  private Currency originalCurrency;
  private Currency convertedCurrency;
  private double exchangeRate;
  private static final String NAME_FORMAT = "%s(%s) to %s(%s)";

  private static HashMap<Integer, CurrencyConversion> mapByIndex;

  static {
    mapByIndex = new HashMap<>();
    EnumSet.allOf(CurrencyConversion.class).forEach(conversion -> {
      mapByIndex.put(conversion.getIndex(), conversion);
    });
  }

  public static CurrencyConversion getConversion(int index) {
    return mapByIndex.get(index);
  }

  private CurrencyConversion(int index, Currency originalCurrency, Currency convertedCurrency, double exchangeRate) {
    this.index = index;
    this.originalCurrency = originalCurrency;
    this.convertedCurrency = convertedCurrency;
    this.exchangeRate = exchangeRate;
  }

  @Override
  public String toString() {
    return String.format(NAME_FORMAT, originalCurrency.getName(), originalCurrency.getLabel(),
        convertedCurrency.getName(), convertedCurrency.getLabel());
  }
}
