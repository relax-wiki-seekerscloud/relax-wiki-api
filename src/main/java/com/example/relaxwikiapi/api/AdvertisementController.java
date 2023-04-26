package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.service.AdvertisementService;
import com.example.relaxwikiapi.service.FileStorageService;
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
public class AdvertisementController {
    /*Autowire the necessary services*/
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private AdvertisementService service;

    // Add a new advertisement-column to the table
    @PostMapping("/advertisement")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        return service.saveAdvertisement(advertisement);
    }

    // Update an existing advertisement
    @PutMapping("/advertisement")
    public Advertisement updateAdvertisement(@RequestBody Advertisement advertisement) {
        return service.updateAdvertisement(advertisement);
    }

    // delete advertisement by ID
    @DeleteMapping("/advertisement/{id}")
    public String deleteAdvertisement(@PathVariable int id) {
        return service.deleteAdvertisement(id);
    }

    // get all advertisements
    @GetMapping("/advertisement")
    public List<Advertisement> findAllAdvertisement() {
        return service.getAdvertisements();
    }

    // Upload an image file for an advertisement
    @PostMapping("/file/upload")
    public String addImage(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        String fileName = fileStorageService.storeFile(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(fileName)
                .toUriString();
        Advertisement advertisement = service.getAdvertisementById(id);
        advertisement.setResourceUrl(fileName);
        service.updateAdvertisement(advertisement);
        return url;
    }

    // Download an image file for an advertisement by ID
    @GetMapping("/file/download/{id}")
    public ResponseEntity<Resource> downloadSingleFile(@PathVariable int id) {
        Advertisement advertisement = service.getAdvertisementById(id);
        Resource resource = fileStorageService.downloadFile(advertisement.getResourceUrl());
        MediaType contentType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok()
                .contentType(contentType)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename())
                .body(resource);
    }
}
