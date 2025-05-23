package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.*;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();
    private int size;


    public void addProduct(Product product) {
        products.add(product);
        size++;
            }

    public int totalCostOfBasket() {

        int totalCost = 0;
        for (Product product : products) {
                totalCost += product.getCostOfProduct();
                    }
        return totalCost;
    }

    public int countingSpecialProduct() {
        int specialCount = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;
    }

    public void printBasket() {
        if (size == 0) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");
        for (Product product : products) {
            out.println(product);
        }
        out.println("Итого: <" + totalCostOfBasket() + " руб.>" + " Всего товаров: " + size + " шт.");
        if (countingSpecialProduct() > 0) {
            System.out.println("Специальных товаров: " + countingSpecialProduct() + " шт.");
        }
    }

    public void printBasketWithoutCost() {
        if (size == 0) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");
        for (Product product:products) {
            out.println(product.getProductName());
        }
    }

    public void printTotalCostOfBasket() {
        out.println("Стоимость корзины = " + totalCostOfBasket() + " руб.");
    }

    public boolean checkingProductAvailable(String name) {
        for (Product product:products) {
            if (name.equalsIgnoreCase(product.getProductName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        size = 0;
    }

    public void printCheckingProductAvailable(String name) {
        if (checkingProductAvailable(name)) {
            out.println("Продукт <" + name + "> найден в корзине");
            return;
        }
        out.println("Продукт <" + name + "> в корзине не найден");
    }

    public List<Product> removedProductsByName(String name){
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (name.equalsIgnoreCase(product.getProductName())) {
                iterator.remove();
                removedProducts.add(product);
                size--;
            }
        }
        return removedProducts;
    }

    public void printRemovedProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Список удалённых`продуктов пуст");
            return;
        }
        System.out.println("Удаленные продукты:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
