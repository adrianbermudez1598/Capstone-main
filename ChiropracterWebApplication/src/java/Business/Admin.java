
package Business;

/**
 *
 * @author Jaru
 */
public class Admin 
{
    private String id, password;
    private int count;
    public AppointmentsList aList = new AppointmentsList();
    
    public Admin()
    {
        id = " ";
        password = " ";
    }
    
    public Admin(String id, String password)
    {
        this.id=id;
        this.password = password;
    }
    
    public void setAdminID(String aID){id =aID;}
    public String getAdminID(){return id;}
    
    public void setAdminPassword(String pwd){password=pwd;}
    public String getAdminPassword(){return password;}
    
    public void setCount(int c){count=c;}
    public int getCount() {return count;}
    
    public void display()
    {
        System.out.println("Admin ID: " + getAdminID());
        System.out.println("Password: "+getAdminPassword());
    }
    
    public static void main(String[] args)
    {
       // DbAccess d1;
         //   d1 = new DbAccess();
         //   d1.selectAdmin("4321");
          //  d1.ad1.display();
    }
    
}
