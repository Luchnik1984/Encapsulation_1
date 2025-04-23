package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main (String[] args){
        Product product1 = new Product("яблоки",150);
        Product product2 = new Product("бананы",100);
        Product product3 = new Product("Хлеб", 70);
        Product product4 = new Product("колбаса", 800);
        Product product5 = new Product("яйца", 195);
        Product product6 = new Product("молоко", 120);

        ProductBasket basket1= new ProductBasket(); // Создаём корзину
        basket1.printBasket();
        System.out.println("1. Добавление продукта в корзину");
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);

        basket1.printBasket();

        basket1.addProduct(product1);
        basket1.printBasket();


    }
}
