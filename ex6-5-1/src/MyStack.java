import java.util.*;

public class MyStack 
  {
    //Attributes
	  private Stack<Double> stack;
    private int len;

    //Constructor
    public MyStack()
      {
  		  this.stack = new Stack<Double>();
  		  this.len = 0;
      }
 	
  	//Return stack
  	public Stack<Double> getStack() 
      {  
  		  return this.stack;
      }

  	//Return stack's length
  	public int getLen()
  	{
  		return this.len;
  	}

  	//Check if stack is empty
  	public boolean isEmpty()
  	{
  		return this.stack.empty();
  	}

  	//Push item in the stack
  	public void myPush(Double item)
  	{
  		this.len += 1;
  		this.stack.push(item);
  	}

  	//Print the item at the top of the stack
  	public Double myPeek() throws EmptyStackException
  	{
    	try 
    	{
    		double peek = this.stack.peek();
      		return peek;
    	}
    	catch(EmptyStackException except) 
    	{
      		System.out.println("ERROR in stack.peek(): Stack is empty");
      		return (double)-1;
    	}
  	}

  	//Pop the item at the top of the stack
  	public Double myPop() throws EmptyStackException
  	{
  		try
  		{
    		this.len -= 1;
  			return this.stack.pop();
  		}
  		catch(EmptyStackException except)
  		{
  			System.out.println("ERROR in stack.pop(): Stack is empty");
      		return (double)-1;
  		}
  	}
}