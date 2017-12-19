
/* **********************************************************
 * Programmer:	Erika Tvaskis
 * Class:	CS30S
 * Assignment:	Array of skater objects
 * Description:	Skater class has an array of times and a unique id number
 * *************************************************************
 */
 
 public class Skater
    {  //Begin class

//CLASS CONSTANTS

    private static int nextId = 1000;  //Unique skater ID
    private int MAXTIMES = 10;    //Max times

//INSTANCE VARIABLES
     
    private int id; //Id for this object
    private Time[] timeList = new Time[MAXTIMES]; // max 10 scores per student
     
//CONSTRUCTORS
    
//*****************************************************
// Purpose: create a skater object with a unique id number 
// Interface:
// In: none
// Out: none
//*****************************************************    
    public Skater(){
        id = nextId++;  //Set and increment id number
        for(int i = 0; i < MAXTIMES; i++){
            timeList[i] = new Time();
        } //End for loop
    } //End default constructor

//ACCESSORS
     
//*****************************************************
// Purpose: get the id number 
// Interface:
// In: none
// Out: returns id
//*****************************************************
    public int getId(){
        return id;
    } //End getId
    
//*****************************************************
// Purpose: get a time from the time list         
// Interface:
// In: index of time to return
// Out: return a string in the form mm:ss
//*****************************************************
    public String getATime(int index){
        return this.timeList[index].toString();
    } //End getATime
    
//*****************************************************
// Purpose: get a speed from the time list        
// Interface:
// In: index of time to return
// Out: return a string
//*****************************************************
    public String getSpeedScore(int index){
        return this.timeList[index].toStringSpeed();
    } //End getSpeedScore
     
//*****************************************************
// Purpose: override to string to print id and times  
// Interface:
// In: none
// Out: string with id and all times
//********************************************************/ 
    public String toString(){
        String strout = "Skater: " + this.getId() + "\n" + "Time (mm:ss): ";
        for(int i = 0; i < 10; i++){
            strout += this.getATime(i) + ", ";
        } //End for loop
        return strout;
     } //End toString  
     
//*****************************************************
// Purpose: override to string to print speeds
// Interface:
// In: none
// Out: string with speeds
//********************************************************/     
    public String toStringSpeed(){
        String strout = "Speed (km/h): ";
        for(int i = 0; i < 10; i++){
            strout += this.getSpeedScore(i) + ", ";
        } //End for loop
        strout += "\n";
        return strout;
    } //End toStringSpeed     
     
//MUTATORS

//*****************************************************
// Purpose: sets the values of minutes and seconds on time    
// Interface:
// In: int index
// Out: none
//*****************************************************
     public void addATime(int index, int m, int s){
         this.timeList[index].setTime(m, s);
    } //End addATime
 
 }  //End class