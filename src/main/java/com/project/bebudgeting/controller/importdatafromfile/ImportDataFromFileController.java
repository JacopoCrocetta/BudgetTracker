package com.project.bebudgeting.controller.importdatafromfile;

import com.project.bebudgeting.service.csvservice.CSVService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.swagger.annotations.Api;

@Api(value = "Import Data From File", tags = "Import Data From File", description = "REST APIs related to ImportDataFromFileController")
@RestController
@RequestMapping("/importdatafromfile")
public class ImportDataFromFileController {

    @Autowired
    CSVService service;

    @PostMapping("/importdata")
    public String ingestDataFile(@RequestBody MultipartFile file,
            RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "No File is Present");
            return "redirect:uploadStatus";
        }

        boolean savedFile = service.save(file);

        if (savedFile) {
            return "redirect:/uploadStatus";
        } else {
            redirectAttributes.addFlashAttribute("message", "File is not a CSV");
            return "redirect:uploadStatus";
        }
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
