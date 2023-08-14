package com.tugas_integra.uas.request.gudang;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GudangRequest {
    private String nama_gudang;
    private String alamat_gudang;
    private int kapasitas_gudang;
    private String kontak_gedung;
}
