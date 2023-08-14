package com.developer.distribusi.service.impl;

import com.developer.distribusi.DTO.DistribusiDTO;
import com.developer.distribusi.DTO.ProductDTO;
import com.developer.distribusi.DTO.ResponseDTO;
import com.developer.distribusi.entity.DistribusiEntity;
import com.developer.distribusi.repository.DistribusiRepository;
import com.developer.distribusi.service.DistribusiService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DistribusiServiceImpl implements DistribusiService {

    @Autowired
    private DistribusiRepository distribusiRepository;
        @Autowired
        private ModelMapper modelMapper;
        @Autowired
        private RestTemplate restTemplate;


    @Override
    public List<DistribusiEntity> findAllDistribusi() {
        return distribusiRepository.findAll();
    }

    @Cacheable("productCache")
    @Override
    public ResponseDTO findById(Long id) {
        ResponseDTO responseDto = new ResponseDTO();
        DistribusiEntity distribusiEntity = distribusiRepository.findById(id).get();
        DistribusiDTO distribusiDTO = dtoToDistribusi(distribusiEntity);

        ResponseEntity<ProductDTO> responseEntity = restTemplate
                .getForEntity("http://product-service/produk/" + distribusiEntity.getProdukId(),
                        ProductDTO.class);

        ProductDTO productDTO = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setDistribusi(distribusiDTO);
        responseDto.setProduct(productDTO);

        return responseDto;
    }
    @Override
    public DistribusiEntity saveDistribusi(DistribusiEntity distribusiEntity) {
        return distribusiRepository.save(distribusiEntity);
    }

    @Override
    public DistribusiEntity updateDistribusi(DistribusiEntity distribusiEntity) {
        return distribusiRepository.save(distribusiEntity);
    }

    @CacheEvict(value = "productCache")
    @Override
    public void deleteDistribusi(Long id) {
        distribusiRepository.deleteById(id);
    }


    // Model Mapper DTO Distribusi
    private DistribusiDTO dtoToDistribusi(DistribusiEntity distribusiEntity){
        return this.modelMapper.map(distribusiEntity, DistribusiDTO.class);
    }


}

