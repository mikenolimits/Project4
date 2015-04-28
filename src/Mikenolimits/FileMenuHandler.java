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
    JFrame jframe;

    public FileMenuHandler (JFrame jf) {
        jframe = jf;
    }

    public static enum Action {
        OPEN,
        QUIT,
        FIELDER,
        PITCHER,
        ALL
    }

    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName = event.getActionCommand();

        Action actionVal = Action.valueOf(menuName.toUpperCase());

        switch(actionVal){
            case OPEN:
                openFile( );
                break;
            case QUIT:
                System.exit(0);
                break;
            case FIELDER:
                GUI.text1.setVisible(false);
                GUI.text3.setVisible(false);
                GUI.text2.setVisible(true);
                break;
            case PITCHER:
                GUI.text1.setVisible(false);
                GUI.text2.setVisible(false);
                GUI.text3.setVisible(true);
                break;
            case ALL:
                GUI.text1.setVisible(true);
                GUI.text2.setVisible(true);
                GUI.text3.setVisible(true);
                break;
            default:
                    System.out.println("Not Found event...");
                break;
        }


    } //actionPerformed

    private void openFile( ) {
        JFileChooser chooser;
        int          status;
        chooser = new JFileChooser( );
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
            readSource(chooser.getSelectedFile());
        else
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile

    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getName();
        TextFileInput inFile = new TextFileInput(chosenFileName);
        String ssn;
        int subscript = 0;
        Container myContentPane = jframe.getContentPane();
        TextArea myTextArea = new TextArea();
        TextArea mySubscripts = new TextArea();
        myContentPane.add(myTextArea, BorderLayout.EAST);
        myContentPane.add(mySubscripts, BorderLayout.WEST);

        ssn = inFile.readLine();
        while (ssn != null) {
            mySubscripts.append(Integer.toString(subscript++)+"\n");
            myTextArea.append(ssn+"\n");
            ssn = inFile.readLine();
        } //while
        //    jframe.setVisible(true);
        jframe.setVisible(true);
    }
}