package com.example.restApi;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class Items {
    private int responseCode;
    @Getter
    private List<Product> products;


}
