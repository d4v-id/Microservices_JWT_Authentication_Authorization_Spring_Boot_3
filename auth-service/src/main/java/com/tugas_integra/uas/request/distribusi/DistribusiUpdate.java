package com.tugas_integra.uas.request.distribusi;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistribusiUpdate {
    private Long Id;
    private String tanggalDistribusi;
    private String tujuanDistribusi;
    private String metodePengiriman;
    private String catatan;
    private String produkId;
    private String jumlah;
}
