package com.upside.thing.Services;

import com.upside.thing.Entity.GudangEntity;

import java.util.List;
import java.util.Optional;

public interface GudangServ {
    List<GudangEntity> findAllGdng();
    Optional<GudangEntity> findById(Long id);
    GudangEntity saveGdng (GudangEntity gudangEntity);
    GudangEntity updtGdng (GudangEntity gudangEntity);
    void hapusGdng (Long id);


}
