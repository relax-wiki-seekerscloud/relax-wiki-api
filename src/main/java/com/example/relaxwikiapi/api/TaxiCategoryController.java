package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.entity.TaxiCategory;
import com.example.relaxwikiapi.service.TaxiCategoryService;
import com.example.relaxwikiapi.service.FileStorageService;
import com.example.relaxwikiapi.service.TaxiCategoryService;
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
public class TaxiCategoryController {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private TaxiCategoryService service;

    // Add a new taxiCategory-column to the table
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/taxi-category")
    public TaxiCategory addTaxiCategory(@RequestBody TaxiCategory taxiCategory) {
        System.out.println(taxiCategory);
        return service.saveTaxiCategory(taxiCategory);
    }

    // Update an existing taxiCategory
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/taxi-category")
    public TaxiCategory updateTaxiCategory(@RequestBody TaxiCategory taxiCategory) {
        return service.updateTaxiCategory(taxiCategory);
    }

    // delete taxiCategory by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/taxi-category/{id}")
    public String deleteTaxiCategory(@PathVariable int id) {
        return service.deleteTaxiCategory(id);
    }

    // get all taxiCategorys
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/taxi-category")
    public List<TaxiCategory> findAllTaxiCategory() {
        return service.getTaxiCategories();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/taxi-category/{id}")
    public TaxiCategory findTaxiCategory(@PathVariable int id) {
        return service.getTaxiCategoryById(id);
    }

    // Upload an image file for an taxiCategory
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/taxi-category/upload")
    public String addImage(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        String fileName = fileStorageService.storeFile(file,"taxiCategory");
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/taxiCategory/")
                .path(fileName)
                .toUriString();
        TaxiCategory taxiCategory = service.getTaxiCategoryById(id);
        taxiCategory.setImage(fileName);
        service.updateTaxiCategory(taxiCategory);
        return url;
    }

    // Download an image file for an taxiCategory by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/files/taxiCategory/{name}")
    public ResponseEntity<Resource> downloadSingleFile(@PathVariable String name) {
        Resource resource = fileStorageService.downloadFile(name, "taxiCategory");
        MediaType contentType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok()
                .contentType(contentType)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename())
                .body(resource);
    }
}
