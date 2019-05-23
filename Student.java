
public class Student
{
	private String Vorname;
	private String Nachname;
	private String Studiengang;
	private String Strasse;
	private int    PLZ;
	private int	   Hausnummer;
	private int    Matrikelnummer;
	private int    Alter;
	
	public Student(String Vorname, String Nachname, String Strasse,String Studiengang, 
			int PLZ, int Alter, int HNummer, int Matrikelnummer)
	{
		this.PLZ = PLZ;
		this.Alter = Alter;
		this.Strasse = Strasse;
		this.Vorname = Vorname;
		this.Nachname = Nachname;
		this.Hausnummer = HNummer;
		this.Studiengang = Studiengang;
		this.Matrikelnummer = Matrikelnummer;
	}
		
	void printStudent()
	{
		System.out.println("Vorname:         " + this.Vorname);
		System.out.println("Nachname:        " + this.Nachname);
		System.out.println("Alter:           " + this.Alter);
		System.out.println("Studiengang:     " + this.Studiengang);
		System.out.println("Matrikelnummer:  " + this. Matrikelnummer);
		System.out.println("PLZ              " + this.PLZ);
		System.out.println("Straﬂe:          " + this.Strasse);
		System.out.println("Hausnummer:      " + this.Hausnummer);
	}	
}
