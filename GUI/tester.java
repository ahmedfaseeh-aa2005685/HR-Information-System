import java.util.ArrayList;

public class tester {

	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<>();
		
		
		arr.add("Faseeh");
		arr.add("Haris");
		
		String allowance_name = String.join(",",arr);
		System.out.println(allowance_name);
		
	}
	
}
