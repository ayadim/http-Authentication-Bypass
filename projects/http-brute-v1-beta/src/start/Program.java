package start;

import control.Control;
import model.Http_Authentication_basic;
import view.GUI_Main;

public class Program {

	public static void main(String[] args) {
		
		Control ctrl = new Control();
		GUI_Main mainView = new GUI_Main(ctrl);
		
		Http_Authentication_basic myApp = new Http_Authentication_basic();
		
		if(myApp.checkAuthentication("http://www.angelafarisbelt.com/wp-includes/pent/challenge_02/medium-beta/getflag.php", "admin", "bronchoconstriction"))
			System.out.println("pass correct ! ");
		else
			System.out.print("pass is not correct");
	}

}
