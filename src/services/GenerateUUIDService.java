package services;

import java.util.UUID;

import commands.CallbackInterface;

public class GenerateUUIDService {
	
	public static String generate() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
}
