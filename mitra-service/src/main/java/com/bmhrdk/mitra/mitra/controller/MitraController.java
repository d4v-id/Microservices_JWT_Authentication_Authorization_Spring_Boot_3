package com.bmhrdk.mitra.mitra.controller;

import com.bmhrdk.mitra.mitra.model.MitraEntity;
import com.bmhrdk.mitra.mitra.service.MitraService;
import com.bmhrdk.mitra.mitra.service.impl.MitraServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/mitra")
public class MitraController {

    private final MitraService mitraService;

    public MitraController(MitraServiceImpl mitraServiceImpl) {
        this.mitraService = mitraServiceImpl;
    }
    @GetMapping
    public List<MitraEntity> findAllMitra() {
        return mitraService.findAllMitra();
    }
    @GetMapping("/{id}")
    public Optional<MitraEntity> findMitraById(@PathVariable("id") Long id){
        return mitraService.findById(id);
    }
    @PostMapping
    public MitraEntity saveMitra(@RequestBody MitraEntity mitraEntity){
        return mitraService.saveMitra(mitraEntity);
    }
    @PutMapping
    public MitraEntity updateMitra(@RequestBody MitraEntity mitraEntity){
        return mitraService.updateMitra(mitraEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteMitra(@PathVariable("id")Long id){
        mitraService.deleteMitra(id);
    }

}
