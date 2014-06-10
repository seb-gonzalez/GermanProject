package mainCode;

public class little_email 
{
	private String email;
	private String subject;
    private String body;
    
    little_email(String a, String b, String c)
    {
    	this.setEmail(a);
    	this.setSubject(b);
    	this.setBody(c);
    	
    }

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

}
