import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
public class Q3
{
    String equation;
    String copyequation;
    private Stack<Bracket> stack;
    private HashMap<Character, Integer> myhash;
    public void enterEquation()
    {
        System.out.println("\nEnter equation you want to enter");
        Scanner in= new Scanner (System.in);
        equation=in.nextLine();
    }

    public void balancer(int index1)
    {
        StringBuilder sb = new StringBuilder(equation);
        sb.deleteCharAt(index1);
        equation=sb.toString();
        mytempBalance(equation);

    }
    public Q3()
    {equation = "2*2*2+7" ;}
    public boolean isInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
        } catch(NumberFormatException e)
        {
            return false;
        } catch(NullPointerException e)
        {
            return false;
        }
        return true;
    }

    public boolean mytempBalance(String eq)
    {
        Stack<Bracket> obj = new Stack<Bracket>();

        for (int i = 0; i < equation.length(); i++) {
            char x = equation.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                Bracket temp= new Bracket (x,i);
                obj.push(temp);
            }

            if (x == ')' || x == ']' || x == '}')
            {
                if(obj.isEmpty())
                {
                    balancer(i);
                    return false;
                }

            }
            Bracket temp2;
            char mytemp;

            switch (x) {
                case ')':
                    temp2 = obj.pop();
                    mytemp =temp2.getSymbol();
                    if (mytemp == '{' || mytemp == '[')
                    {
                        balancer(temp2.getIndex());
                        return false;
                    }
                    break;
                case '}':
                    temp2 = obj.pop();
                    mytemp =temp2.getSymbol();
                    if (mytemp == '(' || mytemp == '[')
                    {
                        balancer(temp2.getIndex());
                        return false;
                    }
                    break;
                case ']':
                    temp2 = obj.pop();
                    mytemp =temp2.getSymbol();
                    if (mytemp == '(' || mytemp == '{')
                    {
                        balancer(temp2.getIndex());
                        return false;
                    }
                    break;
            }

        }
        if(!obj.isEmpty())
        {
            Bracket temp2;
            temp2 = obj.pop();
            balancer(temp2.getIndex());
            return false;
        }
        return true;
    }


    public void method1(String temp2)
    {
        Stack<Double> stack2=new Stack<Double>();
        stack2.push(0.0);
        stack2.push(0.0);
        char temp;
        for (int i = 0; i < temp2.length(); i++)
        {
            temp = temp2.charAt(i);
            if (Character.isLetter(temp))
            {
                double value=myhash.get(temp);
                stack2.push(value);
            }
            else
            {

                double v1=0,v2=0;
                if(!stack2.empty())
                {
                    v1=stack2.pop();
                    v2=stack2.pop();

                }
                if(temp=='*')
                {
                    double answer=v1*v2;
                    stack2.push(answer);
                }
                if(temp=='+')
                {
                    double answer=v1+v2;
                    stack2.push(answer);
                }
                if(temp=='/')
                {
                    if(v2==0)
                    {
                        System.out.print("cannot divide by zero");
                        return;
                    }
                    double answer=v2/v1;
                    stack2.push(answer);
                }
                if(temp=='-')
                {
                    double answer=v2-v1;
                    stack2.push(answer);
                }
            }
        }
        System.out.println("Answer="+stack2.peek());
    }

    public void bracketMultiply(String eq)
    {
        for (int i = 0; i < equation.length(); i++) {
            char x = equation.charAt(i);

            if (x == ')' && i+1<equation.length() && equation.charAt(i+1)=='(')
            {

                equation= new StringBuilder(equation).insert(i+1, "*").toString();
                break;
            }

        }
    }
    public void myQuestion()
    {
//        System.out.print(equation);
        enterEquation();
        mytempBalance(equation);
//
        bracketMultiply(equation);
        System.out.println("After balancing "+ equation+"\n");
        convertIntoHash ();
        replaceAll();
        System.out.println("\n1:For method 1");
        System.out.println("2:For method 2");
        Scanner sc =new Scanner (System.in);
        int method=sc.nextInt();
        String temp=toPostfix(method);
        System.out.println(temp);

        method1(temp);
    }
    public void replaceAll()
    {
        copyequation=equation;
        for ( Character key : myhash.keySet() ) {


            String temp="";
            temp=temp+key;
            int value=myhash.get(key);
            equation=equation.replaceAll(Integer.toString(value),temp);
        }



    }
    //convert into hashmap
    public void convertIntoHash()
    {
        myhash=new HashMap<Character,Integer> ();
        String mystring="";
        Character chr = 'A';
        char temp;

        int i=0;
        String[] splitted=equation.split("[-+*/=(){}\\[\\]]");
        int flag=0;
        while(i<splitted.length)
        {
            if(isInteger(splitted[i])){
                mystring=splitted[i];
                myhash.put(chr, Integer.parseInt(mystring));
                chr++;

            }
            i++;
        }
        System.out.print(myhash.values()+" ");


    }
    public String toPostfix(int method)
    {

        Stack<Character> tempStacks = new Stack<Character>();
        char temp;
        String newEquation = "";
        for(int i=0;i<equation.length();++i)
        {
            temp = equation.charAt(i);
            if (Character.isLetter(temp))
                newEquation = newEquation + temp;
            else if (temp=='(')
            {
                tempStacks.push(temp);
            }
            else if (temp==')')
            {
                while (tempStacks.peek() != '(')
                {
                    newEquation = newEquation + tempStacks.pop();
                }
                tempStacks.pop();
            }
            else if (temp=='}')
            {
                while (tempStacks.peek() != '{')
                {
                    newEquation = newEquation + tempStacks.pop();
                }
                tempStacks.pop();
            }
            else if (temp==']')
            //push everything back to (
            {
                while (tempStacks.peek() != '[')
                {
                    newEquation = newEquation + tempStacks.pop();
                }
                tempStacks.pop();
            }
            else

            {
                if(method==2){
                    while (!tempStacks.isEmpty() && !(tempStacks.peek()=='(') &&  prec(temp) <= prec(tempStacks.peek()))
                        newEquation = newEquation + tempStacks.pop();  }
                if(method==1){
                    while (!tempStacks.isEmpty() && !(tempStacks.peek()=='('))
                        newEquation = newEquation + tempStacks.pop();  }
                tempStacks.push(temp);
            }
        }
        while (!tempStacks.isEmpty())
        {
            newEquation = newEquation + tempStacks.pop();
        }
        return newEquation;
    }
    public int prec(char x)
    {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
    public class Bracket {
        char symbol;
        int index;

        public Bracket(char symbol, int index) {
            this.symbol = symbol;
            this.index = index;
        }

        public char getSymbol() {
            return symbol;
        }

        public int getIndex() {
            return index;
        }


    }
}



