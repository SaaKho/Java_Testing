import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    void thedayshouldbesunday()
    {
        assertEquals("TUESDAY", Main.main(16, 8, 2022));
    }
    @Test
    void TestFailed()
    {assertEquals("false",Main.main(15,21,2022));}
}