import java.util.Scanner;
   
 
public class AccountMgr{

    private static Account[] accounts = new Account[100];
    private static int index = 0;//계좌번호들 저장..

    public static int retrieveIndexByAccount_no(String Account_no){
        for(int i=0; i<index; i++){
            if(accounts[i].getAccount_no().equals(Account_no)){
                return i;
            }
        }return -1;
    }
 
    //계좌개설 메소드
    public static void createAccount(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("계좌번호 : ");
        String Account_no=scan.nextLine();
 
        System.out.print("이름 : ");
        String owner=scan.nextLine();
 
        System.out.print("비밀번호 : ");
        String password=scan.nextLine();
 
        System.out.print("금액 : "); 
        int balance=scan.nextInt();
 
        System.out.println("고객 계좌가 개설되었습니다.");
    }
    //잔액 조회
    public static void retrieveBalance(){
        Scanner scan = new Scanner(System.in);
        System.out.print("계좌번호를 입력하세요");
        String Account_no = scan.nextLine();
       
        int index = retrieveIndexByAccount_no(Account_no);
        if(index != -1){
            System.out.printf("계좌번호 %d%n", accounts[index].getBalance());
        }else{
            System.out.println("계좌번호가 존재하지 않습니다.");
        }
    }
 
    //입금
    public static void checkIn(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("계좌번호를 입력하세요");
        String Account_no = scan.nextLine();
 
        System.out.print("입금액 : ");
        int amount = scan.nextInt();
 
        int index = retrieveIndexByAccount_no(Account_no);
        if(index != -1){           
            accounts[index].deposit(amount);
        }else{
            System.out.println("계좌번호가 존재하지 않습니다.");
        }
       
    }
 
    //출금
    public static void checkOut(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("계좌번호를 입력하세요");
        String Account_no = scan.nextLine();
        System.out.print("비밀번호를 입력하세요");
        String password = scan.nextLine();
        System.out.print("출금액 : ");
        int amount = scan.nextInt();       
 
        int index = retrieveIndexByAccount_no(Account_no);
        if(index == -1){
            System.out.println("계좌번호가 존재하지 않습니다.");
        }else{
            if(!accounts[index].getpassword().equals(password)){
                System.out.println("비밀번호가 일치하지 않습니다.");
                return;
            }
            accounts[index].withdraw(amount);
            System.out.printf("%d 원이 인출되었습니다.%n", amount);
        }
    }
 
    //전체 고객 계좌 정보를 조회하다.
    public static void retrieveAccountList(){
        for(int i=0; i<index; i++){
            System.out.printf("%s%n", accounts[i].getAccountInfo());
        }
    }
 
    public static void main(String[] args){
       
        Account[] obj = new Account[10];
 
        Scanner scan = new Scanner(System.in);
        boolean isExit = false;
        do{
            System.out.println("====== 은행 입출금 관리 시스템 ======");
            System.out.println("1. 계좌 개설");
            System.out.println("2. 잔액 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 전체고객계좌조회");
            System.out.println("6. 종료");
            System.out.println("항목을 선택하세요");
 
            int menu = scan.nextInt();
            switch(menu){
                case 1:
                    System.out.println("계좌 개설");
                    createAccount();
                    break;
                case 2:
                    System.out.println("잔액 조회");
                    retrieveBalance();
                    break;
                case 3:
                    System.out.println("입금");
                    checkIn();
                    break;
                case 4:
                    System.out.println("출금");
                    checkOut();
                    break;
                case 5:
                    System.out.println("전체고객조회");
                    retrieveAccountList();
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
 
            }
        }while(!isExit);
    }
}