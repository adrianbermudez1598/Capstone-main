
package Business;

public class Appointments
{
    private String appointmentNumber;
    private String year;
    private String month;
    private String day;
    private String patId;
    private String patName;
    private String chiroId;
    private String chiroName;
    
    Appointments(){
        appointmentNumber = "";
        year = "";
        month = "";
        day = "";
        patId = "";
        patName = "";
        chiroId = "";
        chiroName = "";
        
    }
    
    Appointments(String ap, String y, String m, String d, String pid, String pn, String cid, String cn){
        this.appointmentNumber = ap;
        this.year = y;
        this.month = m;
        this.day = d;
        this.patId = pid;
        this.patName = pn;
        this.chiroId = cid;
        this.chiroName = cn;
        
    }
    
    //Setters
    public void setAppointmentNumber(String ap){appointmentNumber = ap;}
    public void setYear(String y){year = y;}
    public void setMonth(String m) {month = m;}
    public void setDay(String d){day = d;}
    public void setPatId(String pid){patId = pid;}
    public void setPatName(String pn) {patName = pn;}
    public void setChiroName(String cid) {chiroId = cid;}
    public void setChiroId(String cn) {chiroName = cn;}
    
    //Getters
    public String getAppointmentNumber(){return appointmentNumber;}
    public String getYear(){return year;}
    public String getMonth(){return month;}
    public String getDay(){return day;}
    public String getPatId(){return patId;}
    public String getPatName(){return patName;}
    public String getChiroId(){return chiroId;}
    public String getChiroName(){return chiroName;}

    
    //Display
    public void display()
    {
        System.out.println("Appointment Number: " + getAppointmentNumber());
        System.out.println("Year: " + getYear());
        System.out.println("Month: "+getMonth());
        System.out.println("Day: "+getDay());
        System.out.println("Patient Id: "+getPatId());
        System.out.println("Patient Name: "+getPatName());
        System.out.println("Chiropractor Id: "+getChiroId());
        System.out.println("Chiropractor Name: "+getChiroName());
    }

        public static void main(String args[]) {
            


        
        }
}
