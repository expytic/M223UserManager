package your.app;

public class User {
	public enum Rolle {
		Admin, Subadmin, User;
	}
	private String firstName, secondName, login, password;
	private Rolle rechte;
	public User(String fistName, String secondName, String login, String password, Rolle rechte) {
		this.firstName = fistName;
		this.secondName = secondName;
		this.login = login;
		this.password = password;
		this.rechte = rechte;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public void setRechte(Rolle rechte) {
		this.rechte = rechte;
	}
	public String firstName() {
		return firstName;
	}
	public String login() {
		return login;
	}
	public String password() {
		return password;
	}
	public String secondName() {
		return secondName;
	}
	public Rolle rechte() {
		return rechte;
	}
}
