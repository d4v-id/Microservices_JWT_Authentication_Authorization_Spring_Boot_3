package com.tugas_integra.uas.client;

import com.tugas_integra.uas.request.distribusi.DistribusiRequest;
import com.tugas_integra.uas.request.distribusi.DistribusiUpdate;
import com.tugas_integra.uas.request.gudang.GudangRequest;
import com.tugas_integra.uas.request.gudang.GudangUpdate;
import com.tugas_integra.uas.request.karyawan.KaryawanRequest;
import com.tugas_integra.uas.request.karyawan.KaryawanUpdate;
import com.tugas_integra.uas.request.mitra.MitraRequest;
import com.tugas_integra.uas.request.mitra.MitraUpdate;
import com.tugas_integra.uas.request.product.ProductRequest;
import com.tugas_integra.uas.request.product.ProductUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class ServiceController {
    @Autowired
    private RestTemplate restTemplate;

//    KARYAWAN
    @GetMapping("/karyawan/all")
    @PreAuthorize( "hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getKaryawanAll() {
        String karyawanEndpoint = "http://karyawan-service/karyawan";
        ResponseEntity<String> response = restTemplate.getForEntity(
                karyawanEndpoint,
                String.class);
        return response;
    }

    @GetMapping("/karyawan/{Id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getDetailKaryawan(@PathVariable String Id) {
        String karyawanEndpoint = "http://karyawan-service/karyawan/" + Id;
        ResponseEntity<String> response = restTemplate.getForEntity(
                karyawanEndpoint,
                String.class);
        return response;
    }

    @PostMapping("/karyawan/add")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<String> createKaryawan(@RequestBody KaryawanRequest karyawanRequest) {
        String karyawanEndpoint = "http://karyawan-service/karyawan";
        ResponseEntity<String> response = restTemplate.exchange(
                karyawanEndpoint,
                HttpMethod.POST,
                new HttpEntity<>(karyawanRequest),
                String.class
        );
        return response;
    }

    @PutMapping("/karyawan/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateKaryawan(@RequestBody KaryawanUpdate karyawanUpdate) {
        String karyawanEndpoint = "http://karyawan-service/karyawan";
        ResponseEntity<String> response = restTemplate.exchange(
                karyawanEndpoint,
                HttpMethod.PUT,
                new HttpEntity<>(karyawanUpdate),
                String.class
        );
        return response;
    }

    @DeleteMapping("/karyawan/delete/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteKaryawan(@PathVariable String Id) {
        String karyawanEndpoint = "http://karyawan-service/karyawan/" + Id;
        ResponseEntity<String> response = restTemplate.exchange(
                karyawanEndpoint,
                HttpMethod.DELETE,
                null,
                String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Karayawan Deleted");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

//    MITRA

    @GetMapping("/mitra/all")
    @PreAuthorize( "hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getMitraAll() {
        String gudangEndpoint = "http://mitra-service/mitra";
        ResponseEntity<String> response = restTemplate.getForEntity(
                gudangEndpoint,
                String.class);
        return response;
    }

    @GetMapping("/mitra/{Id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getMitraProduct(@PathVariable String Id) {
        String mitraEndpoint = "http://mitra-service/mitra/" + Id;
        ResponseEntity<String> response = restTemplate.getForEntity(
                mitraEndpoint,
                String.class);
        return response;
    }

    @PostMapping("/mitra/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createMitra(@RequestBody MitraRequest mitraRequest) {
        String mitraEndpoint = "http://mitra-service/mitra";
        ResponseEntity<String> response = restTemplate.exchange(
                mitraEndpoint,
                HttpMethod.POST,
                new HttpEntity<>(mitraRequest),
                String.class
        );
        return response;
    }

    @PutMapping("/mitra/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateMitra(@RequestBody MitraUpdate mitraUpdate) {
        String mitraEndpoint = "http://mitra-service/mitra";
        ResponseEntity<String> response = restTemplate.exchange(
                mitraEndpoint,
                HttpMethod.PUT,
                new HttpEntity<>(mitraUpdate),
                String.class
        );
        return response;
    }

    @DeleteMapping("/mitra/delete/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteMitra(@PathVariable String Id) {
        String mitraEndpoint = "http://mitra-service/mitra/" + Id;
        ResponseEntity<String> response = restTemplate.exchange(
                mitraEndpoint,
                HttpMethod.DELETE,
                null,
                String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Mitra Deleted");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

//    PRODUCT

    @GetMapping("/product/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getProductAll() {
        String productEndpoint = "http://product-service/produk/all";
        ResponseEntity<String> response = restTemplate.getForEntity(
                productEndpoint,
                String.class);
        return response;
    }

    @GetMapping("/product/{productId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getDetailProduct(@PathVariable String productId) {
        String productEndpoint = "http://product-service/produk/" + productId;
        ResponseEntity<String> response = restTemplate.getForEntity(
                productEndpoint,
                String.class);
        return response;
    }

    @PostMapping("/product/add")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        String productEndpoint = "http://product-service/produk/";
        ResponseEntity<String> response = restTemplate.exchange(
                productEndpoint + "/add",
                HttpMethod.POST,
                new HttpEntity<>(productRequest),
                String.class
        );
        return response;
    }

    @PutMapping("/product/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateProduct(@RequestBody ProductUpdate productUpdate) {
        String productEndpoint = "http://product-service/produk/";
        ResponseEntity<String> response = restTemplate.exchange(
                productEndpoint + "/edit",
                HttpMethod.PUT,
                new HttpEntity<>(productUpdate),
                String.class
        );
        return response;
    }

    @DeleteMapping("/product/delete/{productId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        String productEndpoint = "http://product-service/produk/delete/" + productId;
        ResponseEntity<String> response = restTemplate.exchange(
                productEndpoint,
                HttpMethod.DELETE,
                null,
                String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Product Deleted");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

//    GUDANG

    @GetMapping("/gudang/all")
    @PreAuthorize( "hasRole('ADMIN')")
    public ResponseEntity<String> getGudangAll() {
        String gudangEndpoint = "http://gudang-service/gudang";
        ResponseEntity<String> response = restTemplate.getForEntity(
                gudangEndpoint,
                String.class);
        return response;
    }

    @GetMapping("/gudang/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getDetailGudang(@PathVariable String Id) {
        String gudangEndpoint = "http://gudang-service/gudang/" + Id;
        ResponseEntity<String> response = restTemplate.getForEntity(
                gudangEndpoint,
                String.class);
        return response;
    }

    @PostMapping("/gudang/add")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<String> createGudang(@RequestBody GudangRequest gudangRequest) {
        String gudangEndpoint = "http://gudang-service/gudang";
        ResponseEntity<String> response = restTemplate.exchange(
                gudangEndpoint,
                HttpMethod.POST,
                new HttpEntity<>(gudangRequest),
                String.class
        );
        return response;
    }

    @PutMapping("/gudang/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateGudang(@RequestBody GudangUpdate gudangUpdate) {
        String gudangEndpoint = "http://gudang-service/gudang";
        ResponseEntity<String> response = restTemplate.exchange(
                gudangEndpoint,
                HttpMethod.PUT,
                new HttpEntity<>(gudangUpdate),
                String.class
        );
        return response;
    }

    @DeleteMapping("/gudang/delete/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteGudang(@PathVariable String Id) {
        String gudangEndpoint = "http://gudang-service/gudang/" + Id;
        ResponseEntity<String> response = restTemplate.exchange(
                gudangEndpoint,
                HttpMethod.DELETE,
                null,
                String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Gudang Deleted");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

//    DISTRIBUSI

    @GetMapping("/distribusi/all")
    @PreAuthorize( "hasRole('ADMIN')")
    public ResponseEntity<String> getDistribusiAll() {
        String distribusiEndpoint = "http://distribusi-service/distribusi";
        ResponseEntity<String> response = restTemplate.getForEntity(
                distribusiEndpoint,
                String.class);
        return response;
    }

    @GetMapping("/distribusi/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getDetailDistribusi(@PathVariable String Id) {
        String distribusiEndpoint = "http://distribusi-service/distribusi/" + Id;
        ResponseEntity<String> response = restTemplate.getForEntity(
                distribusiEndpoint,
                String.class);
        return response;
    }

    @PostMapping("/distribusi/add")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<String> createDistribusi(@RequestBody DistribusiRequest distribusiRequest) {
        String distribusiEndpoint = "http://distribusi-service/distribusi/";
        ResponseEntity<String> response = restTemplate.exchange(
                distribusiEndpoint,
                HttpMethod.POST,
                new HttpEntity<>(distribusiRequest),
                String.class
        );
        return response;
    }

    @PutMapping("/distribusi/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateDistribusi(@RequestBody DistribusiUpdate distribusiUpdate) {
        String distribusiEndpoint = "http://distribusi-service/distribusi/";
        ResponseEntity<String> response = restTemplate.exchange(
                distribusiEndpoint,
                HttpMethod.PUT,
                new HttpEntity<>(distribusiUpdate),
                String.class
        );
        return response;
    }

    @DeleteMapping("/distribusi/delete/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteDistribusi(@PathVariable String Id) {
        String distribusiEndpoint = "http://distribusi-service/distribusi/" + Id;
        ResponseEntity<String> response = restTemplate.exchange(
                distribusiEndpoint,
                HttpMethod.DELETE,
                null,
                String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Distribution Deleted");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}
