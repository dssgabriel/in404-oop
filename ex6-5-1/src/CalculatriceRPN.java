public enum CalculatriceRPN 
{	
	MIN_VALUE(-65535)
	{
		public double value()
		{
			return -65535;
		}
	},
	MAX_VALUE(65536)
	{
		public double value()
		{
			return 65536;
		}
	};

	//Main program
	public static void main(String[] args) 
  	{
    	SaisieRPN calc = new SaisieRPN();
    	System.out.println("\nType 'exit' to quit the program");
    	System.out.println("Maximum recognized value by the calculator: " + MAX_VALUE.value());
    	System.out.println("Minimum recognized value by the calculator: " + MIN_VALUE.value());
     	System.out.println("Input numbers or operators:");

    	while(true) 
    		calc.input();
  	}

  	//Attributes
  	public double value;

  	 //Constructor
  	CalculatriceRPN(double value) 
  	{
  		this.value = value;
  	}

  	public abstract double value();
}
