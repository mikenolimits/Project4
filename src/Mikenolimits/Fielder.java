
package Mikenolimits;
/**
 * Created by michaelkantor on 4/9/15.
 */
public class Fielder extends Player {


    public Fielder(String battingAvg,String number, String lastName, String firstName){
        super(battingAvg,number,lastName,firstName,'F');
    }


    public Fielder(char playerType,String battingAvg,String number, String lastName, String firstName){
        super(playerType,battingAvg,number,lastName,firstName);
    }
}
