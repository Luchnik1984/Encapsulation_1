package org.skypro.skyshop.product;


public class SimpleProduct extends Product{
     public int costOfProduct;

    public SimpleProduct(String productName, int costOfProduct) {
        super(productName);
        if (costOfProduct<=0){
            throw new IllegalArgumentException("Цена продукта не является положительным числом. Недопустимая цена!");
        }
        this.costOfProduct = costOfProduct;
    }

    @Override
    public int getCostOfProduct() {
        return costOfProduct;
    }

    @Override
    public String toString() {
        return "< продукт: "+super.getProductName()+  " > :" +
                " < стоимость: "+getCostOfProduct()+ " руб >";

    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
