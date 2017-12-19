
/* **********************************************************
 * Programmer:	Erika Tvaskis
 * Class:	CS30S
 * Assignment:	Assignment 2
 * Description:	Creates assessment objects
 ***********************************************************************/
 
public class Time
    { //Begin class

//CLASS CONSTANTS

    private int Distance = 5;
    private int TimeConversion = 3600;
    private int SecondsConversion = 60;
     
//INSTANCE VARIABLE
     
    private int Minutes = 0;
    private int Seconds = 0;

//CONSTRUCTORS
    
//*****************************************************
// Purpose: create a new time object with default values
// Interface: IN: none
// Returns: none
// *****************************************************      
    public Time(){
        Seconds = 0; 
    } //End default constructor

//ACCESSORS

//*****************************************************
// Purpose: get minutes on a time
// Interface: IN: none
// Returns: Minutes
// *****************************************************
    public int getMinutes(){
        return Minutes;
    } //End getMinutes
 
//*****************************************************
// Purpose: get seconds on a time
// Interface: IN: none
// Returns: Seconds
// *****************************************************
    public int getSeconds(){
        return Seconds;
    } //End getSeconds
     
//*****************************************************
// Purpose: get speed
// Interface: IN: none
// Returns: (double) Speed
// *****************************************************
    public double getSpeed(){
        double Speed;
        Speed = (double)(Distance * TimeConversion)/(getMinutes() * SecondsConversion + getSeconds());  
        if ((getMinutes()==0) || (getSeconds() == 0)) {
            Speed =0;
        } //Closing bracket if statement
        return Speed;
     } //End getSpeed
     
//*****************************************************
// Purpose: return the time details as a string
// Interface: IN: none
// Returns: strout
// *****************************************************
    public String toString(){
        String strout = "";
        strout = String.format("%02d:%02d", this.getMinutes(), this.getSeconds());
        return strout;
    } //End toString    
     
//*****************************************************
// Purpose: return the speed details as a string
// Interface: IN: none
// Returns: strout
// *****************************************************    
    public String toStringSpeed(){
        String strout = "";
        strout = String.format("%.2f", this.getSpeed());
        return strout;
    } //End toStringSpeed
    
//MUTATORS
     
//*****************************************************
// Purpose: set the values of a time
// Interface: IN: int mins, int sec
// Returns: none
// ***************************************************** 
    public void setTime(int mins, int sec){
        this.Minutes = mins;
        this.Seconds = sec;
    } //End setTime

 }  //End class