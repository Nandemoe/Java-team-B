/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * Employee.java
 *
 */

package mod3;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;         // ID
    private String name;    // 名前
    private String section; // 部署
    private String phone;   // 内線

    public Employee() { // コンストラクタ
    }
    public void print() { // データの表示
        System.out.print(id + ",");
        System.out.print(name + ",");
        System.out.print(section + ",");
        System.out.println(phone);
    }
    public void setId(int id) { // IDを設定
        this.id = id;
    }
    public void setName(String name) { // 名前を設定
        this.name = name;
    }
    public void setSection(String section) { // 部署を設定
        this.section = section;
    }
    public void setPhone(String phone) { // 内線を設定
        this.phone = phone;
    }
    public int getId() { // IDを取得
        return id;
    }
    public String getName() { // 名前を取得
        return name;
    }
    public String getSection() { // 部署を取得
        return section;
    }
    public String getPhone() { // 内線を取得
        return phone;
    }
}