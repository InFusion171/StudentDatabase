
public class OutputValues
{		
	public static String fieldVorname = "";
	public static String fieldNachname = "";
	public static String fieldStudiengang = "";
	public static String fieldStrasse = "";
	public static int    fieldPLZ = 0;
	public static int	 fieldHausnummer = 0;
	public static int    fieldMatrikelnummer = 0;
	public static int    fieldAlter = 0;
		
	void setOutputValues()
	{		
		try
		{
			OutputValues.fieldVorname =        Renderer.textFieldList.get(0).getText();
			OutputValues.fieldNachname =       Renderer. textFieldList.get(1).getText();				
			OutputValues.fieldAlter =          Integer.parseInt(Renderer.textFieldList.get(2).getText());			
			OutputValues.fieldStudiengang =    Renderer.textFieldList.get(3).getText();
			OutputValues.fieldMatrikelnummer = Integer.parseInt(Renderer.textFieldList.get(4).getText());
			OutputValues.fieldPLZ =            Integer.parseInt(Renderer.textFieldList.get(5).getText());
			OutputValues.fieldStrasse =        Renderer. textFieldList.get(6).getText();
			OutputValues.fieldHausnummer =     Integer.parseInt(Renderer.textFieldList.get(7).getText());
			
		}catch(Exception e)
		{
			ExceptionHandler.checkStudentException();
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("static-access")
	Student OutputValuestoStudent()
	{
		return new Student(this.fieldVorname, this.fieldNachname, this.fieldStudiengang, this.fieldStrasse, 
						   this.fieldPLZ, this.fieldHausnummer, this.fieldMatrikelnummer, this.fieldAlter);
	}
}
