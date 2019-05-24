import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class Config
{
   private static File homeDirFile = FileSystemView.getFileSystemView().getHomeDirectory();
   private static String homeDirString = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();

    public Config()
    {
        File configDir = new File(homeDirString + "\\FusionDatabaseSetup");//new File("E:\\FusionDatabaseSetup");
        File configPath = new File(homeDirString + "\\FusionDatabaseSetup\\cfg.txt");//new File("E:\\FusionDatabaseSetup\\cfg.txt");

        try
        {
            if(configDir.mkdir())
                configPath.createNewFile();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Cannot creat the FusionDatabaseSetup directory.", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private String getConfigSettings()
    {
        FileController fileController = new FileController(homeDirString + "\\FusionDatabaseSetup\\cfg.txt", "");
        return fileController.readFile();
    }

    public File setOutputDirectory()
    {
        return null;
    }

    public void setConfigOutputDirectory()
    {
        
    }

}