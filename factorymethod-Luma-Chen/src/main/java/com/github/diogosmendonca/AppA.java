package com.github.diogosmendonca;

public class AppA extends App {

    Product productA;

    public Product newProduct() {
        Product productA = new ProductA();
        this.productA = productA;
        return productA;
      }
}