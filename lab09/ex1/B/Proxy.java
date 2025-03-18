package B;

public class Proxy implements BankAccount{
    private BankAccountImpl bankAccountImp;

    public Proxy(String bank, double initialDeposit) {
        this.bankAccountImp = new BankAccountImpl(bank, initialDeposit);
    }

    public void deposit(double amount){
        this.bankAccountImp.deposit(amount);
    }


    public String getBank(){
        return this.bankAccountImp.getBank();
    }

    
    @Override
    public boolean withdraw(double amount) {
        if (Company.user==User.OWNER){
            return true;
        }
        else{
            System.out.println("Not the user");
            return false;
        }
    }

    @Override
    public double balance() {
        if (Company.user==User.OWNER){
            return this.bankAccountImp.balance();
        }
        System.out.println("Not the user");
        return -1;
    }
}
