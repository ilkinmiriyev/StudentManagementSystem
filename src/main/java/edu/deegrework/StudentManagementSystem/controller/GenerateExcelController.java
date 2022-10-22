package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.service.ExcelGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/excel")
@AllArgsConstructor
public class GenerateExcelController {

    private final ExcelGeneratorService excelService;

    @GetMapping
    public ResponseEntity<ByteArrayResource> generate() throws IOException {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xlsx");

        return new ResponseEntity<>(excelService.generate("students"), header, HttpStatus.CREATED);
    }
}
