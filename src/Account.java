class Account {
    private String Account_no;
    private String password;
    private String owner;
    private int balance;
 
    public Account(){
   
    }
    public Account(String Account_no, String password, String owner, int balance){
        this.Account_no = Account_no;
        this.password = password;
        this.owner = owner;
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
   
        public void setpassword(String password){
            this.password = password;
        }
  
    public String getpassword(){
        return password;
    }
    public void deposit(int deposit){
        if(deposit<=0 ){
            System.out.println("�ݾ��� ��Ȯ�� �Է��ϼ���.");
            return;
        }
        balance +=deposit;
    }
 
    public void withdraw(int withdraw){
        if(withdraw>balance){
            System.out.println("�ܾ��� �����մϴ�.");
            return;
        }
 
        if(withdraw<=0){
            System.out.println("0�� �� ���̳ʽ������� ����Ͻ� �� �����ϴ�.");
            return;
        }
        balance -= withdraw;
    }
 
    public String getAccountInfo(){
        return "���¹�ȣ :" + Account_no +
               ", �����ָ� :" + owner +
               ", ��й�ȣ :" + password +
               ", �ܰ� :" + balance;
    }
 
    public String getAccount_no(){
        return Account_no;
    }
}