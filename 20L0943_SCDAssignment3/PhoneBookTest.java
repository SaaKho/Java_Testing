import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import org.junit.Test;

public class PhoneBookTest
{
    PhoneBook p1 =new PhoneBook();
    String name = p1.setname();
    String name2 = p1.localname;
    @Test
    public void SetnameTest()
    {
        System.out.println("\n\n---=------------  SetName Test ------------------\n\n");
        assertEquals(name, name2);
    }


    @Test
    public void SetmobilenoTest()
    {
        System.out.println("\n\n---=------------  SetMobileNo Test ------------------\n\n");
        var p1 =new PhoneBook();
        String phone1=p1.setmobileno();
        assertEquals(phone1,p1.localmobileno );

    }

    @Test
    public void SetemailTest()
    {
        System.out.println("\n\n---=------------  SetEMail Test ------------------\n\n");
        var p1 =new PhoneBook();
        String email1=p1.setemail();
        assertEquals(email1,p1.localemail );
    }

    @Test
    public void SetCityTest() {

        System.out.println("\n\n---=------------  SetCity Test ------------------\n\n");
        var p1 =new PhoneBook();
        String city=p1.setcity();
        assertEquals(city,p1.localcity );
    }

    @Test
    public void SetNationalityTest()
    {
        System.out.println("\n\n---=------------  SetNationality Test ------------------\n\n");
        var p1 =new PhoneBook();
        String nationality=p1.setnationality();
        assertEquals(nationality,p1.localnationality );
    }

    @Test
    public void InsertTest()
    {
        System.out.println("\n\n---=------------  Insert Test ------------------\n\n");
        var p1= new PhoneBook();
        assertTrue( p1.insert());
    }

    @Test
    public void ViewTest()
    {
        System.out.println("\n\n---=------------  View Test ------------------\n\n");
        var p1= new PhoneBook();
        assertTrue( p1.view());
    }

    @Test
    public void EditTest()
    {
        System.out.println("\n\n---=------------  Edit Test ------------------\n\n");
        var p1= new PhoneBook();
        assertTrue( p1.edit());
    }

    @Test
    public void SearchTest() {
        System.out.println("\n\n---=------------  Search Test ------------------\n\n");
        var p1= new PhoneBook();
        p1.insert();
        assertTrue( p1.search());
    }
    @Test
    public void DeleteParticularTest() {
        System.out.println("\n\n---=------------  Delete Specific Test ------------------\n\n");
        var p1= new PhoneBook();
        p1.insert();
        assertTrue( p1.deleteparticular());
    }
    @Test
    public void DeleteAllTest() {
        System.out.println("\n\n---=------------  Delete ALL Test ------------------\n\n");
        var p1= new PhoneBook();

        p1.insert();
        assertTrue( p1.deleteall());
    }
}
