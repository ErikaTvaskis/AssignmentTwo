
/* **********************************************************
 * Programmer:      Erika Tvaskis
 * Class:           CS30S
 * Assignment:      Program Info
 * Description:     Prints banner
 * *************************************************************
 */
 
 public class ProgramInfo
 {  //Begin class

//CONSTRUCTORS
     
    public ProgramInfo(){         
    } //End default constructor

//ACCESSORS
    
//*****************************************************
// Purpose: create a banner
// Interface:
// In: none
// Out: bannerOut
//*****************************************************      
    public String getBanner(String a){
        String bannerOut = "";
        bannerOut = "*******************************************\n";
    	bannerOut += "Name:		Erika Tvaskis\n";
    	bannerOut += "Class:		CS30S\n";
    	bannerOut += "Assignment:	" + 2 + "\n";
    	bannerOut += "*******************************************\n";         
        return bannerOut;
    } //End getBanner
     
//*****************************************************
// Purpose: create closing message
// Interface:
// In: none
// Out: closing
//*****************************************************     
    public String getClosingMessage(){
        String closing = "end of processing.\n";
        return closing;
    } //End getClosingMessage
 
 }  //End class