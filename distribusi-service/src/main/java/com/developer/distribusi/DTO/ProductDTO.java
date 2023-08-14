package com.developer.distribusi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long Id;
    private String Name;
    private String Stock;
    private String Description;
    private String Price;
//    private String gudangId;
}
