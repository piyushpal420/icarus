package com.ganache.icarus.Controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class ImageController
{
    @GetMapping("get-image")
    public ResponseEntity<?> getImage() throws MalformedURLException {
        Path image = Paths.get("src/main/resources/static/").resolve("hello.png").normalize();
        Resource imageFile = new UrlResource(image.toUri());
        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageFile.getFilename() + "\"")
                .body(imageFile);
    }

    @GetMapping("get-video")
    public ResponseEntity<?> getVideo() throws IOException {
        String p = "C:\\Users\\Piyush Pal\\Videos\\God of War\\God of War 2022.12.15 - 00.12.20.01.mp4";
        Path vidPath = Paths.get(p).normalize();
        Resource vidFile = new UrlResource(vidPath.toUri());
        if (!vidFile.exists()) {
            return ResponseEntity.notFound().build();
        }
        String contentType = Files.probeContentType(vidPath);
        if (contentType == null) {
            contentType = "video/mp4"; // Default to video/mp4 for .mp4 files
        }
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.parseMediaType(contentType)) // Dynamically set MIME type
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + vidFile.getFilename() + "\"")
                .body(vidFile);
    }
}
