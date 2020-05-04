package your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import your.app.Application;
import your.app.User;
import your.app.User.Rolle;

public class UserListePage extends WOComponent {
	private User selectedUser;
	private User logedIn;
    public UserListePage(WOContext context) {
        super(context);
        selectedUser = new User("","","","",Rolle.User);
    }
    public void setLogedIn(User logedIn) {
		this.logedIn = logedIn;
	}
    private User user;
    
    public User user() {
    	return user;
    }
    public void setUser(User user) {
    	this.user = user;
    }
    public User getSelectedUser() {
		return selectedUser;
	}
    public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
    
    public void bearbeiten() {
    	if(logedIn.rechte() == Rolle.Admin || user.login().equals(logedIn.login())) {
    		selectedUser = user;
    	}else {
    		System.out.println(logedIn.rechte());
    	}
    }
    
    public Rolle rolle() {
    	return selectedUser.rechte();
    }
    
    public void setRolle(Rolle rolle) {
    	selectedUser.setRechte(rolle);
    }
    
    public void neu() {
    	Application application = (Application)Application.application();
    	application.users().add(selectedUser);
    	selectedUser = new User("","","","",Rolle.User);
    }
    public void change() {
    	
    }
    public void delete() {
    	Application application = (Application)Application.application();
    	application.users().remove(selectedUser);
    }
}