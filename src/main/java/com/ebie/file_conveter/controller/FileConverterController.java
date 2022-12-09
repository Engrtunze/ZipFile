package com.ebie.file_conveter.controller;

import com.ebie.file_conveter.service.FileConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/compress")
@RequiredArgsConstructor
@Slf4j
public class FileConverterController {
    private final FileConverter fileConverter;
    @PostMapping()
    public ResponseEntity<String> compressFile(@RequestBody File filePath, @RequestBody String fileName) throws IOException {
        return ResponseEntity.ok(fileConverter.compressFile(filePath));
    }


}
