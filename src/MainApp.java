import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
public static void adduser () throws SQLException{
	Scanner in = new Scanner(System.in);
	String username , pass, fullname , email;
	System.out.println("insert data (username pass fullname email)");
	username=in.next();
	pass=in.next();
	fullname=in.next();
	email=in.next();
	CRUD.INSERT(username, pass, fullname, email);
	
}
public static void deleteuser () throws SQLException{
	Scanner in = new Scanner(System.in);
	System.out.println("input username : ");
	String UserName =in.next();
	CRUD.DELETE(UserName);
	}
public static void updateuser () throws SQLException{
	Scanner in = new Scanner(System.in);
	System.out.println("input username : ");
	String UserName =in.next();
	CRUD.UPDATE(UserName);
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//CRUD.INSERT("Oleg", "12345", "OLEG KOVAL", "oleg111koval@gmail.com");
		//CRUD.DELETE("Oleg");
		Scanner in = new Scanner(System.in);
		
		String dec;
		do{
		System.out.println("choose option:\n1-select all users \n 2-insert new user "
				+ "\n 3-Delete user \n 4-Update user \n e-Exit");
		
		dec = in.next();
		switch(Integer.parseInt(dec))
		{
		case 1: 
			CRUD.SELECT();
			break;
		case 2: 
			adduser();
			break;
		case 3:
			deleteuser();
			break;
		case 4: //
			updateuser();
			break;
			default:
		
		}
		}while (!dec.equals("e"));
	
	
	}

}
