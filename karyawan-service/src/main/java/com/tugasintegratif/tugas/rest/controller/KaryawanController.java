package com.tugasintegratif.tugas.rest.controller;

import com.tugasintegratif.tugas.rest.models.KaryawanEntity;
import com.tugasintegratif.tugas.rest.service.KaryawanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

    private final KaryawanService karyawanService;
    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    @GetMapping
    public List<KaryawanEntity> findAllKaryawan(){
        return karyawanService.findAllKaryawan();

    }

    @GetMapping("/{id}")
    public Optional<KaryawanEntity> findKaryawanById(@PathVariable("id")Long id){
        return karyawanService.findById(id);

    }

    @PostMapping
    public KaryawanEntity saveKaryawan (@RequestBody KaryawanEntity karyawanEntity){
        return karyawanService.saveKaryawan(karyawanEntity);
    }

    @PutMapping
    public KaryawanEntity updateKaryawan (@RequestBody KaryawanEntity karyawanEntity){
        return karyawanService.updateKaryawan(karyawanEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteKaryawan(@PathVariable("id")Long id) {
        karyawanService.deleteKaryawan(id);
    }
}
