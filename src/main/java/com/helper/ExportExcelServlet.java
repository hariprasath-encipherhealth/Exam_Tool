package com.helper;


import com.entity.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/ExportExcelServlet")
public class ExportExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String gexamid = request.getParameter("gexamid");
        DatabaseClass dao = new DatabaseClass();
        List<ExamResultDTO> resultList = dao.getExamResults(gexamid);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Results");

        // Header row
        Row header = sheet.createRow(0);
        String[] columns = {"Sr. No", "First Name", "Middle Name", "Last Name", "Exam Title", "Total Marks", "Marks", "Status", "Percentage"};
        for (int i = 0; i < columns.length; i++) {
            header.createCell(i).setCellValue(columns[i]);
        }

        int rowCount = 1;
        int index = 1;
        for (ExamResultDTO examResultDTO : resultList) {

            int total = Integer.parseInt(examResultDTO.getTotalMarks());
            int marks = Integer.parseInt(examResultDTO.getMarks());
            int percentage = marks * 100 / total;
            String status = percentage > 35 ? "Pass" : "Fail";

            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(index++);
            row.createCell(1).setCellValue(examResultDTO.getFirstName());
            row.createCell(2).setCellValue(examResultDTO.getMiddleName());
            row.createCell(3).setCellValue(examResultDTO.getLastName());
            row.createCell(4).setCellValue(examResultDTO.getExamTitle());
            row.createCell(5).setCellValue(examResultDTO.getTotalMarks());
            row.createCell(6).setCellValue(examResultDTO.getMarks());
            row.createCell(7).setCellValue(status);
            row.createCell(8).setCellValue(percentage + "%");
        }

        // Set response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=ResultData.xlsx");

        // Write workbook to response
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        workbook.close();
        out.close();
    }
}
