package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Admin {
	private String NIC;
	private String name;
	private String psw;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String nIC, String name, String psw) {
		super();
		NIC = nIC;
		this.name = name;
		this.psw = psw;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		
		return psw;
	}

	public void setPsw(String psw) {

		String Pass = psw;
		MessageDigest md;
		
		try {
			md =MessageDigest.getInstance("MD5");
			md.update(Pass.getBytes());
			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b1:b) {
				sb.append(Integer.toHexString(b1 & 0xff).toString());
			}
			psw= sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.psw = psw;
	}
	
}
