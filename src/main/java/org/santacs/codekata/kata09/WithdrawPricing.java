package org.santacs.codekata.kata09;

import java.util.*;

public class WithdrawPricing implements Pricing {

    private final SortedSet<UnitPrice> pricingTable = new TreeSet<>(
            Comparator.comparing(UnitPrice::getUnit).reversed());

    @Override
    public void set(UnitPrice unitPrice) {
        pricingTable.add(unitPrice);
    }

    @Override
    public int price(int items) {
        int remaining = items;
        int price = 0;

        for (UnitPrice unitPrice : pricingTable) {
            int units = remaining / unitPrice.getUnit();
            price += units * unitPrice.getAmount();
            remaining -= units * unitPrice.getUnit();
        }
        return price;
    }

}
