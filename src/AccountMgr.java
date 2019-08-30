import java.util.Scanner;
   
 
public class AccountMgr{

    private static Account[] accounts = new Account[100];
    private static int index = 0;//���¹�ȣ�� ����..

    public static int retrieveIndexByAccount_no(String Account_no){
        for(int i=0; i<index; i++){
            if(accounts[i].getAccount_no().equals(Account_no)){
                return i;
            }
        }return -1;
    }
 
    //���°��� �޼ҵ�
    public static void createAccount(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("���¹�ȣ : ");
        String Account_no=scan.nextLine();
 
        System.out.print("�̸� : ");
        String owner=scan.nextLine();
 
        System.out.print("��й�ȣ : ");
        String password=scan.nextLine();
 
        System.out.print("�ݾ� : "); 
        int balance=scan.nextInt();
 
        System.out.println("�� ���°� �����Ǿ����ϴ�.");
    }
    //�ܾ� ��ȸ
    public static void retrieveBalance(){
        Scanner scan = new Scanner(System.in);
        System.out.print("���¹�ȣ�� �Է��ϼ���");
        String Account_no = scan.nextLine();
       
        int index = retrieveIndexByAccount_no(Account_no);
        if(index != -1){
            System.out.printf("���¹�ȣ %d%n", accounts[index].getBalance());
        }else{
            System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
        }
    }
 
    //�Ա�
    public static void checkIn(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("���¹�ȣ�� �Է��ϼ���");
        String Account_no = scan.nextLine();
 
        System.out.print("�Աݾ� : ");
        int amount = scan.nextInt();
 
        int index = retrieveIndexByAccount_no(Account_no);
        if(index != -1){           
            accounts[index].deposit(amount);
        }else{
            System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
        }
       
    }
 
    //���
    public static void checkOut(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("���¹�ȣ�� �Է��ϼ���");
        String Account_no = scan.nextLine();
        System.out.print("��й�ȣ�� �Է��ϼ���");
        String password = scan.nextLine();
        System.out.print("��ݾ� : ");
        int amount = scan.nextInt();       
 
        int index = retrieveIndexByAccount_no(Account_no);
        if(index == -1){
            System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
        }else{
            if(!accounts[index].getpassword().equals(password)){
                System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
                return;
            }
            accounts[index].withdraw(amount);
            System.out.printf("%d ���� ����Ǿ����ϴ�.%n", amount);
        }
    }
 
    //��ü �� ���� ������ ��ȸ�ϴ�.
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
            System.out.println("====== ���� ����� ���� �ý��� ======");
            System.out.println("1. ���� ����");
            System.out.println("2. �ܾ� ��ȸ");
            System.out.println("3. �Ա�");
            System.out.println("4. ���");
            System.out.println("5. ��ü��������ȸ");
            System.out.println("6. ����");
            System.out.println("�׸��� �����ϼ���");
 
            int menu = scan.nextInt();
            switch(menu){
                case 1:
                    System.out.println("���� ����");
                    createAccount();
                    break;
                case 2:
                    System.out.println("�ܾ� ��ȸ");
                    retrieveBalance();
                    break;
                case 3:
                    System.out.println("�Ա�");
                    checkIn();
                    break;
                case 4:
                    System.out.println("���");
                    checkOut();
                    break;
                case 5:
                    System.out.println("��ü����ȸ");
                    retrieveAccountList();
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("�߸��Է��ϼ̽��ϴ�.");
 
            }
        }while(!isExit);
    }
}