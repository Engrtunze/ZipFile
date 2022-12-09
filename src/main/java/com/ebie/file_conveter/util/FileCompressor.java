package com.ebie.file_conveter.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@UtilityClass
@Slf4j
public class FileCompressor {

//    InputStream inputStream = file.getInputStream();
//    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//    ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
//    ZipEntry zipEntry = new ZipEntry(file.getOriginalFilename());
//    zipOutputStream.putNextEntry(zipEntry);
//
//    byte[] bytes = new byte[1024];
//    int length;
//    while((length = inputStream.read(bytes)) >= 0) {
//        zipOutputStream.write(bytes, 0, length);
//    }
//    zipOutputStream.close();
//
//    // Do something with the byteArrayOutputStream
//    System.out.println(byteArrayOutputStream.toString());
//
//    return ResponseEntity.accepted().build();

    public void zip(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        ZipEntry zipEntry = new ZipEntry(Objects.requireNonNull(file.getOriginalFilename()));
        zipOutputStream.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) >= 0){
            zipOutputStream.write(bytes, 0, length);
        }
        zipOutputStream.close();
    }

}
