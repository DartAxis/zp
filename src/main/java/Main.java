import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Emploee> emploees = new ArrayList<>();
        List<Emploee> emploees1 = new ArrayList<>();
        List<Emploee> emploees2 = new ArrayList<>();
        List<Emploee> emploees3 = new ArrayList<>();
        List<Emploee> emploees4 = new ArrayList<>();
        List<Emploee> emploees5 = new ArrayList<>();
        List<Emploee> emploees6 = new ArrayList<>();
        List<Emploee> emploees7 = new ArrayList<>();
        List<Emploee> emploees8 = new ArrayList<>();
        List<Emploee> emploees9 = new ArrayList<>();

        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0119.xlsx",emploees);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0219.xlsx",emploees1);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0319.xlsx",emploees2);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0419.xlsx",emploees3);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0519.xlsx",emploees4);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0619.xlsx",emploees5);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0719.xlsx",emploees6);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0819.xlsx",emploees7);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp0919.xlsx",emploees8);
        loadFile("/home/axis/IdeaProjects/Javamentor/zp/src/main/resources/zp1019.xlsx",emploees9);
    }

    private static void loadFile(String filename,List<Emploee> emploees) throws IOException {
        FileInputStream file = new FileInputStream(new File(filename));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        emploeeAdd(sheet, emploees);
        //System.out.println(emploees.size());
        workbook.close();
        workbook=null;
        file.close();
    }
    private static void emploeeAdd(Sheet sheet1, List<Emploee> emploees) {
        for (Row row : sheet1) {

            Cell cel1 = row.getCell(10);
            Cell cel2 = row.getCell(13);
            if ((cel1 != null) & (cel2 != null)) {

                switch (cel2.getCellTypeEnum()) {
                    case STRING:
                        break;
                    case NUMERIC:
                        if(cel1.getStringCellValue().equals("Шварев Д.А.")){
                            System.out.println(cel2.getNumericCellValue());
                        }
                        emploees.add(new Emploee(cel1.getStringCellValue(), cel2.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                    case FORMULA:
                        break;
                    default:
                }

            }

        }
    }

}
