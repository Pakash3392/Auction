import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;

public class Register {

	static Register user = new Register();
	String username;
	String password;
	String firstName;
	String lastName;
	int id;
	
	
	public static void main(String[] args)throws Exception 
	{

		Scanner scan = new Scanner(System.in);

		System.out.println ("Set Username");
		user.username = scan.nextLine();
		
		System.out.println ("Set Password");
		user.password = scan.nextLine();

		System.out.println("First name");
		user.firstName = scan.nextLine();

		System.out.println("Last name");
		user.lastName = scan.nextLine();
		
		
		File log = new File("LoginCredentials.txt");
		//creates a new file
			    if(log.exists()==false)
			    {
			            log.createNewFile();
			    }
			    PrintWriter out1 = new PrintWriter(new FileWriter(log, true));
			    //append is used to insert into the end of a file without affecting any other data in it
			    //I have no idea why but putting it all on one line with /n doesn't work so I'm using system.getproperty but I 
			    //have no idea how that works, someone on stack overflow just said it would
			    out1.append(user.username);
			    out1.append(System.getProperty("line.separator"));
			    out1.append(user.password);
			    out1.append(System.getProperty("line.separator"));
			    out1.append(System.getProperty("line.separator"));
			    out1.close();
			    

			
			    
			    System.out.println ("[username=" + user.username + ", password=" + user.password + ", firstName=" + user.firstName + ", lastName="
				+ user.lastName + ", id=" + user.id + "]");
			
	}

	
	
	
}
