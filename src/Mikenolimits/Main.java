package Mikenolimits;
import java.awt.*;
import java.util.List;

public class Main {

    public static GUI WordFrame;
    public static WordSorter Reader;
    public static LinkedList list;


    public static void main(String[] args) {

        WordFrame     = new GUI("Project 3",1000,4000);
        Reader        = new WordSorter("players.txt");

        //The GetWords method will have added all the lines, and as they were added,
        //They will have sorted themselves. The getList will have returned
        //the list and all its ArrayLists in the correct order.
        list          =  Reader.getWords().getList();


        WordFrame.organizeColumn(Reader.unorganizedList,WordFrame.text1);

        Reader.unorganized = false;

        WordFrame.organizeColumn(list,2);
        WordFrame.organizeColumn(list,3);
    }

}
