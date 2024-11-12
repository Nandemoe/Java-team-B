/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * Member.java
 *
 */

package mod6;

import java.io.Serializable;

public class Member implements Serializable {

    private String name;     // 名前
    private String password; // パスワード

    // コンストラクタ
    public Member() {
    }

    public Member(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // setterメソッドの定義
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // getterメソッドの定義
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}