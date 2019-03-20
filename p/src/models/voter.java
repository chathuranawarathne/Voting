package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class voter {
	private String VoterID;
	private String Fname;
	private String Tnumber;
	private String District;
	private String City;
	private String Email;
	private String Password;
	private String NIC;
	
	
	public voter() {
		
	}


	public voter(String voterID, String fname, String tnumber, String district, String city, String email,
			String password, String nIC) {
		super();
		VoterID = voterID;
		Fname = fname;
		Tnumber = tnumber;
		District = district;
		City = city;
		Email = email;
		Password = password;
		NIC = nIC;
	}


	public String getVoterID() {
		return VoterID;
	}


	public void setVoterID(String voterID) {
		VoterID = voterID;
	}


	public String getFname() {
		return Fname;
	}


	public void setFname(String fname) {
		Fname = fname;
	}


	public String getTnumber() {
		return Tnumber;
	}


	public void setTnumber(String tnumber) {
		Tnumber = tnumber;
	}


	public String getDistrict() {
		return District;
	}


	public void setDistrict(String district) {
		District = district;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		
		String Pass = password;
		MessageDigest md;
		
		try {
			md =MessageDigest.getInstance("MD5");
			md.update(Pass.getBytes());
			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b1:b) {
				sb.append(Integer.toHexString(b1 & 0xff).toString());
			}
			password=sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Password=password;
		
	
	}


	public String getNIC() {
		return NIC;
	}


	public void setNIC(String nIC) {
		NIC = nIC;
	}


	@Override
	public String toString() {
		return "voterRegistration [VoterID=" + VoterID + ", Fname=" + Fname + ", Tnumber=" + Tnumber + ", District="
				+ District + ", City=" + City + ", Email=" + Email + ", Password=" + Password + ", NIC=" + NIC + "]";
	}


	
	
}


