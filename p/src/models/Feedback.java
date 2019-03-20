package models;

public class Feedback {
	private String Name;
	private String Subject;
	private String Email;
	private String Description;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(String name, String subject, String email, String description) {
		super();
		Name = name;
		Subject = subject;
		Email = email;
		Description = description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	

}
