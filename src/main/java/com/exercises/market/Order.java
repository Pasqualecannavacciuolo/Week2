package com.exercises.market;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Order {
    private int idOrder, idClient;
}
