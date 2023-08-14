package com.developer.distribusi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tbl_distribusi")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistribusiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String tanggalDistribusi;
    private String tujuanDistribusi;
    private String metodePengiriman;
    private String catatan;
    @Column(nullable = false, unique = true)
    private String produkId;
    private String jumlah;

}