import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileController 
{
	private File directory;
	private File file;
	
	public FileController(String directory, String path)
	{
		this.file = new File(path);
		this.directory = new File(directory);
	}
	
	public FileController(File directory, File path)
	{
		this.file = path;
		this.directory = directory;
	}
	
	public boolean creatFile()
	{
		if(directory.mkdir())
		{
			try
			{
				file.createNewFile();
				return true;
				
			} catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Cannot creat the " + file + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				
				return false;
			}
		}
		return false;
	}
	
	public boolean writeFile(String toWrite)
	{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, true))) 
		{			
			writer.write(toWrite);
			writer.close();
			
			return true;
			
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Cannot write to the " + file + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean overwrite()
	{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, false)))
		{			
			writer.write(0);
			writer.close();
			
			return true;
			
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Cannot overwrite to the " + file + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
			return false;
		}
	}
	
	public String readTwoLines()
	{
		try(BufferedReader reader = new BufferedReader(new FileReader(this.file))) 
		{
			String result = reader.readLine();
			result += reader.readLine();
			reader.close();
			
			return result;
			
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Cannot read the " + file + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
			return null;
		}
	}
}
