package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class ExcelGeneratorService {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public ByteArrayResource generate(String sheetName) throws IOException {

//        List<StudentResponse> students = studentService.getStudents();
        List<StudentEntity> students = studentRepository.findAll();
        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFCreationHelper helper = new XSSFCreationHelper(workbook);
        XSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("dd-MM-yyyy");
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        Sheet sheet = workbook.createSheet(sheetName);
        int rowNum=0;
        Row row = sheet.createRow(rowNum);
        int colNum=0;
        row.createCell(colNum++).setCellValue("Name");
        row.createCell(colNum++).setCellValue("Lastname");
        row.createCell(colNum++).setCellValue("Email");
        row.createCell(colNum++).setCellValue("Phone");
        row.createCell(colNum++).setCellValue("Team");
        row.createCell(colNum++).setCellValue("AcademicDegree");
        row.createCell(colNum++).setCellValue("Semester");
        Cell cell = row.createCell(colNum++);
        cell.setCellValue("Birthdate");
        cell.setCellStyle(cellStyle);

        for (StudentEntity student : students) {
            Row rowData = sheet.createRow(++rowNum);
            colNum=0;
            rowData.createCell(colNum++).setCellValue(student.getFirstName());
            rowData.createCell(colNum++).setCellValue(student.getLastName());
            rowData.createCell(colNum++).setCellValue(student.getUserDetails().getEmail());
            rowData.createCell(colNum++).setCellValue(student.getPhone());
            rowData.createCell(colNum++).setCellValue(student.getTeam().getName());
            rowData.createCell(colNum++).setCellValue(student.getAcademicDegree().name());
            rowData.createCell(colNum++).setCellValue(student.getSemester().name());
            rowData.createCell(colNum++).setCellValue(student.getBirthdate());
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        workbook.close();

        return new ByteArrayResource(stream.toByteArray());
    }

}
