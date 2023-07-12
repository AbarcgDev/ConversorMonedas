package dev.abargdev.oracleone.model;

import java.util.EnumSet;
import java.util.HashMap;

import lombok.Getter;

@Getter
public enum Currency {
  MXN(1, "Mexican Peso", "MXN"),
  USD(2, "American Dollar", "USD"),
  EUR(3, "Euro", "EUR"),
  YEN(4, "Japanesse Yen", "YEN"),
  WON(5, "Korean Won-Sul", "WON");

  private int index;
  private String name;
  private String label;
  private static HashMap<Integer, Currency> mapByIndex;
  private static HashMap<String, Currency> mapByLabel;

  static {
    mapByIndex = new HashMap<>();
    mapByLabel = new HashMap<>();
    EnumSet.allOf(Currency.class).forEach(currency -> {
      mapByIndex.put(currency.getIndex(), currency);
      mapByLabel.put(currency.getLabel(), currency);
    });
  }

  public static Currency getCurrency(int index) {
    return mapByIndex.get(index);
  }

  public static Currency getCurrency(String label) {
    return mapByLabel.get(label);
  }

  private Currency(int index, String name, String label) {
    this.label = label;
    this.name = name;
    this.index = index;
  }
}
