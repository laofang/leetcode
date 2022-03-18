/**
 * Leetcode2043题，简易银行系统
 */
public class LC2043 {
    long[] balance;
    public LC2043(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 <= 0 || account1 > balance.length || account2 <= 0 || account2 > balance.length) return false;
        if(balance[account1-1] < money) return false;
        balance[account1-1] -= money;
        balance[account2-1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account <= 0 || account > balance.length) return false;
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account <= 0 || account > balance.length) return false;
        if(balance[account - 1] < money) return false;
        balance[account-1] -= money;
        return true;
    }
}
