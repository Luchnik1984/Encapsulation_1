package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

import static java.lang.System.*;

public class ProductBasket {
    private final Map<String, Set<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        String name = product.getProductName();
        if (!products.containsKey(name)) {
            products.put(name, new HashSet<>());
            out.println("Продукт '"+ name +"' Добавлен в корзину");

        } else  {
            out.println("Продукт '"+ name +"' уже есть в корзине, повторное добавление не выполнено!");
        }
        products.get(name).add(product);
    }

    public int totalCostOfBasket() {
        int totalCost = 0;
        for (Set<Product> productSet : products.values()) {
            for (Product product : productSet) {
                totalCost += product.getCostOfProduct();
            }
        }
        return totalCost;
    }

    public int countingSpecialProduct() {
        int specialCount = 0;
        for (Set<Product> productSet : products.values()) {
            for (Product product : productSet) {
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

        for (Set<Product> productSet : products.values()) {
            for (Product product : productSet) {
                out.println(product);
            }
        }
        out.println("Итого: <" + totalCostOfBasket() + " руб.>" + " Всего товаров: "
                + products.values().stream().mapToInt(Set::size).sum() + " шт.");
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
        for (Set<Product> productSet : products.values()) {
            for (Product product : productSet) {
                out.println(product.getProductName());
            }
        }
    }

    public void printTotalCostOfBasket() {
        out.println("Стоимость корзины = " + totalCostOfBasket() + " руб.");
    }

    public boolean checkingProductAvailable(String name) {
        for (Set<Product> productSet : products.values()) {
            for (Product product : productSet) {
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

    public Set<Product> removedProductsByName(String name) {
        Set<Product> removedProducts = new HashSet<>();
        Iterator<Map.Entry<String, Set<Product>>> iterator = products.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Set<Product>> entry = iterator.next();
            if (entry.getKey().equalsIgnoreCase(name)) {
                removedProducts.addAll(entry.getValue());// Добавляем все продукты из совпадения
                iterator.remove(); // Безопасно удаляем запись
            }
        }
        return removedProducts;
    }

    public void printRemovedProducts(Set<Product> products) {
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
