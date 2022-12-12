package com.ebie.file_conveter.service;

import com.ebie.file_conveter.util.FileCompressor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileConverterImpl implements FileConverter {


    @Override
    public Resource compressFile(MultipartFile file,  String fileName) throws IOException {
      return   FileCompressor.compressZip(file, fileName);
    }
}
