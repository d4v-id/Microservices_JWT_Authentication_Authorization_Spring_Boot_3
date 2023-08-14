package com.upside.thing.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "db_Gudang")

public class GudangEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_gudang")
    private Long gudang_id;
    @Column(name = "nama")
    private String nama_gudang;
    @Column(name = "alamat")
    private String alamat_gudang;

    @Column(name = "kapasitas")
    private int kapasitas_gudang;
    @Column(name = "kontak")
    private String kontak_gedung;

    public GudangEntity(Long gudang_id, String nama_gudang, String alamat_gudang, int kapasitas_gudang, String kontak_gedung) {
        this.gudang_id = gudang_id;
        this.nama_gudang = nama_gudang;
        this.alamat_gudang = alamat_gudang;
        this.kapasitas_gudang = kapasitas_gudang;
        this.kontak_gedung = kontak_gedung;
    }



    public GudangEntity() {
    }
    public Long getGudang_id() {
        return gudang_id;
    }

    public void setGudang_id(Long gudang_id) {
        this.gudang_id = gudang_id;
    }

    public String getNama_gudang() {
        return nama_gudang;
    }

    public void setNama_gudang(String nama_gudang) {
        this.nama_gudang = nama_gudang;
    }

    public String getAlamat_gudang() {
        return alamat_gudang;
    }

    public void setAlamat_gudang(String alamat_gudang) {
        this.alamat_gudang = alamat_gudang;
    }

    public int getKapasitas_gudang() {
        return kapasitas_gudang;
    }

    public void setKapasitas_gudang(int kapasitas_gudang) {
        this.kapasitas_gudang = kapasitas_gudang;
    }

    public String getKontak_gedung() {
        return kontak_gedung;
    }

    public void setKontak_gedung(String kontak_gedung) {
        this.kontak_gedung = kontak_gedung;
    }






}