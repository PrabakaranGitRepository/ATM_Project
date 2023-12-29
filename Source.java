
import java.util.Scanner;
import java.time.LocalDate;//To include Date alone
import java.time.LocalTime;//To include Time alone


class Source {
private Scanner input = new Scanner(System.in);  // Creating input object

private LocalDate current_Date = LocalDate.now();  //to print Date
 private LocalTime current_Time = LocalTime.now(); //to print Time



 //


    private int total_Balance = 10000; //Let's Assume
    private String name = "Prabakaran";
    private int account_number = 123456789;//Let's Assume
    private int pin = 3232; //Let's Assume

    private int br = 0;


 public Source(){

    check_Acc_no_Pin_no();

    }

    public void choice(){

    while(true){
        

            //Switch cases

            System.out.println("Enter 1 for AddAmount");
            System.out.println("Enter 2 for WithdrawAmount");
            System.out.println("Enter 3 for Chack Balance");
            System.out.println("Enter 4 Transfer Amount");
            System.out.println("Enter 5 for Exit");
            //geting input
            int op = input.nextInt();

            switch(op){
                case 1 -> addAmount();

                case 2 -> withdrawalAmount();

                case 3 -> checkBalance();

                case 4 -> transfer();

                case 5 -> System.exit(0);
            }

            if(br==1){
                break;
            }
            
        }

        System.out.println("Thankyou " + name + " Have a Nice Day");

        
    }

    public void check_Acc_no_Pin_no(){

        System.out.println("Enter your 9 digite Account Number:");
        int user_account_number = input.nextInt();
        System.out.println("Enter your 4 digite Pin Number");
        int user_pin = input.nextInt();

        if (user_account_number == account_number  && user_pin == pin) {

            System.out.println("\t\t\t\tWELCOME " + name);
            choice();


    }

    else{
            System.out.println("Incorrect Account Number or PassWord.");
            System.out.println("Triagain \n Enter 1 to Contineu. \n Enter 2 to Exit.");

            int op = input.nextInt();

            if(op==1){
                check_Acc_no_Pin_no();
            }
            else if(op==2){
                br=1;

                 System.out.println("Thankyou " + name + " Have a Nice Day");
            }
            
        }

    

 }



    public void withdrawalAmount(){

         System.out.println("Enter the Amount");
        int with_amount = input.nextInt();

        if(total_Balance>= with_amount){
            total_Balance = total_Balance - with_amount ;

            System.out.println("Enter 1 to get recepit");
            System.out.println("Enter 2 to Contineu");

            int op_re = input.nextInt();

            if(op_re == 1){
                receipt();
            }

            System.out.println("Amount Withdrawaled Successfully");
        }

        else{
            System.out.println("You'er BankBalance in Insaficient!!...");

            int op;

            System.out.println("Enter 1 to Check Balance.");
            System.out.println("Enter 2 to Triagain.");


            op = input.nextInt();
            if(op == 1){
                System.out.println("You Current Balance is : " + total_Balance);
            }
        }
        
    }

    public void addAmount(){

        System.out.println("Enter the Amount");
        int add_amount = input.nextInt();

        total_Balance += add_amount;

         System.out.println("Enter 1 to get recepit");
            System.out.println("Enter 2 to Contineu");

            int op_re = input.nextInt();

            if(op_re == 1){
                receipt();
            }
        System.out.println("Amount added Sucessfully");
    }

    public void checkBalance(){
        System.out.println("Your Current Balance is : " + total_Balance);
    }

    public void transfer(){

         System.out.println("Enter the Amount");
        int transfer_amount = input.nextInt();

        if(total_Balance>=transfer_amount){
            int acc_no;
            System.out.println("Enter the Account Number");
            acc_no = input.nextInt();

            total_Balance -= transfer_amount;
            System.out.println("Amount Sent to " + acc_no + "Account Number Sucessfully.");

            System.out.println("Enter 1 to take a Receipt :");
            System.out.println("Enter 2 to Exit:");

            int op = input.nextInt();

            if (op==1) {
                receipt();
            }
        }

        else{
            System.out.println("You have Insufficient BankBalance.");
        }
    }


    //Receipt

    private void receipt(){

        System.out.println();
        System.out.println();
        System.out.println("                  XYZ BANK OF INDIA.");
        System.out.println("Date :"                  + current_Date);
        System.out.println("Time :"                  + current_Time);
        System.out.println("Account Balance is :"     + total_Balance);
        System.out.println();
        System.out.println();

    }

}