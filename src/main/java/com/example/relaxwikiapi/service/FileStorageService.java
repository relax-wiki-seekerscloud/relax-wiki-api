//file storage services to store and download files
package com.example.relaxwikiapi.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    // File storage path
    Path fileStoragePath;
    private String fileStorageLocation = "files";

    // Constructor for creating the file storage directory
    public FileStorageService() {
        fileStoragePath = Paths.get(Path.of("files").toUri()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Method to store the file in the directory and return the filename
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = Paths.get(fileStoragePath + "\\" + fileName);
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    // Method to download the file and return it as a Resource object
    public Resource downloadFile(String fileName) {
        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(fileName);
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // Check if the file exists and is readable, and return it as a Resource object
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("Error in file downloading");
        }
    }
}
