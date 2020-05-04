package your.app;

import com.webobjects.foundation.NSMutableArray;

import er.extensions.appserver.ERXApplication;
import your.app.User.Rolle;

public class Application extends ERXApplication {
	NSMutableArray <User> users;
	NSMutableArray<User.Rolle> rollen;
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
		
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		
		users = new NSMutableArray<User>();
		rollen = new NSMutableArray<User.Rolle>();
		
		rollen.add(User.Rolle.Admin);
		rollen.add(User.Rolle.Subadmin);
		rollen.add(User.Rolle.User);
		
		
		//testzweck
		users.add(new User("max", "muster", "root", "123", Rolle.Admin));
		users.add(new User("2", "muster", "safasf", "123", Rolle.Subadmin));
		users.add(new User("3", "muster", "qwf", "123", Rolle.User));
		users.add(new User("4", "muster", "asf", "123", Rolle.User));
		users.add(new User("5", "muster", "domi", "123", Rolle.User));
		setAllowsConcurrentRequestHandling(true);		
	}
	
	public boolean testIfUserIsValid(String username, String password) {
		for(User user : users) {
			if(user.login().equals(username)) {
				if(user.password().equals(password)) return true;
				return false;
			}
		}
		return false;
	}
	
	public NSMutableArray<User> users() {
		return users;
	}
	public void setUsers(NSMutableArray<User> users) {
		this.users = users;
	}
	public void setRollen(NSMutableArray<User.Rolle> rollen) {
		this.rollen = rollen;
	}
	public NSMutableArray<User.Rolle> rollen() {
		return rollen;
	}
}
