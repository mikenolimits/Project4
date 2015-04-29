package Mikenolimits;

/**
 * Created by michaelkantor on 4/28/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
public class FileMenuHandler implements ActionListener {
    GUI jframe;

    public FileMenuHandler (GUI jf) {
        jframe = jf;
    }

    public static enum Action {
        OPEN,
        QUIT
    }

    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName         = event.getActionCommand();

        Action actionVal = Action.valueOf(menuName.toUpperCase());

        switch(actionVal){
            case OPEN:
                openFile( );
                break;
            case QUIT:
                System.exit(0);
                break;
            default:
                    System.out.println("Not Found event...");
                break;
        }

    }

    private void openFile( ) {
        JFileChooser chooser;
        int          status;
        chooser = new JFileChooser( );
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
            readSource(chooser.getSelectedFile());
        else
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    }

    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getName();

        GUI.text1.setText("");
        GUI.text2.setText("");
        GUI.text3.setText("");
        GUI.errorsLog.setText("ERROS LOG: \n");
        Main.setColumns(chosenFileName);
    }
}