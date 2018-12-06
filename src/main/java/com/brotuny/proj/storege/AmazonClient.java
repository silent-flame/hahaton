package com.brotuny.proj.storege;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

@Service
public class AmazonClient {

    private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = new AmazonS3Client(credentials);
    }

    public String store(byte[] image) {
        String fileUrl = "";
        String id = UUID.randomUUID().toString();
        try {
            File outputFile = new File(id + ".jpg");
            fileUrl = endpointUrl + "/" + bucketName + "/" + outputFile.getName();
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            ImageIO.write(bufferedImage, "jpg", outputFile);
            s3client.putObject(new PutObjectRequest(bucketName, outputFile.getName(), outputFile)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            outputFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public byte[] load(String fileName) {
        S3Object image = s3client.getObject(new GetObjectRequest(bucketName, fileName + ".jpg"));
        try {
            BufferedImage img = ImageIO.read(image.getObjectContent());
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
