package DAO_package;

import java.util.List;
import java.util.Map;

import Domain_Package.Mail;

public interface ComposeDAO {
public String addComposeMessage(Mail m);
public List<Map<String,Object>> getInbox(String fromUId);
}
