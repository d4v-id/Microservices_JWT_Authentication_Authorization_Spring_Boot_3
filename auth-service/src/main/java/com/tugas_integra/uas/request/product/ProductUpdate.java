package com.tugas_integra.uas.request.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdate {
    private Long Id;
    private String name;
    private String stock;
    private String description;
    private String price;
}
