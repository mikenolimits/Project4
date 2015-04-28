package Mikenolimits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
/**
 * Created by michaelkantor on 4/28/15.
 */
public class DisplayMenuHandler implements ActionListener {

    JFrame jframe;

    public DisplayMenuHandler(JFrame jf) {
        jframe = jf;
    }

    public enum Action{
        FIELDER,
        PITCHER,
        ALL
    }

    public void actionPerformed(ActionEvent event) {

        String  menuName;
        menuName         = event.getActionCommand();

        Action actionVal = Action.valueOf(menuName.toUpperCase());

        switch(actionVal){
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
        }

    }
}
