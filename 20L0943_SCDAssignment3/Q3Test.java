import static org.junit.Assert.*;
import org.junit.Test;
public class Q3Test
{
    Q3 obj = new Q3();
    @Test
    public void testMytempBalanceSuccess()
    {
        String eq = "((()))";
        assertTrue(eq, obj.mytempBalance(eq));
    }
    @Test
    public void method1Success()
    {
        String eq = "(";
        assertEquals("()", obj.mytempBalance(eq));
    }
    @Test
    public void bracketMultiplySuccess()
    {
        String eq = "()))";
        assertTrue("((()))", obj.mytempBalance(eq));
    }
}
