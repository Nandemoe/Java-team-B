/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * Account.java
 *
 */

package mod7;

import java.io.Serializable;

public class Account implements Serializable {

    private String id;       // id
    private String name;     // 名前
    private int balance = 0; // 残高

    private String flag = "1";   // 入出金フラグ（"1" → 入金、"2" → 出金）

    // コンストラクタ
    public Account() {
    }
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // setterメソッドの定義
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public void setBalance(int balance) {

        if (flag.equals("1")) {  // 入金時
        	// 残高（balance）に引数で渡された金額を足し、更新
            this.balance += balance;

        } else {  // 出金時
        	// 出金の場合、残高（balance）に引数で渡された金額を引き、更新
            this.balance -= balance;

        }
    }

    // getterメソッドの定義
    public String getId() {
        return id;
    }
    public String getFlag() {
        return flag;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }
}