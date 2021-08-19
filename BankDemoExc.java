import java.util.Scanner;  
 import java.util.Random;  
 import java.lang.Exception;  
   
 class MyException extends Exception  
 {  
      MyException(String message)  
      {  
           super(message);  
      }  
 }  
   
 interface Account  
 {  
      void CreateAcc();  
      void Withdraw();  
 }  
   
 class BankInfo 
 {  
      int acctype,year=1,accnum;  
      float intr;  
      String name="";  
      Scanner in = new Scanner(System.in);  
      Random rnd = new Random();  
      double temp=0.0,bal=0.0;  
        
 }  
   
 class Bank extends BankInfo implements Account  
 {  
        
        
       void getInfo()  
       {  
           try  
           {       
                  
                System.out.print("Enter Name: ");  
                name=in.nextLine();  
                  
                  
                  
                     System.out.println("Mention account type:\n1.Savings \t2.Current  ");  
                     acctype=in.nextInt();  
                     switch(acctype)  
                     {  
                          case 1:  
                               System.out.println("Enter the initial amount of deposit:");  
                                temp=in.nextFloat();  
                               if(temp<0)  
                               {  
                                    System.out.println("Invalid Amount\nTry again:\n");  
                                    System.out.println("Enter the initial amount of deposit:");  
                                    temp=in.nextFloat();  
                               }  
                               
                                 
                          break;  
                            
                          case 2:  
                               System.out.println("Enter the initial amount of deposit:");  
                                temp=in.nextFloat();  
                                if(temp<0)  
                               {  
                                    System.out.println("Invalid Amount\nTry again:\n");  
                                    System.out.println("Enter the initial amount of deposit:");  
                                    temp=in.nextFloat();  
                               }  
                          break;  
                            
                          default: System.out.println("Invalid Option");  
                     } //Switch  
                  
                  
           }  
           catch(Exception e)  
           {  
                System.out.println("Inbuilt Exception --> "+e);  
                System.exit(0);  
           }  
        
      }//getInfo  
        
      public void CreateAcc()   
      {  
           try  
           {  
           getInfo();  
           System.out.println("\nAccount Successfully Created!");  
           accnum=rnd.nextInt(1000)+1;  
           System.out.println("Hello "+name+" your account no is " +accnum+".\n");  
           }  
           catch(Exception e)  
           {  
                System.out.println("Fatal Error");  
           }  
      }  
        
      
        
      
        
      public void Withdraw()// regular deposit  
      {  
        
           System.out.println("Enter the amount to be withdrawn :");  
           temp=in.nextFloat();  
           if(temp<=0)  
           {  
                System.out.println("Invalid Amount Error.");  
                System.exit(0);  
           }  
             
           try  
           {  
        
                if(temp<bal)  
                {  
                     bal-=temp;  
                     System.out.println("SUCCESSFULLY DEBITED");  
                }  
                else  
                {  
                     throw new MyException("INSUFFIECEINT AMOUNT EXCEPTION");  
                }  
           }  
           catch(MyException e)  
           {  
                System.out.println(e.getMessage());  
                System.out.println("TRANSACTION FAILURE");  
           }  
        
      }  
     
        
 }  
   
   
 class BankDemoExc   
 {  
      public static void main(String arg[]) throws MyException  
      {  
           Scanner in = new Scanner(System.in);  
           Bank b = new Bank();  
             
           System.out.println("\n\n\t----Bank Simulator----");  
           try  
           {  
                while(true)  
                {  
           System.out.println("1.Create Account\t2.Withdraw\t3.Exit.");  
                int ch = in.nextInt();  
                     switch(ch)  
                     {  
                          case 1:  
                          b.CreateAcc();  
                          break;  
                            
                           
                            
                          case 2:  
                          b.Withdraw();  
                          break;  
                            
                          
                            
                          case 3:  
                          System.exit(0);  
                          break;  
                            
                          default: System.out.println("Invalid Option");  
                     }  
                }  
           }  
           catch(Exception e)  
           {  
                System.out.println("SELF THROWN EXCEPTION IS--->"+e);  
           }  
      }  
 }  
