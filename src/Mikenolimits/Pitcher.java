
package Mikenolimits;
/**
 * Created by michaelkantor on 4/9/15.
 */
public class Pitcher extends Player {


    float era;

    public Pitcher(String battingAvg,String number, String lastName, String firstName,String era){
        super(battingAvg,number,lastName,firstName,'P');
        setEra(Float.valueOf(era));
    }

    /*
      Unlike the player we have one extra field. Namely the ERA.
     */
    public String toString(){
        return this.getNumber() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getBattingAvg() + "," + this.getEra() + "\r\n";
    }

    public float getEra() {
        return era;
    }

    public void setEra(float era) {
        this.era = era;
    }
}
