package com.tugas_integra.uas.request.karyawan;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KaryawanUpdate {
    private Long Id;
    private String name;
    private String alamat;
    private String jabatan;
}
