package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

 public class ProductBasket {
    private final Product[] products ;
    private int size ;

    public ProductBasket() {
        this.products = new Product[5];
        this.size = 0;
    }


     public void addProduct(Product product){
        if(size<products.length){
            products[size]=product;
            size++;
        } else {
            System.out.println("Для этого продукта нет места.");
        }
    }
    public int totalCostOfBasket(){

        int totalCost = 0;
        for (Product product:products){
            if (product!=null) {
                totalCost += product.getCostOfProduct();
            }
        } return totalCost;
    }

    public void printBasket(){
        if (size ==0){
            System.out.println(" В корзине пусто.");
            return;
        }
        System.out.println(" Сейчас в корзине: " );
        for (int i = 0; i<size; i++){
           Product product =products[i];
            System.out.println(product);
        }
        System.out.println("Итого: <"+totalCostOfBasket()+" руб.>");
    }

    public boolean checkingProductAvailable(String name){
        for (int i = 0; i<size; i++){
            if (products[i].getProductName().equals(name)){
                return true;
            }
        } return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }
}
