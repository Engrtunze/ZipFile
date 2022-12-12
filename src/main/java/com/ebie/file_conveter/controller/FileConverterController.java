package com.ebie.file_conveter.controller;

import com.ebie.file_conveter.service.FileConverter;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/compress")
@RequiredArgsConstructor
@Slf4j
public class FileConverterController {
    private final FileConverter fileConverter;
    @PostMapping()
    public ResponseEntity compressFile(@RequestParam MultipartFile filePath, @Nullable @RequestParam String fileName) throws IOException {
       var resource = fileConverter.compressFile(filePath, fileName );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body("resource zipped");




    }


}
