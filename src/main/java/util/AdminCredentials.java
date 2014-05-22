package util;

public class AdminCredentials {
	private static String login;
	private static String password;
	
	
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		AdminCredentials.password = password;
	}
	public static String getLogin() {
		return login;
	}
	public static void setLogin(String login) {
		AdminCredentials.login = login;
	}
}
