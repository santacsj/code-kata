package org.santacs.codekata.kata09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PricingTest {

    @Test
    public void shouldPriceItems() {
        Pricing aPricing = new WithdrawPricing();
        aPricing.set(new UnitPrice(50));
        assertThat(aPricing.price(2), equalTo(50 * 2));
    }

    @Test
    public void shouldPriceItemsWithSpecialOffer() {
        Pricing aPricing = new WithdrawPricing();
        aPricing.set(new UnitPrice(50));
        aPricing.set(SpecialOffer.twoFor(80));
        assertThat(aPricing.price(2 + 1), equalTo(80 + 50));
    }

    @Test
    public void unitPriceUnitShouldBeOne() {
        assertThat(new UnitPrice(50).getUnit(), equalTo(1));
    }

    @Test
    public void unitPriceAmountShouldBeTheAmount() {
        assertThat(new UnitPrice(50).getAmount(), equalTo(50));
    }

    @Test
    public void specialOfferUnitShouldBeTheUnit() {
        assertThat(new SpecialOffer(50, 2).getUnit(), equalTo(2));
    }

    @Test
    public void specialOfferAmountShouldBeTheAmount() {
        assertThat(new SpecialOffer(50, 2).getAmount(), equalTo(50));
    }

    @Test(expected = IllegalArgumentException.class)
    public void specialOfferShouldThrowWhenUnitIsLessThen2() {
        new SpecialOffer(50, 1);
    }
}
