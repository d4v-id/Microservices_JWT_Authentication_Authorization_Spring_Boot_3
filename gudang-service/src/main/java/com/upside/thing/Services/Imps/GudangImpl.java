package com.upside.thing.Services.Imps;

import com.upside.thing.Entity.GudangEntity;
import com.upside.thing.Reps.GudangRepository;
import com.upside.thing.Services.GudangServ;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GudangImpl implements GudangServ {

    private final GudangRepository gudangRepository;

    public GudangImpl(GudangRepository gudangRepository) {
        this.gudangRepository = gudangRepository;
    }

    @Override
    public List<GudangEntity> findAllGdng() {
        return gudangRepository.findAll();
    }

    @Override
    public Optional<GudangEntity> findById(Long id) {
        return gudangRepository.findById(id);
    }

    @Override
    public GudangEntity saveGdng(GudangEntity gudangEntity) {
        return gudangRepository.save(gudangEntity);
    }

    @Override
    public GudangEntity updtGdng(GudangEntity gudangEntity) {
        return gudangRepository.save(gudangEntity);
    }

    @Override
    public void hapusGdng(Long id) {
        gudangRepository.deleteById(id);

    }
}
