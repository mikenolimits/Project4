
package Mikenolimits;
import sun.tools.jconsole.JConsole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame{


    String words[];
    public static TextArea text1;
    public static TextArea text2;
    public static TextArea text3;
    public static TextArea errorsLog;
    public static JSeparator seperator;


    //Enums for menus for easy iterations

    public enum displayActions{
        FIELDER,
        PITCHER,
        ALL
    }

    public enum fileActions{
        OPEN,
        QUIT
    }

    /*
       Constructor for the GUI to do basic setup.
       It creates a 1 row, 2 column layout each with their own
       Textarea
     */
    public GUI(String title, int width, int height){

        words = new String[]{};
        text1 = new TextArea();
        text2 = new TextArea();
        text3 = new TextArea();
        errorsLog = new TextArea();
        seperator = new JSeparator();
        JMenuBar    menuBar      = new JMenuBar();
        JMenu       fileMenu     = new JMenu("File");
        JMenu       displayMenu  = new JMenu("Display");


        setTitle(title);
        setSize(width,height);
        add(text1);
        add(text2);
        add(text3);


        for (displayActions action : displayActions.values()) {
            JMenuItem i = new JMenuItem(action.toString());
            i.addActionListener(new DisplayMenuHandler(this));
            displayMenu.add(i);
            displayMenu.addSeparator();
        }

        for (fileActions action : fileActions.values()) {
            JMenuItem i = new JMenuItem(action.toString());
            i.addActionListener(new FileMenuHandler(this));
            fileMenu.add(i);
            fileMenu.addSeparator();
        }


        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(displayMenu);

        setLayout(new GridLayout(2,3));
        add(seperator);
        add(errorsLog);

        errorsLog.append("ERRORS LOG : \n");

        setVisible(true);
        text1.setBackground(Color.cyan);
        text2.setBackground(Color.magenta);
        text3.setBackground(Color.pink);

    }

    public void setVisible(int index){
        switch(index){
            case 1:
                removeAllTexts();
                setLayout(new GridLayout(2, 1));
                this.add(text1);
                this.add(errorsLog);
                setVisible(true);
                break;
            case 2:
                removeAllTexts();
                setLayout(new GridLayout(2, 1));
                this.add(text2);
                this.add(errorsLog);
                setVisible(true);
                break;
            case 3:
                removeAllTexts();
                setLayout(new GridLayout(2, 3));
                this.add(text1);
                this.add(text2);
                this.add(text3);
                this.add(seperator);
                this.add(errorsLog);
                setVisible(true);
                break;
            default:
                break;
        }
    }

    public void removeAllTexts() {
        this.remove(text1);
        this.remove(text2);
        this.remove(text3);
        this.remove(errorsLog);
        this.remove(seperator);
    }

    /*
       Helper method to append text to the GUI from a LinkedList
       Instead of a regular one.
     */

    public void organizeColumn(LinkedList column, int index) {

        switch (index){
            case 2:
                for (int i = 0; i < column.fielders.size(); i++) {

                    Fielder player        =  column.fielders.get(i);
                    String currentLine    =  player.toString();
                    text2.append(currentLine);
                }
                break;
            case 3:
                for (int i = 0; i < column.pitchers.size(); i++) {
                    Pitcher player        =  column.pitchers.get(i);
                    String currentLine    =  player.toString();
                    text3.append(currentLine);
                }
                break;
            default:
                throw new IllegalArgumentException("Index out of bounds.");
        }
    }

      /*
      Just a tiny helper method to avoid 2 for loops. It takes the GUIs
      TextArea and appends the array of strings from the particular column into
      the GUI
     */

    public void organizeColumn(ArrayList<Player> column, TextArea text){
        for (int i = 0; i < column.size(); i++) {
            Player player        =  column.get(i);
            String currentLine   =  player.toString();
            text.append(currentLine);
        }
    }

}


