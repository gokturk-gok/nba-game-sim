/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own without any help from anyone else.
The effort in the project thus belongs completely to me. I did not search for a solution, or I did not consult
any program written by others or did not copy any program from other sources. I read and followed the guidelines
provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Göktürk Gök, 83439>
*************************************************************************/
package main;

import java.awt.FontFormatException;
import java.io.IOException;

import user.LoginUI;

public class Main {
	public static void main(String[] args) {
		/**
		 * Main method only calls the constructor of the LoginUI();
		 * which is also the welcome page of the game.
		 * @author Göktürk Gök
		 */
		try {
			new LoginUI();
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
