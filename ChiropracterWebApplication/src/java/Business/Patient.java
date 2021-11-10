/***************************************************************
 * The Patient Class
 * 
 **************************************************************/
package Business;

public class Patient
{
    /********************Properties****************/
    private String id, passwd, firstName, lastName, email, phone;
    private int count;
    public AppointmentsList aList = new AppointmentsList();
    /********************Constructors****************/
    public Patient()
    {
    id = "";
    passwd = "";
    firstName = "";
    lastName = "";
    email = "";
    phone = "";
    }
    
    public Patient(String id, String passwd, String firstName, String lastName, String email, String phone)
    {
        this.id = id;
        this.passwd= passwd;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
    }
    /********************Behaviors****************/
    public void setPatientID(String pid){id=pid;}
    public String getPatientID() {return id; }
    
    public void setPatientPW(String pw){passwd=pw;}
    public String getPatientPW() {return passwd; }
    
    public void setPatientFirstName(String fn){firstName=fn;}
    public String getPatientFirstName() {return firstName; }
    
    public void setPatientLastName(String ln){lastName=ln;}
    public String getPatientLastName() {return lastName; }
    
    public void setPatientEmail(String em){email=em;}
    public String getPatientEmail() {return email; }
    
    public void setPatientPhone(String pph){phone=pph;}
    public String getPatientPhone() {return phone; }
    
    public void setCount(int c){count = c; }
    public int getCount() {return count;}


    /***************************************************************
 *  Displays Patient info to console
 **************************************************************/
        public void display()
    {
        System.out.println("Patient ID = " + getPatientID());
        System.out.println("Patient Password = " +getPatientPW());
        System.out.println("Patient Name = " + getPatientFirstName() + " " + getPatientLastName());
        System.out.println("Email = " + getPatientEmail());
        System.out.println("Phone = " + getPatientPhone());
    }
    
    
    public static void main(String args[]) {
       
            
            /************Select and Display test*****************/
                     
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectPatient("1234");
            
            //d1.p1.display();
            /************Insert test*****************/

            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.insertPatientDB("6", "4321", "Jack", "Thompson", "JackThompson@mail.com", "770-555-5555");
            //d1.p1.display();
            
            /************Update test*****************/
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectPatient("7");
            //d1.p1.setPatientFirstName("Sam");
            //d1.p1.setPatientPhone("678-555-5555");
            //d1.p1.setPatientEmail("samthompson@mail.com");           
            //d1.updatePatientDB();
            //d1.p1.display();
            /************Delete test*****************/
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectPatient("8");
            //d1.deletePatientDB();

        
        }
}
