import java.util.*;
import java.util.Stack;

public class Q4
{
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> temp = new Stack<Integer>();

    public void pushInStack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter how many elements you want to push in stacks");
        int total = sc.nextInt();
        System.out.println("\nEnter Elements");
        for (int i = 0; i < total; i++) {

            int temp = sc.nextInt();
            stack.push(temp);
        }
    }
    public Stack<Integer> sortStack(Stack<Integer> stack, Stack<Integer>temp)
    {
        while (!stack.empty())
        {
            int temNumber = stack.pop();
            while (!temp.isEmpty() && temp.peek() > temNumber)
            {
                stack.push(temp.pop());
            }
            temp.push(temNumber);
        }
        return temp;
    }

    public void showStack(Stack<Integer> stack1)
    {
        for (int i = 0; i < stack1.size(); i++)
        {
            System.out.print(stack1.get(i) + " ");
        }
    }
}
