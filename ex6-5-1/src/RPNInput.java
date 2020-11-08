import java.util.Scanner;

public class RPNInput {
  	private Scanner scanner;
  	private RPNEngine engine;

  	public RPNInput() {
    	scanner = new Scanner(System.in);
    	engine = new RPNEngine();
  	}

    public double check(RPNCalculator c) {
        return c.value();
    }

  	public void input() {
        if (scanner.hasNextDouble()) {
            double d = scanner.nextDouble();
            if (d <= check(RPNCalculator.MAX_VALUE) && d >= check(RPNCalculator.MIN_VALUE)) {
                engine.save(d);
                engine.show();            
            } else { 
                System.out.println("Error: input(): Input value is out of range");
            }
        } else if (scanner.hasNextLine()) {
            String sign = scanner.nextLine();
            double result;
            switch (sign) {
            	case "+":
            		result = engine.process(Operation.PLUS);
            		System.out.println("= " + result);
            		engine.show();
            		break;
            	case "-":
            		result = engine.process(Operation.MINUS);
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
