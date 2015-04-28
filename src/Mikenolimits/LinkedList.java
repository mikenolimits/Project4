
/**
 * Created by michaelkantor on 4/9/15.
 */
package Mikenolimits;

import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class LinkedList {
    /*
       This probably wasn't the right way of doing this.
       But when I thought of LinkedList I thought of a container which
       had multiple Lists inside of it like a Dictionary
     */

    public List<Fielder> fielders;
    public List<Pitcher> pitchers;
    public List<Player>  all;

     /*
       The container For The Previous Node.
     */
    protected Node CurrentPointer;
    /*
      The Container that we eventually swap to.
     */
    protected Node NextPointer;

    /*
      The Temp Container We use to store the link during processing
     */
    protected Node TempPointer;

    protected Node firstIndex;
    public int length;


    public LinkedList() {
        length     = 0;
    }

    public boolean isEmpty(){
        return firstIndex == null;
    }

    /*  Function to insert an element  */
    public void add(Map<String, String> player) {

        CurrentPointer = new Node(player, null);

        boolean unsorted = false;

        if (this.isEmpty()) {
            //The first add call to LinkedList will always be null,
            //So we need to set it to the CurrentPointer.
            firstIndex = CurrentPointer;
        } else if (CurrentPointer.compareTo("number",this.firstIndex) <= 0) {

            CurrentPointer.setNext(firstIndex);
            firstIndex = CurrentPointer;

        } else {
            TempPointer = firstIndex;
            NextPointer = firstIndex.getNext();

            while (NextPointer != null) {

                int greaterThan = CurrentPointer.compareTo("number",TempPointer);
                int lessThan    = CurrentPointer.compareTo("number",NextPointer);

                //Kind of like the CompareTo loop in the previous project
                //The difference here being we iterate up the nodes and not
                //up an index like an Array
                if (lessThan <= 0 && greaterThan >= 1) {
                    TempPointer.setNext(CurrentPointer);
                    CurrentPointer.setNext(NextPointer);
                    unsorted = true;
                    break;
                } else {
                    //Set the Temp to the previous Pntr
                    TempPointer = NextPointer;
                    //Set the next to the next pointer
                    NextPointer = NextPointer.getNext();
                }
            }

            if (!unsorted) {
                TempPointer.setNext(CurrentPointer);
            }
        }
        length++;
    }

     /*
       As additions were happening the LinkedList was
       Self sorting itself. At this point this method will return
       an essentially sorted list.
     */
    public LinkedList getList() {

        fielders = new ArrayList<Fielder>();
        pitchers = new ArrayList<Pitcher>();
        all      = new ArrayList<Player>();

        // If the current list is empty,
        // we just return a new instance of the class.
        if (length == 0) {
            return new LinkedList();
        }

        Node pointer = firstIndex.getNext();

        iterateList(firstIndex);

        while (pointer.hasNext()) {

            pointer = iterateList(pointer);
        }
        iterateList(pointer);

        return this;
    }

    /*
         Essentially this method is kind of similar to what the ListIterator
         Was responsible for. While the loop is taking place, it will add
         new data, which is organized into our Lists. This method is not inside the Node
         Class so that the Node can be Agnostic. Kind of like an IoC container.
     */

    private Node iterateList(Node pointer) {


        Map<String,String> player = pointer.getContainer();

        String number      = String.valueOf(player.get("number"));
        String lastName    = player.get("lastName");
        String firstName   = player.get("firstName");
        String battingAvg  = String.valueOf(player.get("battingAvg"));
        char playerType    = player.get("playerType").charAt(0);

        switch (playerType) {
            case 'P':

                String  era            = player.get("era");
                Pitcher currentPitcher = new Pitcher(battingAvg, number, lastName, firstName, era);
                pitchers.add(currentPitcher);
                break;

            case 'F':

                Fielder currentFielder = new Fielder(battingAvg, number, lastName, firstName);
                fielders.add(currentFielder);
                break;

            default:
                throw new IllegalArgumentException("The Type Doesn't Exist...");
        }
        pointer = pointer.getNext();
        return pointer;
    }

}