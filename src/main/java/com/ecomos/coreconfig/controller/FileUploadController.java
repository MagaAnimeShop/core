package com.ecomos.coreconfig.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ecomos.coreconfig.entities.Image;
import com.ecomos.coreconfig.entities.Property;
import com.ecomos.coreconfig.repository.ImageRepository;
import com.ecomos.coreconfig.service.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;


    @PostMapping("/upload")
    public ResponseEntity<Image> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        Image image = imageService.uploadFile(file);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @GetMapping
    public List<Image> getAllImage() {
        return imageRepository.findAll();
    }


}
