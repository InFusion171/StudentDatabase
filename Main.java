import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Main 
{
	public static void main(String[] args) 
	{		
		int x = 650;
		int y = 245;
		
		Renderer render = new Renderer(x, y, "Student Database");
		
		//1. Reihe
		render.addLabel(15, 15, 0, 0, "Vorname");
		render.addTextField(15, 30, 0, 0, null);
		
		render.addLabel(180, 15, 0, 0, "Nachname");
		render.addTextField(180, 30, 0, 0, null);
		
		render.addLabel(345, 15, 0, 0, "Alter");
		render.addTextField(345, 30, 0, 0, null);
		
		render.addLabel(510, 15, 0, 0, "Studiengang");
		render.addTextField(510, 30, 0, 0, null);
		
		//2. Reihe
		render.addLabel(15, 65, 0, 0, "Matrikelnummer");
		render.addTextField(15, 80, 0, 0,null);
		
		render.addLabel(180, 65, 0, 0, "Postleitzahl");
		render.addTextField(180, 80, 0, 0, null);
		
		render.addLabel(345, 65, 0, 0, "Straße");
		render.addTextField(345, 80, 0, 0, null);
		
		render.addLabel(510, 65, 0, 0, "Hausnummer");
		render.addTextField(510, 80, 0, 0, null);
		
		//Button
		render.addButton(15, 120, 511, 0, "Hinzufügen");	
		
		Icon icon = new ImageIcon("\\Bilder\\settings.jpg");
		render.addIconButton(595, 165, icon);
	}
}
