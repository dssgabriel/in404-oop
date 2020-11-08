public class RPNEngine {
  	public MyStack stack;

  	public RPNEngine() {
    	stack = new MyStack();
  	}

  	public void save(Double item) { 
  		stack.myPush(item); 
  	}

  	public double process(Operation o) {
    	if (stack.getLen() < 2) {
      		System.out.println("Error: process(): Not enough numbers in the stack");
      		return (double)-1;
        } else {
      		Double num1 = stack.myPop();
      		Double num2 = stack.myPop();
      		stack.myPush(o.eval(num1, num2));
      		return stack.myPeek();
    	}
  	}

    public void show() {	
    	MyStack tmp = new MyStack();
        while (!this.stack.isEmpty()) { 
        	tmp.myPush(this.stack.myPop());
        }
        System.out.print("Current expression: ");
        while (!tmp.isEmpty()) {
        	this.stack.myPush(tmp.myPop());
        	System.out.print(this.stack.myPeek() + " ");
        } 
        System.out.println();
    }
}
