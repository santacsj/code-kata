package org.santacs.codekata.kata09;

public class SpecialOffer extends UnitPrice {

    public static SpecialOffer twoFor(int amount) {
        return new SpecialOffer(amount, 2);
    }

    private final int unit;

    public SpecialOffer(int amount, int unit) {
        super(amount);
        checkUnit(unit);
        this.unit = unit;
    }

    private void checkUnit(int unit) {
        if (unit < 2)
            throw new IllegalArgumentException();
    }

    @Override
    public int getUnit() {
        return unit;
    }

}
