package examples.crypt;
import org.mindrot.BCrypt;


public class BCryptExample {

	public static void main(String[] args) {
		
		String password = "my password";
		
		// Hash a password for the first time
		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(7));
		String version = hashed.split("\\$")[1];
		String factor = hashed.split("\\$")[2];
		
		System.out.println(version);
		System.out.println(factor);
		System.out.println(hashed);
		
		// Check that an unencrypted password matches one that has
		// previously been hashed
		if (BCrypt.checkpw(password, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}

}
