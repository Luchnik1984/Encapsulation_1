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
            out.println("Продукт '" + name + "' Добавлен в корзину");

        } else {
            out.println("Продукт '" + name + "' уже есть в корзине, повторное добавление не выполнено!");
        }
        products.get(name).add(product);
    }

    private int totalCostOfBasket() {
        return products.values().stream()
                .flatMap(Set::stream)// направляем вложенные Set<Product> в один поток
                .mapToInt(Product::getCostOfProduct)// преобразуем Product в int (стоимость)
                .sum();
    }

    private int countingSpecialProduct() {
        return (int) products.values().stream()
                .flatMap(Set::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            out.println("В корзине пусто.");
            return;
        }
        out.println(" \nСейчас в корзине: ");
        products.values().stream()
                .flatMap(Set::stream)
                .forEach(out::println);// печатаем каждый продукт

        out.println("Итого: <" + totalCostOfBasket() + " руб.>" + " Всего товаров: "
                + products.values().stream()
                .mapToInt(Set::size)
                .sum() + " шт.");
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
        products.values().stream()
                .flatMap(Set::stream)
                .map(Product::getProductName)
                .forEach(out::println);
    }

    public void printTotalCostOfBasket() {
        out.println("Стоимость корзины = " + totalCostOfBasket() + " руб.");
    }

    private boolean checkingProductAvailable(String name) {
        return products.values().stream()
                .flatMap(Set::stream)
                .anyMatch(product -> name.equalsIgnoreCase(product.getProductName()));

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
        products.forEach(out::println);
    }
}
