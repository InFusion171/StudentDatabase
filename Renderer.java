import javax.swing.JFrame; //render a frame
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.Icon;
import javax.swing.JButton;// Buttons
import javax.swing.JFileChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Renderer implements ActionListener
{
    private static GraphicsConfiguration gc;
    private static JFrame frame = new JFrame(gc);
    private static JFrame optionFrame = new JFrame(gc);

    public Renderer()
    {}

    public Renderer(int xWindowSize, int yWindowSize, String title)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setTitle(title);
        frame.setSize(xWindowSize, yWindowSize);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int xCenterWindow = (int)(dim.getWidth() - xWindowSize) / 2;
        int yCenterWindow = (int)(dim.getHeight() - yWindowSize) / 2;
        frame.setLocation(xCenterWindow, yCenterWindow);
    }

    public void overwriteTextFields()
    {
        if(textFieldList.size() > 7)
        {
            textFieldList.get(0).setText("");
            textFieldList.get(1).setText("");
            textFieldList.get(2).setText("");
            textFieldList.get(3).setText("");
            textFieldList.get(4).setText("");
            textFieldList.get(5).setText("");
            textFieldList.get(6).setText("");
            textFieldList.get(7).setText("");
        }
    }

    public static List<JButton> buttonList = new ArrayList<JButton>();
    public void addButton(int xButton, int yButton, int xAdditional, int yAdditional, String buttonName)
    {
        JButton button = new JButton(buttonName);

        button.addActionListener(this);
        frame.add(button);
        buttonList.add(button);

        Dimension size = button.getPreferredSize();
        button.setBounds(xButton , yButton, size.width + xAdditional, size.height + yAdditional);
    }

    public static List<JTextField> textFieldList = new ArrayList<JTextField>();
    public void addTextField(int xField, int yField, int xAdditional, int yAdditional, String fieldName)
    {
        JTextField text = new JTextField(fieldName, 10);

        text.addActionListener(this);
        frame.add(text);
        textFieldList.add(text);

        Dimension size = text.getPreferredSize();
        text.setBounds(xField, yField, size.width + xAdditional, size.height + yAdditional);

    }

    public static List<JLabel> labelList = new ArrayList<JLabel>();
    public void addLabel(int xLabel, int yLabel, int xAdditional, int yAdditional, String labelName)
    {
        JLabel label = new JLabel(labelName);

        frame.add(label);;
        labelList.add(label);

        Dimension size = label.getPreferredSize();
        label.setBounds(xLabel, yLabel, size.width + xAdditional, size.height + yAdditional);
    }

    public static List<JButton> iconButtonList = new ArrayList<JButton>();
    public void addIconButton(int x, int y, Icon icon)
    {
        JButton button = new JButton();

        button.addActionListener(this);
        iconButtonList.add(button);

        button.setIcon(icon);
        frame.add(button);
        button.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
    }

    public static List<JLabel> optionLabelList = new ArrayList<JLabel>();
    public void addOptionLabel(int xLabel, int yLabel, int xAdditional, int yAdditional, String labelName)
    {
        JLabel label = new JLabel(labelName);

        optionFrame.add(label);;
        labelList.add(label);

        Dimension size = label.getPreferredSize();
        label.setBounds(xLabel, yLabel, size.width + xAdditional, size.height + yAdditional);
    }

    public static List<JButton> optionButtonList = new ArrayList<JButton>();
    public void addOptionButton(int xLabel, int yLabel, int xAdditional, int yAdditional, String buttonName)
    {
        JButton button = new JButton(buttonName);

        button.addActionListener(this);

        optionFrame.add(button);;
        optionButtonList.add(button);

        Dimension size = button.getPreferredSize();
        button.setBounds(xLabel, yLabel, size.width + xAdditional, size.height + yAdditional);
    }

    private void creatOptionFrame(int xWindowSize, int yWindowSize, String title)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        optionFrame.setTitle(title);
        optionFrame.setSize(xWindowSize, yWindowSize);
        optionFrame.setVisible(true);

        optionFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        int xCenterWindow = (int)(dim.getWidth() - xWindowSize) / 2;
        int yCenterWindow = (int)(dim.getHeight() - yWindowSize) / 2;
        optionFrame.setLocation(xCenterWindow, yCenterWindow);

        addOptionButton(15, 15, 0, 0, "Ausgabe Verzeichniss");

    }

    File defaultDatabaseDir = FileSystemView.getFileSystemView().getHomeDirectory();
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(buttonList.size() > 0)
        {
            if (e.getSource() == buttonList.get(0))
            {
                StudentDatabase studentDatabase = new StudentDatabase();
                OutputValues outputValues = new OutputValues();

                boolean canSetOutputValues = false;
               for(int i = 0; i < textFieldList.size(); i++)
               {
                   if(textFieldList.get(i).getText() == "" || textFieldList.get(i).getText() == " ")
                   {
                       canSetOutputValues = false;
                       break;
                   }

                   else
                       canSetOutputValues = true;
               }

               if(canSetOutputValues)
                   outputValues.setOutputValues();

                if (labelList.size() > 8)
                {
                    Container parent = labelList.get(8).getParent();
                    parent.remove(labelList.get(8));
                    labelList.remove(8);
                    parent.validate();
                    parent.repaint();
                }

                try {
                    studentDatabase.StudentToJSON(defaultDatabaseDir.getAbsolutePath());

                } catch (Exception IOE) {
                    JOptionPane.showMessageDialog(null, "Cannot write to the file.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    IOE.printStackTrace();
                }
            }

            if(e.getSource() == buttonList.get(1))
            {
                creatOptionFrame(300, 200, "Optionen");
            }
        }
        if(iconButtonList.size() > 0)
        {
            if (e.getSource() == iconButtonList.get(0))
            {
                creatOptionFrame(300, 200, "Optionen");
            }
        }

        if(optionButtonList.size() > 0)
        {
            if(e.getSource() == optionButtonList.get(0))
            {
                JFileChooser chooser = new JFileChooser();

                chooser.setCurrentDirectory(new java.io.File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()));
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);


                if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    defaultDatabaseDir = chooser.getSelectedFile();
                    System.out.println(defaultDatabaseDir);
                }
            }
        }
    }
}