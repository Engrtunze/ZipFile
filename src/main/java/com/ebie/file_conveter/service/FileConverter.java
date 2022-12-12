package com.ebie.file_conveter.service;


import jakarta.annotation.Nullable;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileConverter {
    //ResponseEntity<Resource> compressFile(MultipartFile file) throws IOException;
    Resource compressFile(MultipartFile file, @Nullable String fileName) throws IOException;
}
