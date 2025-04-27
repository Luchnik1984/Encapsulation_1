package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("яблоки", 150);
        Product product2 = new Product("бананы", 100);
        Product product3 = new Product("Хлеб", 70);
        Product product4 = new Product("колбаса", 800);
        Product product5 = new Product("яйца", 195);
        Product product6 = new Product("молоко", 120);

        ProductBasket basket1 = new ProductBasket(); // Создаём корзину
        System.out.println("\n1. Добавление продукта в корзину");
        basket1.addProduct(product1);
        basket1.printBasket();

        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);

        basket1.printBasket();

        System.out.println("\n2. Добавление продукта в заполненную корзину, в которой нет свободного места");
        basket1.addProduct(product6);

        System.out.println("\n3. Печать содержимого корзины с несколькими товарами");
        basket1.printBasketWithoutCost();

        System.out.println("\n4. Получение стоимости корзины с несколькими товарами");
        basket1.printTotalCostOfBasket();

        System.out.println("\n5. Поиск товара, который есть в корзине");
        String checkingProduct = "Хлеб"; // Указать название продукта
        basket1.printCheckingProductAvailable(checkingProduct);

        System.out.println("\n6. Поиск товара, которого нет в корзине");
        checkingProduct = "Селёдка"; // Указать название продукта
        basket1.printCheckingProductAvailable(checkingProduct);

        System.out.println("\n7. Очистка корзины");
        basket1.clearBasket();

        System.out.println("\n8. Печать содержимого пустой корзины");
        basket1.printBasketWithoutCost();

        System.out.println("\n9. Получение стоимости пустой корзины");
        basket1.printTotalCostOfBasket();

        System.out.println("\n10. Поиск товара по имени в пустой корзине.");
        checkingProduct = "Хлеб"; // Указать название продукта
        basket1.printCheckingProductAvailable(checkingProduct);

        basket1.printBasket();

    }
}
