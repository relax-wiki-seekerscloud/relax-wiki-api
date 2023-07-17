package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.service.AdvertisementService;
import com.example.relaxwikiapi.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/advertisement")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        System.out.println(advertisement);
        return service.saveAdvertisement(advertisement);

    }

    // Update an existing advertisement
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/advertisement")
    public Advertisement updateAdvertisement(@RequestBody Advertisement advertisement) {
        return service.updateAdvertisement(advertisement);
    }

    // delete advertisement by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/advertisement/{id}")
    public String deleteAdvertisement(@PathVariable int id) {
        return service.deleteAdvertisement(id);
    }

    // get all advertisements
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/advertisement")
    public List<Advertisement> findAllAdvertisement() {
        return service.getAdvertisements();
    }

    // Upload an image file for an advertisement
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/advertisement/upload")
    public ResponseEntity<String> addImage(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        String fileName = fileStorageService.storeFile(file,"advertisement");
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/advertisement/")
                .path(fileName)
                .toUriString();
        Advertisement advertisement = service.getAdvertisementById(id);
        advertisement.setResourceUrl(fileName);
        service.updateAdvertisement(advertisement);
        String jsonResponse = "{\"url\": \"" + url + "\"}";

        // Return the JSON response with a success status code
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    // Download an image file for an advertisement by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/files/advertisement/{name}")
    public ResponseEntity<Resource> downloadSingleFile(@PathVariable String name) {
        Resource resource = fileStorageService.downloadFile(name, "advertisement");
        MediaType contentType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok()
                .contentType(contentType)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename())
                .body(resource);
    }
}
