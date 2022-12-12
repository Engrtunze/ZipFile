package com.ebie.file_conveter.service;


import jakarta.annotation.Nullable;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileConverter {
    ResponseEntity<Resource> uploadAndZipFile(MultipartFile file, @Nullable String fileName) throws IOException;
}
