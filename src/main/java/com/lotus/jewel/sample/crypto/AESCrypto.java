package com.lotus.jewel.sample.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class AESCrypto {
	private static final int ITERATION_COUNT = 65536;
	private static final int KEY_LENGTH = 256; // bits
	private static final int GCM_NONCE_LENGTH = 12; // bytes
	private static final int GCM_TAG_LENGTH = 128; // bits

	private static final String AES_GCM_TRANSFORMATION = "AES/GCM/NoPadding";
	private static final String AES_CBC_PKCS5_TRANSFORMATION = "AES/CBC/PKCS5Padding";

	private static final String TRANSFORMATION = AES_GCM_TRANSFORMATION;

	private static final String SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";

	public static void main(String[] args) throws Exception {
		encryptAndDecrypt(AES_GCM_TRANSFORMATION);
		encryptAndDecrypt(AES_CBC_PKCS5_TRANSFORMATION);
	}

	private static void encryptAndDecrypt(String transformation) throws Exception {
		String password = "securePassword";
		String plaintext = "This is a secret message.";

		// Encrypt
		byte[] salt = generateSalt();
		byte[] iv;
		if (AES_GCM_TRANSFORMATION.equals(transformation)) {
			iv = generateIV(GCM_NONCE_LENGTH);
		} else {
			iv = generateIV(16);
		}

		SecretKey key = deriveKey(password, salt);
		String ciphertext = encrypt(plaintext, key, iv, transformation);

		System.out.println("Ciphertext: " + ciphertext);

		// Decrypt
		String decryptedText = decrypt(ciphertext, key, iv, transformation);
		System.out.println("Decrypted text: " + decryptedText);
	}

	// Generate a random salt
	private static byte[] generateSalt() {
		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);
		return salt;
	}

	// Generate a random IV
	private static byte[] generateIV(int length) {
		byte[] iv = new byte[length];
		new SecureRandom().nextBytes(iv);
		return iv;
	}

	// Derive a key from the password using PBKDF2WithHmacSHA256
	private static SecretKey deriveKey(String password, byte[] salt) throws Exception {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
		byte[] keyBytes = factory.generateSecret(spec).getEncoded();
		return new SecretKeySpec(keyBytes, "AES");
	}

	// Encrypt the plaintext
	private static String encrypt(String plaintext, SecretKey key, byte[] iv, String transformation) throws Exception {
		Cipher cipher = Cipher.getInstance(transformation);

		final AlgorithmParameterSpec parameterSpec;
		if (AES_GCM_TRANSFORMATION.equals(transformation)) {
			parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
		} else {
			parameterSpec = new IvParameterSpec(iv);
		}

		cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

		byte[] ciphertextBytes = cipher.doFinal(plaintext.getBytes());
		byte[] combined = new byte[iv.length + ciphertextBytes.length];
		System.arraycopy(iv, 0, combined, 0, iv.length);
		System.arraycopy(ciphertextBytes, 0, combined, iv.length, ciphertextBytes.length);

		return Base64.getEncoder().encodeToString(combined);
	}

	// Decrypt the ciphertext
	private static String decrypt(String ciphertext, SecretKey key, byte[] iv, String transformation) throws Exception {
		byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);

		Cipher cipher = Cipher.getInstance(transformation);

		final AlgorithmParameterSpec parameterSpec;
		if (AES_GCM_TRANSFORMATION.equals(transformation)) {
			parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
		} else {
			parameterSpec = new IvParameterSpec(iv);
		}

		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

		byte[] decryptedBytes = cipher.doFinal(ciphertextBytes, iv.length, ciphertextBytes.length - iv.length);
		return new String(decryptedBytes);
	}
}