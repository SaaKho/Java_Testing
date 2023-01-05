import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class Q6Test {
    Q6 obj = new Q6();
    @Test
    public void stopWordSuccess(){
        //Q6 obj = new Q6();
        //String txt = "we are who we are and we should be selfless";
        assertTrue(obj.myQuestion());
    }
    public void stopWordFail(){
        String txt = "we are who we are and we should be selfless";
        assertTrue(obj.myQuestion());
    }
}
