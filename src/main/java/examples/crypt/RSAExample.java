package examples.crypt;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAExample {

	private static final String MESSAGE = "Hello Mars!";

	public static void main(String[] args) {

		try {

			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

			kpg.initialize(2048);
			KeyPair kp = kpg.genKeyPair();

			KeyFactory fact = KeyFactory.getInstance("RSA");

			//Encrypt
			RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
					RSAPublicKeySpec.class);

			RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
					RSAPrivateKeySpec.class);

			System.out.println("Public Key: "+" "+pub.getModulus()+" "+pub.getPublicExponent());
			System.out.println("Private Key: "+" "+priv.getModulus()+" "+priv.getPrivateExponent());

			//Decrypt
			RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(pub.getModulus(), pub.getPublicExponent());
			RSAPrivateKeySpec privKeySpec = new RSAPrivateKeySpec(priv.getModulus(), priv.getPrivateExponent());
			
			PublicKey loadPubKey = fact.generatePublic(pubKeySpec);
			PrivateKey loadPrivKey = fact.generatePrivate(privKeySpec);

			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, loadPubKey);
			byte[] cipherData = cipher.doFinal(MESSAGE.getBytes());
			System.out.println("crypt : " + new String(cipherData));

			cipher.init(Cipher.DECRYPT_MODE, loadPrivKey);
			byte[] plainText = cipher.doFinal(cipherData);
			System.out.println("message : " + new String(plainText));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
