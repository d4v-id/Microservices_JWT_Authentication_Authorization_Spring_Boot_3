package com.tugasintegratif.tugas.rest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "db_karyawan")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KaryawanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_karyawan")
    private Long Id;
    @Column (name = "nama_karyawan")
    private String name;
    @Column (name = "alamat_karyawan")
    private String alamat;
    @Column(name = "jabatan_karyawan")
    private String jabatan;
}
