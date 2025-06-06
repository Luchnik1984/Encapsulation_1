package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exeptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("яблоки", 150);
        SimpleProduct product2 = new SimpleProduct("бананы", 100);
        SimpleProduct product3 = new SimpleProduct("Хлеб", 70);
        DiscountedProduct product4 = new DiscountedProduct("колбаса", 800, 20);
        FixPriceProduct product5 = new FixPriceProduct("яйца");
        FixPriceProduct product6 = new FixPriceProduct("молоко");

        ProductBasket basket1 = new ProductBasket(); // Создаём корзину
        System.out.println("\n1. Добавление продукта в корзину:");
        basket1.addProduct(product1);
        basket1.printBasket();

        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);

        basket1.printBasket();

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

        System.out.println("\nПроверка введённых изменений.");
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(product6);

        basket1.printBasket();

        System.out.println("\nДобавление статей и поиска. Тестирование поискового движка ");

        SearchEngine searchProduct = new SearchEngine();
        searchProduct.add(product1);
        searchProduct.add(product3);
        searchProduct.add(product4);

        Article article1 = new Article("Яблоки сорта Гольден",
                "Жёлтые яблоки с мягким, сладким вкусом и сочной текстурой");
        Article article4 = new Article("Колбаса - Салями Миланская",
                "Салями Миланская - отличный вариант для сервировки мясной нарезки праздничного стола");

        searchProduct.add(article1);
        searchProduct.add(article4);

        System.out.println("\n<<< Демонстрация метода search >>>");
        System.out.println("\n<<< Результат поиска по запросу 'яблоки' >>>");

        Set<Searchable> searchResult1 = searchProduct.search("яблоки");
        searchProduct.printResults(searchResult1);

        System.out.println("\n<<< Результат поиска по запросу 'колбаса' >>>");
        Set<Searchable> searchResult2 = searchProduct.search("колбаса");
        searchProduct.printResults(searchResult2);

        System.out.println("\n<<< Результат поиска по запросу 'хлеб' >>>");
        Set<Searchable> searchResult3 = searchProduct.search("хлеб");
        searchProduct.printResults(searchResult3);

        System.out.println("\n Проверка полей товаров: ");

        try {
            Product incorrectProduct1 = new SimpleProduct("", 300);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product incorrectProduct2 = new SimpleProduct("Кефир", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product incorrectProduct3 = new DiscountedProduct("   ", 10, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product incorrectProduct4 = new DiscountedProduct("Краковская колбаса", 7000, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());

        }

        System.out.println("""
                
                <<< Демонстрация метода удаления продукта по имени из корзины >>>\
                
                Создаём новую корзину и заполняем её тестовыми продуктами:""");
        ProductBasket basket3 = new ProductBasket();
        basket3.addProduct(product1);
        basket3.addProduct(product2);
        basket3.addProduct(product3);
        basket3.addProduct(product4);
        basket3.addProduct(product5);
        basket3.addProduct(product6);
        basket3.addProduct(product4);
        basket3.printBasket();
        System.out.println("\n<<<Удаляем существующий продукт>>>");
        Set<Product> removedProducts1 = basket3.removedProductsByName("колбаса");

        System.out.println("\n<<<Выводим удалённый продукт>>>");
        basket3.printRemovedProducts(removedProducts1);

        System.out.println("\n<<<Выводим содержимое корзины>>>");
        basket3.printBasket();

        System.out.println("\n<<<Удаляем несуществующий продукт>>>");
        Set<Product> removedProducts2 = basket3.removedProductsByName("горох");

        System.out.println("\n<<<Выводим удалённый продукт. Проверка что список пуст>>>");
        basket3.printRemovedProducts(removedProducts2);

        System.out.println("\n<<<Выводим содержимое корзины>>>");
        basket3.printBasket();

        System.out.println("\n<<<Реализация метода поиска самого подходящего элемента>>>");
        System.out.println("\n <<<Добавляем объекты в поисковый движок>>>");

        try {
            SearchEngine searchEngine2 = new SearchEngine();
            searchEngine2.add(product1);
            searchEngine2.add(product2);
            searchEngine2.add(product3);
            searchEngine2.add(article1);
            searchEngine2.add(article4);
            searchEngine2.add(product6);
            searchEngine2.add(product6);

            System.out.println(" \nКогда нужный объект существует: ");
            Searchable bestResult1 = searchEngine2.findBestSearchResult("яблок");
            System.out.println(bestResult1);

            System.out.println(" \nКогда метод выбрасывает исключение: ");
            Searchable bestResult2 = searchEngine2.findBestSearchResult("яблонь");
            System.out.println(bestResult2);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}