package core;

import jLogger.GoogleManager;

public class GoogleManagerAdapter implements IGoogleService{

	@Override
	public void verifyToMail() {
		GoogleManager googleManager=new GoogleManager();
		googleManager.sendToVerifyMail();
	} 
}
