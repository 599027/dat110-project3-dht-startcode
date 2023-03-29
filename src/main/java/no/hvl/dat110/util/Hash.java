package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity){	
		
		BigInteger hashint = null;
		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		MessageDigest md = null;
		byte[] result;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = md.digest(entity.getBytes());
		hashint = new BigInteger(toHex(result), 16);
		
  		return hashint;
		// compute the hash of the input 'entity'
		// convert the hash into hex format
		// convert the hex into BigInteger
		// return the BigInteger
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		BigInteger bigint = BigInteger.valueOf(2).pow(bitSize());


		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return bigint;
	}
	
	public static int bitSize() {
		int digestlen;
		digestlen = hashOf("null").toByteArray().length;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
