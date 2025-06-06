package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int discountInWholePercentages;

    public DiscountedProduct(String productName, int basePrice, int discountInWholePercentages) {
        super(productName);
        this.basePrice = basePrice;
        this.discountInWholePercentages = discountInWholePercentages;
    }

    @Override
    public int getCostOfProduct() {
        return (int) (basePrice * (1 - (discountInWholePercentages / 100D)));
    }

    @Override
    public String toString() {
        return " < продукт со скидкой: " + super.getProductName() + " > :" +
                " < стоимость: " + getCostOfProduct() + " руб >" +
                " (< скидка " + discountInWholePercentages + " >%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
