/***************************************************************
 * The Patient Class
 * 
 **************************************************************/

package Business;

public class Chiropractor 
{
    private String id, firstName, lastName, email, password, phone;

        /********************Constructors****************/
    public Chiropractor()
    {
    id = "";
    firstName = "";
    lastName = "";
    email = "";
    password = "";
    phone = "";
    }
    
    
    public Chiropractor (String id, String fname ,String lname, String password,String email, String phone)
    {
        this.id = id;
        this.firstName= fname;
        this.lastName = lname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    
    /********************Behaviors****************/
    public void setChiropractorID(String pid){id=pid;}
    public String getChiropractorID() {return id; }
    
    public void setChiropractorPW(String pw){password=pw;}
    public String getChiropractorPW() {return password; }
    
    public void setChiropractorFirstName(String fn){firstName=fn;}
    public String getChiropractorFirstName() {return firstName; }
    
    public void setChiropractorLastName(String ln){lastName=ln;}
    public String getChiropractorLastName() {return lastName; }
    
    public void setChiropractorEmail(String em){email=em;}
    public String getChiropractorEmail() {return email; }
    
    public void setChiropractorPhone(String pph){phone=pph;}
    public String getChiropractorPhone() {return phone; }
    
    //Display
    public void display()
    {
        System.out.println("Chiropractor ID: " + getChiropractorID());
        System.out.println("Name: "+getChiropractorFirstName() +" " + getChiropractorLastName());
        System.out.println("Email: "+getChiropractorEmail());
        System.out.println("Password: "+getChiropractorPW());
        System.out.println("Phone: "+getChiropractorPhone());
    }
    
    
    //Main Method
    public static void main(String[] args) 
    {
            DbAccess d1;
            d1 = new DbAccess();
            d1.selectChiropractor("2343");
            d1.c1.display();
        
        
        /************Insert test*****************/

            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.insertChiropractorDB("10", "bigShot", "Tex", "Goldberg", "TextGoldBerg@mail.com", "770-555-5125");         
            //d1.c1.display();
            
            /************Update test*****************/
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectChiropractor("10");
            //d1.c1.setChiropractorID("5671");
            //d1.updateChiropractorDB();
            //d1.c1.display();

            /************Delete test*****************/
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectPatient("8");
            //d1.deletePatientDB();
    }

    
}
