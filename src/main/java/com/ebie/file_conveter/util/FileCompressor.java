package com.ebie.file_conveter.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@UtilityClass
@Slf4j
public class FileCompressor {
    public String zipFIle(MultipartFile file, String fileName) throws IOException {
        var trimmedName = FilenameUtils.removeExtension(file.getOriginalFilename());
        var returnPath = fileName == null ? System.getProperty("user.dir") + "\\" + trimmedName + ".zip" : fileName + ".zip";
        File f = new File(returnPath);
        var zipOutputStream = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry zipEntry = new ZipEntry(Objects.requireNonNull(file.getOriginalFilename()));
        zipOutputStream.putNextEntry(zipEntry);
        byte[] bytes = file.getBytes();
        zipOutputStream.write(bytes, 0, bytes.length);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        return returnPath;
    }

   public ResponseEntity<Resource> compressAndDownload(String pathFile){
        Resource resource = null;
        Path path = Paths.get(pathFile);
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
