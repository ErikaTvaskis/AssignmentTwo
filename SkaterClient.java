import java.io.*; 			
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/********************************************************************
 * Programmer:      Erika Tvaskis
 * Class:           CS30S
 * Assignment:      Assignment 2
 * Program Name:    SkaterClient
 * Description:     Reads, changes/adds, and averages times. Also calculates speed.
 * Input:           Reads data from data file
 * Output:          Prints to output
 ***********************************************************************/

public class SkaterClient {  
//Begin class
    
    public static void main(String[] args) throws IOException, ParseException{  
    //Begin main
    
//DECLARATION OF VARIABLES

    String strin;           //String that reads file
    String delim = "[ ]+";  //Delimiter string for splitting input string
    String[] tokens;        //Array for splitting strings
    String Decision;        //Declaring Decision as string
    
    Scanner Scanner = new Scanner(System.in);   //Scanner for file
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");   //Declaring date format
    Date avgDate; //Declaring avgDate as Date

    Skater[] sList = null;          //Declaring sList
    sList = new Skater[10];         //Array of skaters
    Skater[] SpeedList = null;      //Declaring SpeedList
    SpeedList = new Skater[10];     //Array of speeds
    
    int n = 0;      //Declaring n as int
    int cou;        //Declaring cou as int
    int cout=0;     //Declaring cout as int
    int SkaterID;   //Declaring SkaterID as int
    int newtimemin; //Declaring newtimemin as int
    int newtimesec; //Declaring newtimesec as int
    int ifound;     //Declaring ifound as int
    int xmin;       //Declaring xmin as int
    int xsec;       //Declaring xsec as int
    int RaceNumber; //Declaring x as int
    
    long sum;       //Declaring sum as long
    long sumt= 0L;  //Declaring sumt as long   
    
    double sums;    //Declaring sums as double
    
    Double avgSpeed; //Declaring avg as Double
    	
//READING DATA FILE AND CREATING OUTPUT FILE

    BufferedReader fin = new BufferedReader(new FileReader("skaterData.txt"));
    	
//GETTING BANNER AND PRINTING IT
    
    ProgramInfo programInfo = new ProgramInfo();
    System.out.println(programInfo.getBanner("Skating Program"));
 	    	
//READING FILE
//WHILE LOOP SPLITS USING SPACES
//FOR LOOP SPLITS USING :
        
    strin = fin.readLine();
    while(strin != null){           
        sList[n] = new Skater();
        tokens = strin.split(delim);
        for(int i = 0; i < tokens.length; i++){
            String[] Times = tokens[i].split("[:]+");
            sList[n].addATime(i, Integer.parseInt(Times[0]), Integer.parseInt(Times[1]));
            sList[n].getSpeedScore(i);            
        } //Closing bracket for loop
        n++;             
        strin = fin.readLine();
        } //Closing bracket while loop
         
//PRINT OUTPUT
    
    System.out.println("INFO");
    System.out.println("Skater ID, Time for each race, Speed for each race");
    System.out.println("*************************************************");
    for(int i = 0; i < n; i++){
        System.out.println(sList[i].toString());            
        System.out.println(sList[i].toStringSpeed());  
       // System.out.println("km/h");
    } //Closing bracket for loop
 
//AVERAGE TIME FOR SKATER
//AVERAGE TIME FOR ALL RACES

    System.out.println("*************************************************");
    System.out.println("AVERAGE TIMES");
    System.out.println("Per skater and altogether");
    System.out.println("*************************************************");
    for(int k = 0; k < 5; k++){   
        sum = 0L; 
        cou=0;
        for(int i = 0; i < 10; i++){     
            if (!(sList[k].getATime(i).equals("00:00"))) {
                cou=cou+1; 
                cout=cout+1;
                sum += sdf.parse(sList[k].getATime(i)).getTime(); 
                sumt += sdf.parse(sList[k].getATime(i)).getTime(); 
            } //Closing bracket if statement         
        } //Closing bracket for loop (with int i) 
        avgDate = new Date((sum/cou));
        System.out.println("Average Time for Skater: " + (1000+k) + " is: "  + sdf.format(avgDate) + " (mm:ss)");
        } //Closing bracket for loop (int k)
        Date avgDateall = new Date((sumt/cout));
        System.out.println("Average Time All Skaters and Races is: " + sdf.format(avgDateall) + " (mm:ss)");
        System.out.println();
    
//CHANGE/ADD TIMES
    
    System.out.println("*************************************************");
    System.out.println("CHANGING/ADDING TIMES");
    System.out.println("Would you like to change/add a time for a skater? -1 to pass");
    System.out.println("*************************************************");
    Decision = Scanner.nextLine();
    if (Decision.equals("-1")) {
        return;
    } //Closing bracket for if statement
    System.out.println("Which skater? Type an ID betweem 1000 and 1004");
    try {
    SkaterID = Integer.parseInt(Scanner.nextLine());
    } //Closing bracket for try statement
    catch (NumberFormatException e) {
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e);
        return;
    } //Closing bracket catch statement   
    if (!((SkaterID > 999) && (SkaterID < 1005))) {
        System.out.println("Error, incorrect ID");
        return;
    } //Closing bracket for if statement 
    System.out.println();

//CHOSEN SKATER INFO SHOWN
        
    System.out.println("*************************************************");
    System.out.println("INFO ON CHOSEN SKATER");
    System.out.println("*************************************************");
    System.out.println("Skater: " + SkaterID);
        for(int i = 0; i < 10; i++){     
            System.out.println("Race Number: " + (i+1) + " with a time of: " + sList[(SkaterID-1000)].getATime(i));
        } //Closing bracket for loop
        
//CHANGE/ADD TIME FOR THAT SKATER
     
    System.out.println("*************************************************");
    System.out.println("ENTER NEW TIME");
    System.out.println("*************************************************");
    System.out.println("Please Enter new Time (Minutes)");
    try {
        newtimemin = Integer.parseInt(Scanner.nextLine());
    } //Closing bracket try statement
    catch (NumberFormatException e) {
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e);
        return;
    } //Closing bracket catch statement   
    if ((newtimemin < 0) || (newtimemin > 59)) {
        System.out.println("Incorrect time");
        return;
    } //Closing bracket if statement
    System.out.println("Please Enter new Time (Seconds)");
    try {
        newtimesec = Integer.parseInt(Scanner.nextLine());
    } //Closing bracket try statement
    catch (NumberFormatException e) {
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e);
        return;
    } //Closing bracket catch statement   
    if ((newtimesec < 0) || (newtimesec > 59)) {
        System.out.println("Incorrect time");
        return;
    } //Closing bracket if statement
          
//HANDLING THIS ADDED TIME

//FINDS EMPTY SPOT FOR TIME (IF EXISTS), ADDS NEW TIME TO IT
    ifound=0;
    for(int i = 0; i < 10; i++){     
        if (sList[(SkaterID-1000)].getATime(i).equals("00:00")) {  
            sList[(SkaterID-1000)].addATime(i , newtimemin, newtimesec);
            ifound=1;
            i=11;
        } //Closing bracket if statement  
    } //Closing bracket for loop
 
//IF EMPTY SPOT NOT FOUND, REPLACES FIRST TIME AND ALL TIMES SHIFT
//ADDS NEW TIME TO END

    if (ifound==0) {
        for(int i = 0; i < 10; i++){
            tokens = null;
            tokens = sList[(SkaterID-1000)].getATime(i).split("[:]+");
            xmin = Integer.parseInt(tokens[0]); 
            xsec = Integer.parseInt(tokens[1]); 
            if (i>0) {
                sList[(SkaterID-1000)].addATime((i-1) , xmin, xsec);  
            } //Closing bracket if statement
            if (i==9) {
                sList[(SkaterID-1000)].addATime(i , newtimemin, newtimesec);  
            } //Closing bracket if statement                                     
        } //Closing bracket for loop
    } //Closing bracket if statement
     
//PRINTS THE NEW LIST FOR THE CHOSEN SKATER

    System.out.println("*************************************************");
    System.out.println("NEW LIST WITH CHANGED/ADDED TIME");
    System.out.println("*************************************************");
    for(int i = 0; i < 10; i++){     
           System.out.println("Race Number is : " + (i+1) + " and time is " + sList[(SkaterID-1000)].getATime(i));  
    } //Closing bracket for loop
    System.out.println();
        
//INDIVIDUAL RACES
 
    System.out.println("*************************************************");
    System.out.println("SPECIFIC RACE");
    System.out.println("*************************************************");
    System.out.println("What race would you like to see the data for?");
    try {
        RaceNumber = Integer.parseInt(Scanner.nextLine());
    } //Closing bracket try statement
    catch (NumberFormatException e) {
            System.out.println("Error, please enter a numeric value");
            System.out.println("The Error: " + e);
            return;
    } //Closing bracket catch statement   
    
    if ((RaceNumber > 10) || (RaceNumber < 1)) {
        System.out.println("This race does not exist");
        return;
    } //Closing bracket if statement
    System.out.println("Race Number: " + RaceNumber);
    sum = 0L;
    sums = 0;
    cou=0;
    for(int k = 0; k < 5; k++){   
        System.out.println("Skater: " + (k + 1000) + " Time: " + sList[k].getATime(RaceNumber-1) + " Speed: " + sList[k].getSpeedScore(RaceNumber-1) + " km/h");
        if (!(sList[k].getATime(RaceNumber-1).equals("00:00"))) {
            cou=cou+1; 
            sum += sdf.parse(sList[k].getATime(RaceNumber-1)).getTime();
            sums += Double.parseDouble(sList[k].getSpeedScore(RaceNumber-1));
        } //Closing bracket if statement         
        
    } //Closing bracket for loop
 
    avgDate = new Date((sum/cou));
    avgSpeed = sums/cou;
    System.out.println();
    System.out.println("Average Time for This Race is: "  + sdf.format(avgDate) + " (mm:ss)");
    System.out.println("Average Speed for This Race is: "  + String.format("%.2f", avgSpeed) + " km/h"); 

//CLOSING MESSAGE
        
    System.out.println(programInfo.getClosingMessage());
    
    }  //End main
}  // End class
