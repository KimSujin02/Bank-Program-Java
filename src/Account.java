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
            System.out.println("금액을 정확히 입력하세요.");
            return;
        }
        balance +=deposit;
    }
 
    public void withdraw(int withdraw){
        if(withdraw>balance){
            System.out.println("잔액이 부족합니다.");
            return;
        }
 
        if(withdraw<=0){
            System.out.println("0원 및 마이너스단위는 출금하실 수 없습니다.");
            return;
        }
        balance -= withdraw;
    }
 
    public String getAccountInfo(){
        return "계좌번호 :" + Account_no +
               ", 예금주명 :" + owner +
               ", 비밀번호 :" + password +
               ", 잔고 :" + balance;
    }
 
    public String getAccount_no(){
        return Account_no;
    }
}