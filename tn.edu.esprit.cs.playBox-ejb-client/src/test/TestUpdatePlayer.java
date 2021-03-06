package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.AccountManagementRemote;
import domain.Player;

public class TestUpdatePlayer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		AccountManagementRemote proxy = (AccountManagementRemote) context
				.lookup("ejb:/tn.edu.esprit.cs.playBox-ejb/AccountManagement!services.interfaces.AccountManagementRemote");

		Player playerFound = (Player) proxy.findUserById(1);
		playerFound.setLogin("new look");

		proxy.updateUser(playerFound);
	}

}
