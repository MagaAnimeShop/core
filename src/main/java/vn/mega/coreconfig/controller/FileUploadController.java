package vn.mega.coreconfig.controller;

import java.io.IOException;
import java.util.List;

import vn.mega.coreconfig.entities.Image;
import vn.mega.coreconfig.repository.ImageRepository;
import vn.mega.coreconfig.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
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
