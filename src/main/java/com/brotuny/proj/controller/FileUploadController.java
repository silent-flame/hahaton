package com.brotuny.proj.controller;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.stream.Collectors;

import com.brotuny.proj.storege.AmazonClient;
import com.brotuny.proj.storege.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brotuny.proj.exception.StorageFileNotFoundException;

import javax.imageio.ImageIO;

@Controller
@RequestMapping("/api/image")
public class FileUploadController {

    private final FileSystemStorageService storageService;
    //AmazonClient storageService;

    @Autowired
    public FileUploadController(FileSystemStorageService amazonClient) {
        this.storageService = amazonClient;
    }


    @GetMapping(path = "/{id}", produces = "image/jpg")
    @ResponseBody
    public byte[] getFile(@PathVariable("id") String id) {
        return storageService.load(id);
    }

    @PostMapping
    @ResponseBody
    public String uploadFile(@RequestBody byte[] image) {
        return storageService.store(image);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
