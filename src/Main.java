import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub
		try {
			System.out.print("Enter your choice: \n1. Admin Login\n2. Employee Login\n");
			Scanner sc = new Scanner(System.in);
			int Choice = sc.nextInt();
			switch (Choice) {
			case 1:
				System.out.print("Welcome Admin\nEnter your Login Deatils \nUsername\n");
				Scanner sc1 = new Scanner(System.in);
				String AdminUsername =  sc1.nextLine();
				System.out.print("Password\n");
				String AdminPassword = sc1.nextLine();
				ResultSet rs = AdminLogin.AdminLogin(AdminUsername,AdminPassword);
				if(rs.next() == false) {
					System.out.print("Ivalid Username or Password");
					break;
				}else {
					System.out.print("Enter your Choice \n1. See Employee Details\n2. Delete Employee Detais\n3. Logout");
					Scanner sc2 = new Scanner(System.in);
					int AdminChoice = sc2.nextInt();
					switch (AdminChoice) {
					case 1:
						System.out.print("Enter Employee ID To View Their Details");
						Scanner sc3 = new Scanner(System.in);
						int AdminEmployeeId = sc3.nextInt();
						ResultSet rs1 = AdminLogin.EmployeeDeatils(AdminEmployeeId);
						while(rs1.next()){
							System.out.print("\nID : " +rs1.getString(1));
							System.out.print("\nUsername : "+rs1.getString(2));
							System.out.print("\nEmail Address : "+rs1.getString(3));
							System.out.print("\nContact Number : " +rs1.getString(4));
							break;
						}
						ResultSet rs2 = AdminLogin.EmployeeDeatils1(AdminEmployeeId);
						while(rs2.next()){
							System.out.print("\nWork Experence : "+rs2.getString(2));
							System.out.print("\nDate Of Birth : "+rs2.getString(3));
							System.out.print("\nMatrimonial Status : " +rs2.getString(4));
							System.out.print("\nNative Place : "+rs2.getString(5));
							System.out.print("\nFull Address : "+rs2.getString(6));
						}
						sc3.close();
						break;
					case 2:
						System.out.print("Enter Employee ID To View Their Details");
						Scanner sc13 = new Scanner(System.in);
						int AdminEmployeeDropId = sc13.nextInt();
						AdminLogin.AdminDropMethod(AdminEmployeeDropId);
						break;
					case 3:
						System.out.print("Logged Out Succesfully");
						break;
					default :
						System.out.print("Enter Correct Option");
						break;
					}
				sc2.close();
				}	
//			sc1.close();
			break;
			case 2:
				System.out.print("1. Login\n2. Register\n");
				Scanner sc3 = new Scanner(System.in);
				int EmployeeChoice = sc3.nextInt();
				switch(EmployeeChoice) {
				case 1:
					System.out.print("Welcome Employee\nEnter your Login Deatils \nUsername\n");
					Scanner sc4 = new Scanner(System.in);
					String EmployeeUsername =  sc4.nextLine();
					System.out.print("Password\n");
					String EmployeePassword = sc4.nextLine();
					ResultSet rs1 = EmployeeLogin.EmployeeLogin(EmployeeUsername,EmployeePassword);
					if(rs1.next() == false) {
						System.out.print("Deatils didnot match");
						break;
					}
					int count = 0;
					do {
						count = Integer.parseInt(rs1.getString(6));
					}while(rs1.next());
					if(count == 1) {
						System.out.print("Welcome to CorporateWelfareEmployee project as you are first time loging in please fill the following details:\n");
						Scanner sc5 = new Scanner(System.in);
						System.out.print("Enter Your ID Number:\n");
						int IDfirstLogin = sc5.nextInt();
						sc5.nextLine();
						System.out.print("Enter Your Work Experence till date(IF FRESHER type 0):\n");
						int WorkExperence = sc5.nextInt();
						sc5.nextLine();
						System.out.print("Enter your Date of Birth(DD-MM-YYYY):");
						String DOB = sc5.nextLine();
						System.out.print("Matrimonial Status:\n");
						String Matrimonial = sc5.nextLine();
						System.out.print("Native Location/Place:\n");
						String Native = sc5.nextLine();
						System.out.print("Full Home Address\n");
						String Address = sc5.nextLine();
						int a = EmployeeLogin.FirstTimeLogin(IDfirstLogin,WorkExperence,DOB,Matrimonial,Native,Address);
						if(a == 1 ) {
							System.out.print("\nDetails Updated Successfull");
						}
						sc5.close();
					}else {
						System.out.print("Select an Option:\n1. See Your Details\n2. Update you Deatils\n3. Logout");
						Scanner sc6 = new Scanner(System.in);
						int NormalLogin = sc6.nextInt();
						switch (NormalLogin) {
						case 1:
							ResultSet rs2 = EmployeeLogin.EmployeeSelfDeatils(EmployeeUsername,EmployeePassword);
							while(rs2.next()){
								System.out.print("ID:"+rs2.getString(1));
								System.out.print("\nUsername:"+rs2.getString(2));
								System.out.print("\nEmail:"+rs2.getString(3));
								System.out.print("\nContact Number:"+rs2.getString(4));
							}
							break;
						case 2:
							System.out.print("Select an Option:\n1. Update Password\n2. Update Email");
							Scanner sc7 = new Scanner(System.in);
							int UpdateEmployeeOption = sc7.nextInt();
							switch (UpdateEmployeeOption) {
							case 1:
								ResultSet rs3 = EmployeeLogin.EmployeeUpdateSelfDeatils(EmployeeUsername,EmployeePassword);
								String PreviousPassword = "";
								String ID1 ="";
								while(rs3.next()) {
									ID1 = rs3.getString(1);
									PreviousPassword =  rs3.getString(5);
								}
								Scanner sc8 = new Scanner(System.in);
								System.out.print("Enter Current Password:");
								String CurrentPassword = sc8.nextLine();
								if(CurrentPassword.equals(PreviousPassword)) {
									System.out.print("New Password:");
									Scanner sc9 = new Scanner(System.in);
									String NewPassword = sc9.nextLine();
									System.out.print("Confirm new Password");
									String ConfirmNewPassword = sc9.nextLine();
									if(NewPassword.equals(ConfirmNewPassword)) {
										boolean a = EmployeeLogin.UpdateEmployeePassword(NewPassword,ID1);
										if(a == false) {
											System.out.print("Password Changed");
										}else {
											System.out.print("Password Did not Changed");
										}
									}else {
										System.out.print("Password Not Matched");
									}
									sc9.close();
								}
								sc8.close();
								break;
							case 2:
								ResultSet rs4 = EmployeeLogin.EmployeeUpdateSelfDeatils(EmployeeUsername,EmployeePassword);
								String ID2 ="";
								while(rs4.next()) {
									ID2 = rs4.getString(1);
								}
								Scanner sc10 = new Scanner(System.in);
								System.out.print("Enter new Email");
								String NewEmail = sc10.nextLine();
								String OTP = String.valueOf(generateOTP.generateOTP(4));
								JavaMail.sentmail(NewEmail,OTP);
								System.out.print("Enter OTP sent to your mail for Verification\n");
								String otp = sc10.nextLine();
								if(OTP.equals(otp)) {
									boolean a = EmployeeLogin.UpdateEmail(NewEmail, ID2);
									if(a == false) {
										System.out.print("Email Updated Succesfully\n");
									}else {
										System.out.print("Email not update\n");
									}
								}
								sc10.close();
								break;
							default :
								System.out.print("Enter Proper Option\n");
								break;
							}
							break;
						case 3:
							System.out.print("Logout Succesfull\n");
							break;
						default :
							System.out.print("Enter Proper Option\n");
							break;
						}
						sc6.close();
					}
					sc4.close();
					break;
				case 2:
					System.out.print("Registration Form:\nEnter Your Details:\nID:\n");
					Scanner sc11 = new Scanner(System.in);
					int empid = sc11.nextInt();
					sc11.nextLine();
					System.out.print("Username:");
					String employeeRegisterUsername = sc11.nextLine();
					System.out.print("Phone Number");
					long phone = sc11.nextLong();
					sc11.nextLine();
					System.out.print("New Password:");
					String newpassword = sc11.nextLine();
					System.out.print("Confirm Password:");
					String confirmpassword = sc11.nextLine();
					System.out.print("Email:");
					String email = sc11.nextLine();
					String regex = "^(.+)@(.+)$";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(email);
					if((matcher.matches() == true) && confirmpassword.equals(newpassword)) {
						String OTP = String.valueOf(generateOTP.generateOTP(4));
						JavaMail.sentmail(email,OTP);
						System.out.print("Enter OTP sent to your mail for Registration\n");
						Scanner sc12 = new Scanner(System.in);
						String otp = sc12.nextLine();
						if(OTP.equals(otp)) {
							int a = Registration.Registration(empid,employeeRegisterUsername,phone,newpassword,email);
							if(a!=0) {
								System.out.print("Registration Succesfull\n");
							}
						}
						sc12.close();
					}else {
						System.out.print("Enter correct values\n");
					}
				}
				sc3.close();
			}	
		sc.close();
		}catch (ClassNotFoundException e) {
			System.out.println("Driver Class Not Found ! Exeception Occured!\n");
		}catch (SQLException se) {
			System.out.println("Excetion Error occured while Creating a connection!\n");
			System.out.print(se);
		}
	}
}