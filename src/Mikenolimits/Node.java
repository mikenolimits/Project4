
package Mikenolimits;
import java.util.Map;

/**
 * Created by michaelkantor on 4/9/15.
 */
/*  Class Node  */
public class Node
{
    protected Node nextLink;

    public Map<String,String> container;

    public Node(Map<String,String> values,Node n)
    {
        this.container = values;
        nextLink = n;
    }

    /*  Boolean check for next node */
    public boolean hasNext(){
        return nextLink != null;
    }

    /* Getter for NextNode  */
    public Node getNext(){
        return nextLink;
    }

    /*  Function to set link to next Node  */
    public void setNext(Node n)
    {

        nextLink = n;
    }

    /*  Function to get data from current Node  */
    public Map<String,String> getContainer()
    {

        return this.container;
    }

    /*
       Since the container is a Key Value Pair,
       We're going to attempt to check by the Int
       Value of whatever key we're provided.
     */
    public int compareTo(String key,Node otherNode){

        Integer thisVal  = Integer.valueOf(this.container.get(key));
        Integer otherVal = Integer.valueOf(otherNode.getContainer().get(key));

        return thisVal.compareTo(otherVal);
    }

}