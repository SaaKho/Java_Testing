import org.junit.jupiter.api.Test;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;



public class Q4Test
{
    @Test
    void sortStacksuccessfully()
    {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        stack.push(19);
        stack.push(44);
        stack.push(21);
        stack.push(9);
        stack.push(192);
        stack.push(1021);

        Stack<Integer> expected = new Stack<Integer>();
        expected.push(9);
        expected.push(19);
        expected.push(21);
        expected.push(44);
        expected.push(192);
        expected.push(1021);

        Q4 a = new Q4();
        assertEquals(expected,a.sortStack(stack,temp));
    }
}


