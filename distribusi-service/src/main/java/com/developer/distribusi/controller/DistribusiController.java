package com.developer.distribusi.controller;


import com.developer.distribusi.DTO.ResponseDTO;
import com.developer.distribusi.entity.DistribusiEntity;
import com.developer.distribusi.service.DistribusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/distribusi")
public class DistribusiController {

    @Autowired
    private  DistribusiService distribusiService;

    @GetMapping
    public List<DistribusiEntity> findAllDistribusi() {
        return distribusiService.findAllDistribusi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findDistribusiById(@PathVariable("id") Long id) {
        ResponseDTO responseDTO = distribusiService.findById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<DistribusiEntity> saveDistribusi(@RequestBody DistribusiEntity distribusiEntity) {
        DistribusiEntity savedDistribusi =  distribusiService.saveDistribusi(distribusiEntity);
        return new ResponseEntity<>(savedDistribusi, HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public DistribusiEntity updateDistribusi(@RequestBody DistribusiEntity distribusiEntity) {
        return distribusiService.updateDistribusi(distribusiEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteDistribusi(@PathVariable("id") Long id) {
        distribusiService.deleteDistribusi(id);
    }
}
