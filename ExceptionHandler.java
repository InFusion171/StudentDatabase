import javax.swing.JOptionPane;

public class ExceptionHandler
{
    public static boolean checkStudentException()
    {
        if(OutputValues.fieldAlter == 0)          JOptionPane.showMessageDialog(null, "Geben sie ein korrektes Alter ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldHausnummer == 0)     JOptionPane.showMessageDialog(null, "Geben sie eine korrekte Hausnummer ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldMatrikelnummer == 0) JOptionPane.showMessageDialog(null, "Geben sie eine korrekte Matrikelnummer ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldPLZ == 0)            JOptionPane.showMessageDialog(null, "Geben sie eine korrekte PLZ ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldVorname == "")       JOptionPane.showMessageDialog(null, "Geben sie ein korrekten Vorname ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldNachname == "")      JOptionPane.showMessageDialog(null, "Geben sie ein korrekten Nachnamen ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldStudiengang == "")   JOptionPane.showMessageDialog(null, "Geben sie ein korrekten Studiengang ein.", "Warning", JOptionPane.WARNING_MESSAGE);
        if(OutputValues.fieldStrasse == "")       JOptionPane.showMessageDialog(null, "Geben sie eine korrekte Straße ein.", "Warning", JOptionPane.WARNING_MESSAGE);

        if(OutputValues.fieldAlter == 0 || OutputValues.fieldHausnummer == 0 || OutputValues.fieldMatrikelnummer == 0 || OutputValues.fieldPLZ == 0 ||
                OutputValues.fieldVorname == "" || OutputValues.fieldNachname == "" || OutputValues.fieldStudiengang == "" || OutputValues.fieldStrasse == "")
            return true;

        return false;
    }
}