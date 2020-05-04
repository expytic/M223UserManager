package your.app.components;

import com.webobjects.appserver.WOContext;

import your.app.Application;
import your.app.User;

public class Main extends BaseComponent {
	private String username = "";
	private String password = "";
	
	public Main(WOContext context) {
		super(context);
	}
	
	public UserListePage submit() {
		Application application = (Application)Application.application();
		if(application.testIfUserIsValid(username, password)) {
			UserListePage nextPage = pageWithName(UserListePage.class);
			for(User u : application.users()) {
				if(u.login().equals(username)) {
					nextPage.setLogedIn(u);
					break;
				}
			}
			
			
			return nextPage;
		}else {
			return null;
		}
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
