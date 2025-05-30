package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.*;

import static java.lang.System.*;

public class ProductBasket {
     private final Map<String, List<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        String name = product.getProductName();
        if (!products.containsKey(name)) {
            products.put(name, new LinkedList<>());
        }
        products.get(name).add(product);

    }

    public int totalCostOfBasket() {
        int totalCost = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                totalCost += product.getCostOfProduct();
            }
        }
        return totalCost;
    }

    public int countingSpecialProduct() {
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                out.println(product);
            }
        }
        out.println("Итого: <" + totalCostOfBasket() + " руб.>" + " Всего товаров: "
                + products.values().stream().mapToInt(List::size).sum() + " шт.");
        if (countingSpecialProduct() > 0) {
            out.println("Специальных товаров: " + countingSpecialProduct() + " шт.");
        }
    }

    public void printBasketWithoutCost() {
        if (products.isEmpty()) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                out.println(product.getProductName());
            }
        }
    }

    public void printTotalCostOfBasket() {
        out.println("Стоимость корзины = " + totalCostOfBasket() + " руб.");
    }

    public boolean checkingProductAvailable(String name) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (name.equalsIgnoreCase(product.getProductName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();

    }

    public void printCheckingProductAvailable(String name) {
        if (checkingProductAvailable(name)) {
            out.println("Продукт <" + name + "> найден в корзине");
            return;
        }
        out.println("Продукт <" + name + "> в корзине не найден");
    }

    public List<Product> removedProductsByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Map.Entry<String, List<Product>>> iterator = products.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> entry = iterator.next();
            if (entry.getKey().equalsIgnoreCase(name)) {
                removedProducts.addAll(entry.getValue());// Добавляем все продукты из совпадения
                iterator.remove(); // Безопасно удаляем запись

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
