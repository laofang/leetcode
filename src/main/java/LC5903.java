/**
 * Leetcode5903，竞赛题，简易银行系统
 * 主要思路：
 * 1. 没什么说的，按要求实现即可
 * 2. 主要要注意两点：
 *      1. 账户是否存在
 *      2. 转账和取钱操作，要注意转出账户的余额是否满足要求
 */
public class LC5903 {
    private long[] balance;
    public LC5903(long[] balance) {
        this.balance = balance;
    }

    /**
     * 转账
     * @param account1 转出账户
     * @param account2 转入账户
     * @param money 转账金额
     * @return 转账是否成功
     */
    public boolean transfer(int account1, int account2, long money) {
        if(account1 - 1 >= balance.length || account2 - 1 >= balance.length) {
            return false;
        }
        if(balance[account1-1] >= money) {
            balance[account1-1] -= money;
            balance[account2-1] += money;
            return true;
        }
        return false;
    }

    /**
     * 存款
     * @param account 账户
     * @param money 存款金额
     * @return 存款是否成功
     */
    public boolean deposit(int account, long money) {
        if(account-1 >= balance.length) {
            return false;
        }
        balance[account-1] += money;
        return true;
    }

    /**
     * 取款
     * @param account 取款账户
     * @param money 取款金额
     * @return 取款是否成功
     */
    public boolean withdraw(int account, long money) {
        if(account-1 >= balance.length || balance[account-1] < money) {
            return false;
        }
        balance[account-1] -= money;
        return true;
    }
}
