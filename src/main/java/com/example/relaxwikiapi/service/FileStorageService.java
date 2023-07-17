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
import java.util.Objects;
import java.util.Random;

@Service
public class FileStorageService {

    // File storage path
    Path fileStoragePath;

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
    public String storeFile(MultipartFile file, String folder) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileExtension = StringUtils.getFilenameExtension(fileName);
        String newFileName = generateUniqueFileName() + "_" + generateRandomLetters() + "." + fileExtension;

        Path filePath = Paths.get(fileStoragePath + "\\" + folder + "\\"+ newFileName);
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newFileName;
    }

    // Method to download the file and return it as a Resource object
    public Resource downloadFile(String fileName,String folder) {
        String fileStorageLocation = "files";
        Path path = Paths.get(fileStorageLocation +"\\" + folder ).toAbsolutePath().resolve(fileName);
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

    private String generateUniqueFileName() {
        long timestamp = System.currentTimeMillis();
        return String.valueOf(timestamp);
    }

    private String generateRandomLetters() {
        StringBuilder builder = new StringBuilder(4);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            builder.append(randomChar);
        }
        return builder.toString();
    }
}
