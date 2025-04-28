package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIXED_PRISE =101;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getCostOfProduct() {
        return FIXED_PRISE;
    }

    @Override
    public String toString() {
        return " < продукт c фиксированной ценой: "+super.getProductName()+  " > :" +
                "  Фиксированная цена: < "+FIXED_PRISE+ " руб >";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
