package com.ecomos.coreconfig.service;

import com.ecomos.coreconfig.entities.Image;
import com.ecomos.coreconfig.repository.ImageRepository;
import com.ecomos.coreconfig.repository.PropertyRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service
public class ImageService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ImageRepository imageRepository;

    public Image uploadFile(MultipartFile multipartFile) throws IOException {
        String urlUpload = propertyRepository.findByKey("url.upload.file").getValue();
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("fileUpload", new ByteArrayResource(multipartFile.getBytes()) {
            @Override
            public String getFilename() {
                return multipartFile.getOriginalFilename();
            }
        });

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(urlUpload, requestEntity, String.class);

        Map urlImage = new Gson().fromJson(response.getBody(), Map.class);
        Image image = Image.builder()
                .imageUrl((String) urlImage.get("url"))
                .imageName((String) urlImage.get("filename"))
                .build();
        imageRepository.save(image);
        return image;
    }


}
