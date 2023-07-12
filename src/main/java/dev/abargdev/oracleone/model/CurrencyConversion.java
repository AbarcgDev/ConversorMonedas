package dev.abargdev.oracleone.model;

import java.util.EnumSet;
import java.util.HashMap;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import lombok.Getter;

@Getter
public enum CurrencyConversion {
  MXN_TO_USD(1, Currency.MXN, Currency.USD),
  USD_TO_MXN(2, Currency.USD, Currency.MXN),
  MXN_TO_EUR(3, Currency.MXN, Currency.EUR),
  EUR_TO_MXN(4, Currency.EUR, Currency.MXN),
  MXN_TO_YEN(5, Currency.MXN, Currency.YEN),
  YEN_TO_MXN(6, Currency.YEN, Currency.MXN),
  MXN_TO_WON(7, Currency.MXN, Currency.WON),
  WON_TO_MXN(8, Currency.WON, Currency.MXN);

  private int index;
  private Currency originalCurrency;
  private Currency convertedCurrency;
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

  private CurrencyConversion(int index, Currency originalCurrency, Currency convertedCurrency) {
    this.index = index;
    this.originalCurrency = originalCurrency;
    this.convertedCurrency = convertedCurrency;
  }

  @Override
  public String toString() {
    return String.format(NAME_FORMAT, originalCurrency.getName(), originalCurrency.getLabel(),
        convertedCurrency.getName(), convertedCurrency.getLabel());
  }
}
