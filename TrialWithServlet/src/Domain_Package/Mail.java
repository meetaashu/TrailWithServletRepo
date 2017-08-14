package Domain_Package;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.test.singleton.jdbc.SpringJdbcSingleton;

public class Mail {
	String eId;
public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
String eDate;
public String geteDate() {
	return eDate;
}
public void seteDate(String eDate) {
	this.eDate = eDate;
}
public String getFromUserId() {
	return fromUserId;
}
public void setFromUserId(String fromUserId) {
	this.fromUserId = fromUserId;
}
public String getToUserId() {
	return toUserId;
}
public void setToUserId(String toUserId) {
	this.toUserId = toUserId;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getEmailText() {
	return emailText;
}
public void setEmailText(String emailText) {
	this.emailText = emailText;
}
String fromUserId;
String toUserId;
String subject;
String emailText;

public String execute(){
	SpringJdbcSingleton jdbc=SpringJdbcSingleton.getInstance();
	Map<String,Mail> m=jdbc.loadCache();
	Set<String> s=m.keySet();
	Iterator<String> itr= s.iterator();
	while(itr.hasNext()){
		String key=(String) itr.next();
		Mail value=(Mail) m.get(key);
		System.out.println("Key is:"+key+"Value is:"+value);
		System.out.println(value.geteId()+" "+value.geteDate()+" "+value.getSubject()+" "+value.getEmailText());
	}
	return "success";
}

}
