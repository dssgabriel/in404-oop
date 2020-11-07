import java.util.Scanner;

public class SaisieRPN 
{
 	//Attributes
  	private Scanner scanner;
  	private MoteurRPN engine;

  	//Constructor
  	public SaisieRPN()
  	{
    	scanner = new Scanner(System.in);
    	engine = new MoteurRPN();
  	}

    //Check if value is in the range of the calculator
    public double check(CalculatriceRPN c)
    {
        return c.value();
    }

  	//Take input from user and add it to the stack if it's a number, process if it's an operator
  	public void input() 
  	{
        if (scanner.hasNextDouble())
        {
            double d = scanner.nextDouble();
            if (d <= check(CalculatriceRPN.MAX_VALUE) && d >= check(CalculatriceRPN.MIN_VALUE))
            {
                engine.save(d);
                engine.show();            
            }
            else 
                System.out.println("ERROR in input(): Input number is out of range");
        }
        else if (scanner.hasNextLine())
        {
            String sign = scanner.nextLine();
            double result;

            switch (sign)
            {
            	case "+":
            		result = engine.process(Operation.PLUS);
            		System.out.println("= " + result);
            		engine.show();
            		break;

            	case "-":
            		result = engine.process(Operation.MOINS);
            		System.out.println("= " + result);
            		engine.show();
            		break;

            	case "*":
            		result = engine.process(Operation.MULT);
            		System.out.println("= " + result);
            		engine.show();
            		break;

            	case "/":
            		result = engine.process(Operation.DIV);
            		System.out.println("= " + result);
            		engine.show();
            		break;

            	case "exit":
            		System.exit(0);
            }
        }
  	}
}
