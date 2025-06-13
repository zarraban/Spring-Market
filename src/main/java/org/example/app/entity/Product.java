package org.example.app.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private int price;

    @Override
    public String toString(){
        return String.format("Product Id=%d, Name=%s, Price=%d",id,name,price);
    }
}
