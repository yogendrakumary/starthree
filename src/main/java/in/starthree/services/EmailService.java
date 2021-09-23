package in.starthree.services;

public class EmailService implements IEmailService {
	@Override
	public void sendEmail(String email) {

		System.out.println("sending email" + email);
		//throw new RuntimeException("server not...");
	}
}
