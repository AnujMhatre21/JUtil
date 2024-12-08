package com.github.AnujMhatre21.JUtil.Encryption;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {
	private static final String ALGORITHM = "AES";

	private static final byte[] KEY = "MySecretKey99999".getBytes();

	public static String encrypt(String data) throws Exception {
		SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedData = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedData);
	}

	public static String decrypt(String encryptedData) throws Exception {
		SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] originalData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
		return new String(originalData);
	}
}
