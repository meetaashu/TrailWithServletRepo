package Service_Package;

import java.util.List;
import java.util.Map;

import Domain_Package.Mail;

public interface ComposeService {
public String addComposeMessage(Mail m);
public List<Map<String,Object>> getInbox(String fromUId);
}
