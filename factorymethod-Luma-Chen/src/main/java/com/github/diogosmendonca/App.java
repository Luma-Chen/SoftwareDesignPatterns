package com.github.diogosmendonca;

public abstract class App{    
    public String specificOperation() {
        Product product = newProduct();
        return product.otherOperaion();
    }
  
    public abstract Product newProduct();
}