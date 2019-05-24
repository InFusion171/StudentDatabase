import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class StudentDatabase
{
    private List<Student> StudentList = new ArrayList<Student>();

    public StudentDatabase(Student[] student)
    {
        StudentList = new ArrayList<Student>(Arrays.asList(student));
    }

    public StudentDatabase()
    {}

    public void StudentToJSON(String path)
    {
        String VornameAndNachname =     OutputValues.fieldVorname + OutputValues.fieldNachname;
        FileController fileController = new FileController(path + "\\Studenten", path + "\\Studenten\\" + VornameAndNachname + ".json");
        Renderer render =               new Renderer();
        ExceptionHandler handler =      new ExceptionHandler();

        String studentJSON =
                "{\n" +
                        "   " + "\"Vorname\": \""        + OutputValues.fieldVorname +        "\",\n" +
                        "   " + "\"Nachname\": \""       + OutputValues.fieldNachname +       "\",\n" +
                        "   " + "\"Alter\": \""          + OutputValues.fieldAlter +          "\",\n" +
                        "   " + "\"Studiengang\": \""    + OutputValues.fieldStudiengang +    "\",\n" +
                        "   " + "\"Matrikelnummer\": \"" + OutputValues.fieldMatrikelnummer + "\",\n" +
                        "   " + "\"PLZ\": \""            + OutputValues.fieldPLZ +            "\",\n" +
                        "   " + "\"Strasse\": \""        + OutputValues.fieldStrasse +        "\",\n" +
                        "   " + "\"Hausnummer\": \""     + OutputValues.fieldHausnummer +     "\"\n" +
                        "}";

        fileController.creatFile();
        fileController.writeFile(studentJSON);

        if(handler.checkStudentException() == false)
        {
            render.addLabel(17, 165, 0, 0, "Erfolgreich den Student " + OutputValues.fieldVorname + " " + OutputValues.fieldNachname + " hinzugefügt.");
            render.overwriteTextFields();
        }
    }

    public void setStudentArray(Student[] student)
    {
        StudentList = new ArrayList<Student>(Arrays.asList(student));
    }

    public void printStudentArray()
    {
        ListIterator<Student> StudentIterator = StudentList.listIterator();

        while(StudentIterator.hasNext())
            StudentIterator.next().printStudent();
    }

    public void addStudent(Student student)
    {
        StudentList.add(student);
    }

    public void deleteStudent(Student student)
    {
        StudentList.remove(student);
    }

    public int getNumberOfStudents()
    {
        return StudentList.size();
    }
}