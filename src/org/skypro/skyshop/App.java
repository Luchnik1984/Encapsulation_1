package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;



public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("яблоки", 150);
        SimpleProduct product2 = new SimpleProduct("бананы", 100);
        SimpleProduct product3 = new SimpleProduct("Хлеб", 70);
        DiscountedProduct product4 = new DiscountedProduct("колбаса", 800, 20);
        FixPriceProduct product5 = new FixPriceProduct("яйца");
        FixPriceProduct product6 = new FixPriceProduct("молоко");

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

        System.out.println("\n ДЗ_3. Проверка введённых изменений.");
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(product6);

        basket1.printBasket();


        System.out.println("\n  ДЗ_4. Добавление статей и поиска. Проверка введённых изменений ");

        SearchEngine searchProduct = new SearchEngine(5);
        searchProduct.add(product1);
        searchProduct.add(product3);
        searchProduct.add(product4);

        Article article1 = new Article("Яблоки сорта Гольден",
                "Жёлтые яблоки с мягким, сладким вкусом и сочной текстурой");
        Article article4 = new Article("Колбаса - Салями Миланская",
                "Салями Миланская - отличный вариант для сервировки мясной нарезки праздничного стола");

        searchProduct.add(article1);
        searchProduct.add(article4);

        System.out.println("\n<<< Результат поиска по запросу 'яблоки' >>>");
        Searchable[] result1 = searchProduct.search("яблоки");
        searchProduct.printResults(result1);

        System.out.println("\n<<< Результат поиска по запросу 'колбаса' >>>");
        Searchable[] result2 = searchProduct.search("колбаса");
        searchProduct.printResults(result2);

        System.out.println("\n<<< Результат поиска по запросу 'хлеб' >>>");
        Searchable[] result3 = searchProduct.search("хлеб");
        searchProduct.printResults(result3);


    }
}
