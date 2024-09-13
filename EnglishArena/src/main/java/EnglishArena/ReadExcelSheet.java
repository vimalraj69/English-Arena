package EnglishArena;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelSheet {
	private String excelFilePath;
	ReadExcelSheet(String path){
		excelFilePath = path;
	}

    public  String[] readFile() {
        List<String> namesList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Access the first sheet ( student data is in the first sheet)
            Sheet sheet = workbook.getSheetAt(0);

            // Loop through each row starting from the second row (index 0)
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    // Get the Student Name column 
                    Cell studentNameCell = row.getCell(0); //  
                    if (studentNameCell != null) {
                        // Add the student name to the list
                        namesList.add(studentNameCell.getStringCellValue());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert the list to a String array and return it
        return namesList.toArray(new String[0]);
    }
}

