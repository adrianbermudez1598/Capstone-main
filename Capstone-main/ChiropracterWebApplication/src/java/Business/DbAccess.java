/***************************************************************
 *  This class accesses the database files. 
 *  The location should be changed for each team member 
 *  to point to their local db file.
 **************************************************************/
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbAccess
{
    /***************************************************************
    *  Search the Database file.  
    * 
    **************************************************************/
    
    /********************Properties****************/
    private String patId, chiroId, appointmentNumber;
    public Patient p1 = new Patient();
    public Chiropractor c1 = new Chiropractor();
    public Appointments a1 = new Appointments();
    
    //String DBlocation = "jdbc:ucanaccess:///Users/lalu/Classes/Senior Project/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    //String DBlocation ="jdbc:ucanaccess://C:/Users/Jaru/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    //String DBlocation ="jdbc:ucanaccess://C:/Users/kerds/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    String DBlocation ="jdbc:ucanaccess://C:/Users/adria/Desktop/Capstone-main/Capstone-main/ChiropracterWebApplication/ChiropracticDB.accdb";
    
    /********************Behaviors****************/
    
    public void DbAccess()
    {
        patId = "";
        chiroId = "";
        appointmentNumber ="";
    }
    
    public void DbAccess(String patId, String chiroId, String appointmentNumber)
    {
        this.patId=patId;
        this.chiroId=chiroId;
        this.appointmentNumber = appointmentNumber;
    }
    /********************Patient Class DB Functions****************/
    
    /***************************************************************
    *  Selects a database entry for a Patient in db Patient table
    **************************************************************/
    public void selectPatient(String pid) 
        {
            try 
            { 
            //Load Driver - Step #1
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Get Connection from the Driver - Step #2
                Connection con1;
                con1=DriverManager.getConnection(DBlocation);
                

            //Create a Statement - Step #3
               Statement stmt = con1.createStatement();
               ResultSet rs = stmt.executeQuery("Select * from Patients where patID = '" + pid + "'");
            //Process ResultSet
            
            rs.next();
            patId = rs.getString(1);
            String passwd = rs.getString(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String email = rs.getString(5);
            String phone = rs.getString(6);
            
            p1.setPatientID(pid);
            p1.setPatientPW(passwd);
            p1.setPatientFirstName(firstName);
            p1.setPatientLastName(lastName);
            p1.setPatientEmail(email);
            p1.setPatientPhone(phone);
            con1.close();
            }
                catch(Exception se) 
                {
                System.out.println(se);
                }
        } //end selectPatient()
    
    /***************************************************************
    *  Inserts a database entry for a new Patient in db Patient table
    **************************************************************/
    
    public void insertPatientDB(String id, String pw, String fn, String ln, String em, String ph){     
        p1.setPatientID(id);
        p1.setPatientPW(pw);
        p1.setPatientFirstName(fn);
        p1.setPatientLastName(ln);
        p1.setPatientEmail(em);
        p1.setPatientPhone(ph);

        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection(DBlocation);
            Statement stmt = con1.createStatement();
            String sql = "Insert into Patients values('"+p1.getPatientID()+"',"+
                                                      "'"+p1.getPatientPW()+"',"+ 
                                                      "'"+p1.getPatientFirstName()+"',"+ 
                                                      "'"+p1.getPatientLastName()+"',"+ 
                                                      "'"+p1.getPatientEmail()+"',"+ 
                                                      "'"+p1.getPatientPhone()+"')"; 

            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }
      
    }//end insertPatientDB()
    
    /***************************************************************
 *  Update an existing Patient entry in db Patient table
 **************************************************************/
public void updatePatientDB(){
         
       
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection(DBlocation);
            Statement stmt = con1.createStatement();
            String sql = "update Patients set firstName = '"+p1.getPatientFirstName()+ "',"+ 
                                            " lastName ='"+p1.getPatientLastName()+"',"+
                                            " email = '"+p1.getPatientEmail()+"',"+
                                            " patID ='"+p1.getPatientID()+"',"+
                                            " password = '"+p1.getPatientPW()+"',"+
                                            " phone = '"+p1.getPatientPhone()+"'"+
                                            " where patID='"+patId+"'";
 
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            con1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }
      
    }//end updatePatientDB()

/***************************************************************
 *  Deletes existing Patient entry
 **************************************************************/        
        public void deletePatientDB(){
                
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1;
            con1=DriverManager.getConnection(DBlocation);
            Statement stmt = con1.createStatement();
            String sql = "Delete from Patients where patID='"+ p1.getPatientID()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE Successful!!!");
            else
                System.out.println("DELETE FAILED***********");
            con1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
            }
        
        }//end deletePatientDB()
        
        
        
        
    //////////////Chiropracter class DB Fuctions//////////
        
        
     
    //Select Chiropractor from db     
    public void selectChiropractor(String cid)
    {  
        
        try
        {
            //Load Driver - Step #1
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Get Connection from the Driver - Step #2
                Connection con2;
                con2=DriverManager.getConnection(DBlocation);
                

            //Create a Statement - Step #3
               Statement stmt = con2.createStatement();
               ResultSet rs = stmt.executeQuery("Select * from Chiropractors where chiroID = '" + cid + "'");
            //Process ResultSet
            
            rs.next();
            chiroId = rs.getString(1);
            String password = rs.getString(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String email = rs.getString(5);
            String phone = rs.getString(6);
            
            c1.setChiropractorID(chiroId);
            c1.setChiropractorPW(password);
            c1.setChiropractorFirstName(firstName);
            c1.setChiropractorLastName(lastName);
            c1.setChiropractorEmail(email);
            c1.setChiropractorPhone(phone);
            con2.close();
            
        }
        catch(Exception re)
        {
            System.out.println(re);
        }
    }
    
    
    //Insert information into Chiropractor db
     public void insertChiropractorDB(String id, String pw, String fn, String ln, String em, String ph)
     {  

        c1.setChiropractorID(id);
        c1.setChiropractorPW(pw);
        c1.setChiropractorFirstName(fn);
        c1.setChiropractorLastName(ln);
        c1.setChiropractorEmail(em);
        c1.setChiropractorPhone(ph);

        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con2;
            con2=DriverManager.getConnection(DBlocation);         
            Statement stmt = con2.createStatement();
            String sq1 = "Insert into Chiropractors values('"+c1.getChiropractorID()+"',"+
                                                      "'"+c1.getChiropractorPW()+"',"+ 
                                                      "'"+c1.getChiropractorFirstName()+"',"+ 
                                                      "'"+c1.getChiropractorLastName()+"',"+ 
                                                      "'"+c1.getChiropractorEmail()+"',"+ 
                                                      "'"+c1.getChiropractorPhone()+"')"; 
            
  
            

            System.out.println(sq1);
            int n1 = stmt.executeUpdate(sq1);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con2.close();
        }
        catch(Exception te)
        {
            System.out.println(te);
        }
    }
    
     
    //Update information inside of Chiropractor DB
    public void updateChiropractorDB(){
         
       
        try
        {
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con2=DriverManager.getConnection(DBlocation);
            
            Statement stmt = con2.createStatement();
            String sql = "update Chiropractors set firstName = '"+c1.getChiropractorFirstName()+ "',"+ 
                                            " lastName ='"+c1.getChiropractorLastName()+"',"+
                                            " email = '"+c1.getChiropractorEmail()+"',"+
                                            " chiroID ='"+c1.getChiropractorID()+"',"+
                                            " password = '"+c1.getChiropractorPW()+"',"+
                                            " phone = '"+c1.getChiropractorPhone()+"'"+
                                            " where chiroID='"+chiroId+"'";
 
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            con2.close();
        }
        catch(Exception d)
        {
            System.out.println(d);
        }
    }
     
    // Delete Chiropractor information from DB
    public void deleteChiropractorDB(){
                
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con2=DriverManager.getConnection(DBlocation);
            
            Statement stmt = con2.createStatement();
            String sql = "Delete from Chiropractors where chiroId='"+ c1.getChiropractorID()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE Successful!!!");
            else
                System.out.println("DELETE FAILED***********");
            con2.close();
        }
        catch(Exception e1){
            System.out.println(e1);
            }
    }
    
    //////////////////Appointments//////////////////
    
    
     //select schedule for Patient from db
    public void selectPatientSchedule(String cid)
    {
        try
        {
            //Load Driver - Step #1
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Get Connection from the Driver - Step #2
                Connection con;
                con=DriverManager.getConnection(DBlocation);
                

            //Create a Statement - Step #3
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("Select * from Appointments where patId = '" + cid + "'");
            //Print ResultSet
            
            while(rs.next()){
                System.out.println("Appointment Number: " + rs.getString("appointmentNumber"));
                System.out.println("Chiropractor ID: " + rs.getString("chiroId"));
                System.out.println("Chiropractor Name: " + rs.getString("chiroName"));
                System.out.println("Patient ID: " + rs.getString("patId"));
                System.out.println("Patient Name: " + rs.getString("patName"));
                System.out.println("Date: " + rs.getString("month") + " " +rs.getString("day") + " " + rs.getString("year"));
                System.out.println("=============================================");
            }   
           con.close();
        }
        catch(Exception re)
        {
            System.out.println(re);
        }
    }
    
    //Select Schedule for Chiropractor from db     
    public void selectChiropractorSchedule(String cid)
    {
        try
        {
            //Load Driver - Step #1
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Get Connection from the Driver - Step #2
                Connection con;
                con=DriverManager.getConnection(DBlocation);
                

            //Create a Statement - Step #3
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("Select * from Appointments where chiroId = '" + cid + "'");
            //Print ResultSet
            
            while(rs.next()){
                System.out.println("Appointment Number: " + rs.getString("appointmentNumber"));
                System.out.println("Chiropractor ID: " + rs.getString("chiroId"));
                System.out.println("Chiropractor Name: " + rs.getString("chiroName"));
                System.out.println("Patient ID: " + rs.getString("patId"));
                System.out.println("Patient Name: " + rs.getString("patId"));
                System.out.println("Date: " + rs.getString("month") + " " +rs.getString("day") + " " + rs.getString("year"));
                System.out.println("=============================================");
            }   
           con.close();
        }
        catch(Exception re)
        {
            System.out.println(re);
        }
    }

    
    //search by appointment number
    public void selectAppointment(String cid)
    {
        try
        {
            //Load Driver - Step #1
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Get Connection from the Driver - Step #2
                Connection con;
                con=DriverManager.getConnection(DBlocation);
                

            //Create a Statement - Step #3
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("Select * from Appointments where appointmentNumber = '" + cid + "'");
            //Print ResultSet
            
            rs.next();
            appointmentNumber = rs.getString("appointmentNumber");
            String year = rs.getString("year");
            String month = rs.getString("month");
            String day = rs.getString("day");
            String patId = rs.getString("patId");
            String patName = rs.getString("patName");
            String chiroId = rs.getString("chiroId");
            String chiroName = rs.getString("chiroName");
            
            a1.setAppointmentNumber(appointmentNumber);
            a1.setYear(year);
            a1.setMonth(month);
            a1.setDay(day);
            a1.setPatId(patId);
            a1.setPatName(patName);
            a1.setChiroId(chiroId);
            a1.setChiroName(chiroName);

            con.close();

        }   
     
        catch(Exception re)
        {
            System.out.println(re);
        }
    }
           
        
        
        
        public static void main(String args[]) 
        {
            
            /************Select and Display test*****************/
            DbAccess d1;
            d1 = new DbAccess();
            d1.selectPatientSchedule("1234");
            d1.a1.display();  
            
            /************Insert test*****************/

            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.insertChiropractorDB("6543", "bigShot", "Tex", "Goldberg", "TextGoldBerg@mail.com", "770-555-5125");
            
            //d1.c1.display();
            
            /************Update test*****************/
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectChiropractor("6");
            //d1.c1.setChiropractorFirstName("Sam");
            //d1.c1.setChiropractorPhone("678-555-5555");
            //d1.c1.setChiropractorEmail("samthompson@mail.com");           
            //d1.updateChiropractorDB();
            //d1.c1.display();
            /************Delete test*****************/
            //DbAccess d1;
            //d1 = new DbAccess();
            //d1.selectChiropractor("1");
            //d1.deleteChiropractorDB();

        
        }
}
