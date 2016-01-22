package start;

import model.Http_Authentication_basic;

public class Program {

	public static void main(String[] args) {
		
		Http_Authentication_basic myApp = new Http_Authentication_basic();
		
		if(myApp.checkAuthentication("http://www.angelafarisbelt.com/wp-includes/pent/challenge_02/medium-beta/getflag.php", "admin", "bronchoconstriction"))
			System.out.println("pass correct ! ");
		else
			System.out.print("pass is not correct");
	}

}
