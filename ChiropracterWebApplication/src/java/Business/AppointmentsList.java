/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author kerds
 */
public class AppointmentsList
{
        /********************Properties****************/
    public int count = 0;       //number of appointments
    public Appointments appArr[] = new Appointments[30];
    
        /********************Methods****************/
    
/***************************************************************
 *  Adds an appointment to the list. Adds 1 to counter.
 **************************************************************/    
    public void addAppointment(Appointments a1){
        
        appArr[count] = a1;  
        count++;
    } //end addAppointment
    
    



/***************************************************************
 *  Displays full list of appointments
 **************************************************************/    
    public void displayList(){
        for (int x=0; x<count; x++){
            appArr[x].display();
        }
    }//end displayList
    
/***************************************************************
 *  Displays specific appointment from list
 **************************************************************/    
    public void displayList(int y){
        //for (int x=0; x < y; x++){
            appArr[y].display();
       // }
    }//end displayList
            public static void main(String args[]) {
            


        
        }
}
