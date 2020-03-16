package jp.co.internous.ecsite.model.form;

import java.io.Serializable;
//Serializableで直列化可能になる→あるクラスのオブジェクトを復元・保存ができるようになる
public class LoginForm implements Serializable {
	//serialVersionUID=1Lは、クラスのバージョンに変更がないかを示すもの
	private static final long serialVersionUID=1L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

}
