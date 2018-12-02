package com.brotuny.proj.notifications;

import com.brotuny.proj.data.model.Stage;
import com.brotuny.proj.storege.FileSystemStorageService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailCreater {

    private final FileSystemStorageService fileSystemStorageService;

    public EmailCreater(FileSystemStorageService fileSystemStorageService) {
        this.fileSystemStorageService = fileSystemStorageService;
    }

    public String createMail(Stage stage) {
        String tmp = template.replaceAll("TITLETITLE", stage.getTitle());
        byte[] bytes = fileSystemStorageService.load(stage.getPhoto());
        if (bytes != null) {
            String encodedFile = null;
            try {
                encodedFile = new String(Base64.encodeBase64(bytes), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            tmp = tmp.replaceAll("IMAGEIMAGE", "data:image/jpg;base64," + encodedFile);
        }
        return tmp;
    }


    private static String template = "<div style=\"background: #f5f5f5; border-radius: 10px; font-family: Tahoma; padding-top: 10px; padding-bottom: 10px; border: 1px solid #eee;\">\n" +
            "\t<div style=\"padding: 15px; max-width: 600px; margin: 0px auto;\">\n" +
            "\t\t<div style=\"width: 100%; margin: 0px auto; border-radius: 10px; background: #FFF; overflow: hidden;  border: 1px solid #eee; box-shadow: 0px 10px 30px 0px rgba(0,0,0,0.1);\">\n" +
            "\t\t\t<div style=\"height: 5px; background: #10C66E;\"></div>\n" +
            "\t\t      <div style=\"clear: both;\"></div>\n" +
            "\t\t      <div class=\"point_news_title\" style=\"font-size: 20px;\n" +
            "\t\t\t\t  padding-left: 15px;\n" +
            "\t\t\t\t  padding-right: 15px;\n" +
            "\t\t\t\t  padding-top: 15px;\n" +
            "\t\t\t\t  border-top: 1px solid #eee;\n" +
            "\t\t\t\t  text-align: center;\">\n" +
            "\t\t        TITLETITLE\n" +
            "\t\t      </div>\n" +
            "\t\t      <div class=\"point_news_images\" style=\"overflow: hidden; margin-top: 15px;\">  \n" +
            "\n" +
            "                <div class=\"point_news_image\" style=\"float: left; width: 100%; background-size: cover;position: relative;\">\n" +
            "\t                ТУТ БУДЕТ КАРТИНКА" +
            "\t              </div>\n" +
            "              </div>\n" +
            "\t\t      <div class=\"point_news_text\" style=\"margin-top: 15px;\n" +
            "\t\t\t\t  margin-bottom: 15px;\n" +
            "\t\t\t\t  padding-left: 15px;\n" +
            "\t\t\t\t  padding-right: 15px;\">\n" +
            "\t\t        <p>\n" +
            "\t\t\t\t\t<a href=\"http://172.21.47.216:3000\">Вы можите видеть обновление статуса вашего дома по этой ссылке</a>\n" +
            "\t\t        </p>\n" +
            "\t\t      </div>\n" +
            "\t\t</div>\n" +
            "\n" +
            "\t</div>\n" +
            "</div>\n";
}
