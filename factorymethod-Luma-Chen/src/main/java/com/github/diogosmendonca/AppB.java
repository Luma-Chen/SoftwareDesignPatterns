package com.github.diogosmendonca;

public class AppB extends App {

    Product productB;

    public Product newProduct() {
        Product productB = new ProductB();
        this.productB = productB;
        return productB;
    }

}