package DAO_package;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import Domain_Package.Mail;

public class ComposeDAO_impl implements ComposeDAO{
private JdbcTemplate jdbcTemplate;
	
	@Override
	public String addComposeMessage(Mail m) {
		String result=null;
		//WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
		//context.getBean(null);
		Object [] objArray=new Object[5];
		objArray[0]=m.geteDate();
		objArray[1]=m.getFromUserId();
		objArray[2]=m.getToUserId();
		objArray[3]=m.getSubject();
		objArray[4]=m.getEmailText();
		
		String sql="Insert into emails (EmailDate,FromUserId, ToUserId, MailSubject,EmailText) value (?,?,?,?,?)";
		int rowsAffected=jdbcTemplate.update(sql, objArray);
		if(rowsAffected>0){
			result="Success";
		}else{
			result="Failure";
		}
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String,Object>> getInbox(String fromUId){
		//Cookie ck[]= request.getCookies();
		String sql="Select EmailNo,EmailDate, FromUserId, MailSubject from emails where ToUserId=?";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,new Object[]{fromUId});
			for(Map<String,Object> row: list)
			{
				String emailNo=row.get("EmailNo").toString();
				String eDate=row.get("EmailDate").toString();
				String fId=row.get("FromUserId").toString();
				String sub=row.get("MailSubject").toString();
				System.out.println(emailNo+" Date:"+eDate+"FromUserID:"+fId+"Mail Subject:"+sub);
			}		
		return list;
	}
}
