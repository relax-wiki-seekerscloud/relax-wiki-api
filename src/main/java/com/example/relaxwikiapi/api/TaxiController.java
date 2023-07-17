package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.entity.Taxi;
import com.example.relaxwikiapi.service.AdvertisementService;
import com.example.relaxwikiapi.service.FileStorageService;
import com.example.relaxwikiapi.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
@RestController
public class TaxiController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private TaxiService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/taxi")
    public Taxi addTaxi(@RequestBody Taxi taxi) {
        System.out.println(taxi);
        return service.saveTaxi(taxi);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/taxi")
    public Taxi updateTaxi(@RequestBody Taxi taxi) {
        return service.updateTaxi(taxi);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/taxi/{id}")
    public String deleteTaxi(@PathVariable int id) {
        return service.deleteTaxi(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/taxi")
    public List<Taxi> findAllTaxi() {
        return service.getTaxis();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/taxi-by-category/{id}")
    public List<Taxi> findAllTaxiByCategory(@PathVariable int id) {
        return service.getTaxiByCategory(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/taxi-by-id/{id}")
    public Taxi findAllTaxiById(@PathVariable int id) {
        return service.getTaxiById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/taxi/upload")
    public String addImage(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        String fileName = fileStorageService.storeFile(file ,"taxi");
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/taxi/")
                .path(fileName)
                .toUriString();
        Taxi taxi = service.getTaxiById(id);
        taxi.setImage(fileName);
        service.updateTaxi(taxi);
        return url;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/files/taxi/{name}")
    public ResponseEntity<Resource> downloadSingleFile(@PathVariable String name) {
        Resource resource = fileStorageService.downloadFile(name, "taxi");
        MediaType contentType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok()
                .contentType(contentType)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename())
                .body(resource);
    }
}
