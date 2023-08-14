package com.developer.distribusi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DistribusiDTO {
    private Long Id;
    private String tanggalDistribusi;
    private String tujuanDistribusi;
    private String metodePengiriman;
    private String catatan;

}
