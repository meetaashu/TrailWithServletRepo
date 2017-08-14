package Service_Package;

import java.util.List;
import java.util.Map;

import DAO_package.ComposeDAO;
import Domain_Package.Mail;

public class ComposeService_impl implements ComposeService {
private ComposeDAO cDao;
	public ComposeDAO getcDao() {
	return cDao;
}
public void setcDao(ComposeDAO cDao) {
	this.cDao = cDao;
}
	@Override
	public String addComposeMessage(Mail m) {
	String result=	cDao.addComposeMessage(m);
		
	if(result=="Success"){
		System.out.println("Result successfully saved");
	}else{
		System.out.println("An error occured");
	}
		return result;
	}
	@Override
	public List<Map<String,Object>> getInbox(String fromUId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> result=cDao.getInbox(fromUId);
//		if(result==1){
//			System.out.println("Inbox Success..service");
//		}else{
//			System.out.println("Inbox fail...service");
//		}
		return result;
	}

}
