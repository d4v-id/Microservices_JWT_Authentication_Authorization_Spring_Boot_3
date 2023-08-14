package com.upside.thing.Controller;

import com.upside.thing.Entity.GudangEntity;
import com.upside.thing.Services.GudangServ;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/gudang")
public class GudangController {


    private final GudangServ gudangServ;

    public GudangController(GudangServ gudangServ) {
        this.gudangServ = gudangServ;
    }

    @GetMapping
    public List<GudangEntity> findAllGdng(){
        return gudangServ.findAllGdng();
    }

    @GetMapping("/{id}")
    public Optional<GudangEntity> findGdngById(@PathVariable("id")Long id){
        return gudangServ.findById(id);
    }
    @PostMapping
    public GudangEntity saveGdng(@RequestBody GudangEntity gudangEntity){
        return gudangServ.saveGdng(gudangEntity);
    }
    @PutMapping
    public GudangEntity updateGdng(@RequestBody GudangEntity gudangEntity){
        return gudangServ.updtGdng(gudangEntity);

    }
    @DeleteMapping("/{id}")
    public  void  hapusGdng(@PathVariable("id")Long id ){
        gudangServ.hapusGdng(id);
    }

}
