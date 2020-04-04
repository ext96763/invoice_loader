package com.bj.invoiceLoader.controllers;

import com.bj.invoiceLoader.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;


@Controller
public class FileLoadController {

    public static final String uploadingDir = System.getProperty("user.dir") + "/LoadedFiles/";
    Logger logger = LoggerFactory.getLogger(FileLoadController.class);
    @Autowired
    private FileService fileService;
    @Autowired
    private ApiController apiController;

    @GetMapping("/addfile")
    public String uploading(Model model) {
        java.io.File file = new java.io.File(uploadingDir);
        model.addAttribute("files", file.listFiles());
        return "/upload-template";
    }

    @PostMapping(value = "/upload-file")
    public String uploadingTmobile(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,
                                   @RequestParam String date, @RequestParam String datatype) throws IOException {

        for (MultipartFile uploadedFile : uploadingFiles) {
            //Store file locally and store to DB like file
            java.io.File file = new java.io.File(uploadingDir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
            byte[] fileContent = Files.readAllBytes(file.toPath());

            logger.info("File: " + uploadedFile.getOriginalFilename() + " Loaded. Sending it to process in Service[Store whole file to DB]");
            fileService.storeFile(StringUtils.cleanPath(uploadedFile.getOriginalFilename()),
                    StringUtils.cleanPath(uploadedFile.getContentType()), fileContent);

            logger.info("File: " + uploadedFile.getOriginalFilename() + " Loaded. Sending it to process in Service[Parse excel]");
            //Parse excel file and store data to DB
            fileService.parseFile(file, date, datatype);
        }
        return "redirect:/";
    }

}