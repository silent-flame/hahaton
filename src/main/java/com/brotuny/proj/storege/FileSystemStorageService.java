package com.brotuny.proj.storege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

@Service
public class FileSystemStorageService {
    private final String rootLocation;

    @Autowired
    public FileSystemStorageService(/*StorageProperties properties*/) {
        this.rootLocation = "C:\\Repos\\images\\";
    }

    public String store(byte[] image) {
        try {
            String id = UUID.randomUUID().toString();
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            File outputfile = new File(rootLocation + id + ".jpg");
            ImageIO.write(bufferedImage, "jpg", outputfile);
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public byte[] load(String id) {
        try {
            File initialFile = new File(rootLocation + id + ".jpg");
            if (!initialFile.exists()) return null;
            InputStream targetStream = new FileInputStream(initialFile);
            BufferedImage img = ImageIO.read(targetStream);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();

        } catch (IOException e) {
            System.console().printf(e.getStackTrace().toString());
            throw new RuntimeException(e);
        }
    }


/*
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }
*/


/*
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
*/


/*    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }*/

      /*  public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

*/
}