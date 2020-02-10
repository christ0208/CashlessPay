package validators;

public class EmailValidator extends BaseValidator{

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean validate(String input) {
		if(input.indexOf(".") == -1 || input.indexOf("@") == -1) return false;
		else if(input.startsWith(".") || input.endsWith(".")) return false;
		else if(input.startsWith("@") || input.endsWith("@")) return false;
		else if(Math.abs(input.lastIndexOf(".") - input.indexOf("@")) == 1) return false;
		
		return true;
	}

}
