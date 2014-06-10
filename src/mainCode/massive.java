package mainCode;


import java.util.ArrayList;

import java.util.Properties;


import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class massive
{
	
	//*******************************************************	
    
	private final String username;// = "Miguel.Garcia.Benito92";
	private final String password;// = "contdetenis";
	private final String from;// = "Miguel.Garcia.Benito92@gmail.com";
	//private final String to = "raremusicorders@gmail.com";	
	
	
	
	private Properties props;
	private Session session;
	private ArrayList<little_email> listado;
	
	private programita sebas;
	
	//********************************************************
	
        
       
	//Constructor
	public massive(String ficherito, String mail, String pass)
	{
            
                this.from = mail;
                this.password = pass;
                this.username = mail.substring(0,mail.indexOf("@"));
		sebas = new programita(ficherito);
		listado = sebas.visualizar(); //Aqui obtengo la lista de todo lo que tengo que leer;
		
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		this.createSession();
	}
	
	
	private void createSession()
	{
		session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
	}
	
	
	
	
	public void accionEnviarMails()
	{
		//***********************+
		

		
 
		try 
		{
 
			
	         
	         
	        //aqui recorro el listado para ir mandando los emails!!!!! 
                   
			for(int i=0; i<listado.size(); i++)
			{
				
				
				// Create a default MimeMessage object.
		         MimeMessage message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
                         
		        // System.out.println("email leido: "+this.listado.get(i).getEmail());
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(this.listado.get(i).getEmail())); //Aqui pongo el mail que voy leyendo
				
				
				
				String subject = this.listado.get(i).getSubject();
				String message_body = this.listado.get(i).getBody();
				
				         // Set Subject: header field
				         message.setSubject(subject);
			
				         // Create the message part 
				         BodyPart messageBodyPart = new MimeBodyPart();
			
				         // Fill the message
				         messageBodyPart.setText(message_body);
				         
				         // Create a multipar message
				         Multipart multipart = new MimeMultipart();
			
				         // Set text message part
				         multipart.addBodyPart(messageBodyPart);
			
				         
			
				         // Send the complete message parts
				         message.setContent(multipart );
			
				         // Send message
				         Transport.send(message);
				         
				        
						 
				         
				         
				        
				         //**********************************************
				         
				         
				         //System.out.println("Sent message successfully....");
				         
			}	         
	        
	         
	         
	         
	        
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 
		
		
		//***********************+ 
	}
	
	
	
	//----------------------
	
	

}
