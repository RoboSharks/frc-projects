
public class printstars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 4; i++) {
			//
		for (int j = 2; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++ ) {				
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
		for (int k = 3; k >= 1; k--) {
			
			for (int l = 0; l < k; l++){
				
				System.out.print("*");
			}
			
			System.out.println("");

		}
	
		
	}

}
