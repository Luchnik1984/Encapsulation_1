package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

import static java.lang.System.*;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5];
        this.size = 0;
    }


    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
        } else {
            out.println("В корзине занятых мест: " + size + "/" + products.length + " Для этого продукта нет места.");
        }
    }

    public int totalCostOfBasket() {

        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getCostOfProduct();
            }
        }
        return totalCost;
    }

    public int countingSpecialProduct(){
        int specialCount = 0;
        for (Product product:products){
            if (product!=null&&product.isSpecial()){
                specialCount++;
            }
        }return specialCount;
    }

    public void printBasket() {
        if (size == 0) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            out.println(product);
        }
        out.println("Итого: <" + totalCostOfBasket() + " руб.>" + " Занятых мест: " + size + "/" + products.length+
                "\nСпециальных товаров: < "+countingSpecialProduct()+" >");
    }

    public void printBasketWithoutCost() {
        if (size == 0) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            out.println(product.getProductName());
        }
    }

    public void printTotalCostOfBasket() {
        out.println("Стоимость корзины = " + totalCostOfBasket() + " руб.");
    }

    public boolean checkingProductAvailable(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }

    public void printCheckingProductAvailable(String name) {
        if (checkingProductAvailable(name)) {
            out.println("Продукт <" + name + "> найден в корзине");

            return;
        }
        out.println("Продукт <" + name + "> в корзине не найден");
    }

}
