package xom.test;

import java.math.BigInteger;

public class employee {
private String Title ;
private String name ;
private String   mobile ;

public employee(String title , String name , String mobile){
    this.Title = title;
    this.name = name ;
    this.mobile = mobile;
}

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTitle() {
        return Title;
    }
}
