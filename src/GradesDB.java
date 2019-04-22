import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class GradesDB
{

    private static XSSFRow row;
    private static XSSFSheet sheet;

    private static XSSFWorkbook workbook;
    public Student getStudentByName(String name)
    {
        Student stu = new Student;
        return stu;
    }
    public HashSet getStudents()
    {
        sheet = workbook.getSheetAt(0);
        HashSet<Student> students = new HashSet<>();
        DataFormatter format = new DataFormatter();
        Student stud;

        for(int i = 1; i <= sheet.getLastRowNum(); i++)
        {
            row = sheet.getRow(i);
            String name = row.getCell(0).toString();
            int id = Integer.parseInt(format.formatCellValue(row.getCell(1)));
            stud = new Student(name, id);
            students.add(stud);
        }
        return students;

    }
    public int getNumStudents()
    {
        sheet = workbook.getSheetAt(0);
        int numOfStudents = 0; //Sheets start a 1 not 0

        for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)
        {
            numOfStudents++;
        }
        return numOfStudents;
    }

    public int getNumAssignments()
    {
        sheet = workbook.getSheetAt(3);
        int numOfAssignments = 0;
        for(int i = 1; i < sheet.getRow(0).getLastCellNum(); i++)
        {
            numOfAssignments++;
        }
        return numOfAssignments;
    }
    public int getNumProjects()
    {
        sheet = workbook.getSheetAt(5);
        int projects = 0;
        for(int i = 1; i < sheet.getRow(0).getLastCellNum(); i++)
        {
            projects++;
        }
        return projects;
    }
    public GradesDB(String xlsx)
    {
        try
        {
            File file = new File(xlsx);
            FileInputStream stream = new FileInputStream(file);
            workbook = new XSSFWorkbook(stream);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
