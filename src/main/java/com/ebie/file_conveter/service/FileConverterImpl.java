package com.ebie.file_conveter.service;

import com.ebie.file_conveter.util.FileCompressor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileConverterImpl implements FileConverter {
    @Override
    public ResponseEntity<Resource> uploadAndZipFile(MultipartFile file, String fileName) throws IOException {
       var filePath= FileCompressor.zipFIle(file, fileName);
      return   FileCompressor.compressAndDownload(filePath);
    }
}
