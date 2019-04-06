package com.cg.bms.UI;

import java.util.HashMap;
import java.util.Scanner;

import com.cg.bms.bean.Account;
import com.cg.bms.bean.Transaction;
import com.cg.bms.exception.AccountException;
import com.cg.bms.service.AccountService;
import com.cg.bms.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) throws AccountException{
		// TODO Auto-generated method stub
		AccountService service = new AccountServiceImpl();
		int ch = 0;
		long acNum=0;
		try(Scanner sc = new Scanner(System.in))
		{
			do
			{
				System.out.println("!!!Welcome To Payment Wallet XYZ!!!");
				System.out.println();
				System.out.println("Main Menu");
				System.out.println();
				System.out.print("1->Create New Account\n2->Display Account Details\n3->Deposit Money\n 4->withdrawl\n5->Fund Transfer\n6->Get Mini Statement\n7->Exit");
				System.out.println();
				System.out.println();
				System.out.println("Enter Your Choice: ");
				
				ch=sc.nextInt();
				
				switch(ch){
				
				case 1:{
					acNum+=1;
					System.out.print("\nEnter Your Name : ");
					String name = sc.next();
					System.out.print("\nEnter Bank IFSC : ");
					String ifsc = sc.next();
					double bal=0;
					do{
						System.out.print("\nEnter Current balance : ");
						bal = sc.nextDouble();
					}while(service.validateAccBal(bal));
					Account draftAc = new Account(acNum,name,ifsc,bal);
					Account ac = service.addAccount(draftAc);
					System.out.println("\nYour Account has been created Successfully.");
					System.out.println("Your Account Number is : "+ac.getAcc_no());
					break;
				}
				case 2:{
					System.out.print("\nEnter Your Account No. : ");
					long acn  = sc.nextLong();
					System.out.print("\nYour Account details are: \n");
					System.out.println(service.showAccount(acn));
					break;
				}
				case 3:{
					System.out.println("Enter Your Account No. : ");
					long acn  = sc.nextLong();
					System.out.print("\nEnter the Amount to be Deposited : ");
					double dep = sc.nextDouble();
					System.out.println("Transaction Id: "+service.deposit(acn, dep));
					System.out.println("Current Balance: "+service.showAccount(acn));
					break;
				}
				case 4:{
					System.out.print("\nEnter your Account No. : ");
					long acn  = sc.nextLong();
					System.out.print("\nPlease enter the Amount to be Withdrawn : ");
					double dep = sc.nextDouble();
					System.out.println(service.withdrawl(acn, dep));
					System.out.println(service.showAccount(acn));
					break;
				}
				case 5:{
					System.out.print("\nEnter Your Account No. : ");
					long acn1 = sc.nextLong();
					System.out.print("\nEnter the Recieving Account No. : ");
					long acn2 = sc.nextLong();
					System.out.print("\nEnter the Amount You Want to transferred : ");
					double amt = sc.nextDouble();
					if(service.transfer(acn1,acn2,amt)){
						System.out.println("Fund Transfer Successfully!!!");
						System.out.println(service.showAccount(acn1));
					}
					break;
				}
				case 6:{
					System.out.print("\n Enter Your Account No. : ");
					long acn  = sc.nextLong();
					System.out.print("\nYour last 5 transactions are;\n");
					HashMap<Long,Transaction> tsMap = service.showTransaction();
					if(tsMap.size()!=0){
						long[] keys = service.showTransIDs(acn);
						for(long key:keys){
							System.out.println(tsMap.get(key));
						}
					}
					break;
					
				}
				case 7: System.exit(0);
				}
				
				System.out.print("\nDo you want to continue 1->yes, 2->no : ");
				ch = sc.nextInt();
			}
			
			while(ch!=2);
		}
	}	
}