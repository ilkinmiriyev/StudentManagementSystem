package edu.deegrework.StudentManagementSystem.excel;

import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.service.StudentService;
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
public class StudentExcelGeneratorService {

    private final StudentService studentService;

    public ByteArrayResource generate() throws IOException {

        List<StudentResponse> students = studentService.getStudents();

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("dd-MM-yyyy");
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);

        Sheet sheet = workbook.createSheet("students");
        int rowNum = 0, colNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(colNum++).setCellValue("Name");
        row.createCell(colNum++).setCellValue("Last name");
        row.createCell(colNum++).setCellValue("Email");
        row.createCell(colNum++).setCellValue("Phone");
        row.createCell(colNum++).setCellValue("Team");
        row.createCell(colNum++).setCellValue("AcademicDegree");
        row.createCell(colNum++).setCellValue("Semester");
        Cell cell = row.createCell(colNum);
        cell.setCellValue("Birthdate");
        cell.setCellStyle(cellStyle);

        for (StudentResponse student : students) {
            Row rowData = sheet.createRow(++rowNum);
            colNum = 0;
            rowData.createCell(colNum++).setCellValue(student.getFirstname());
            rowData.createCell(colNum++).setCellValue(student.getLastname());
            rowData.createCell(colNum++).setCellValue(student.getEmail());
            rowData.createCell(colNum++).setCellValue(student.getPhone());
            rowData.createCell(colNum++).setCellValue(student.getTeamName());
            rowData.createCell(colNum++).setCellValue(student.getAcademicDegree().name());
            rowData.createCell(colNum++).setCellValue(student.getSemester().name());
            rowData.createCell(colNum).setCellValue(student.getBirthdate());
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        workbook.close();
        stream.close();

        return new ByteArrayResource(stream.toByteArray());
    }
}
