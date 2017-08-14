package DAO_package;

import Domain_Package.Admin;

public interface adminDAO {
public String populate_admin(Admin a);
public String getPhoneNoByName(String name);
public Admin getPhoneNoByNameInAdmin(String name);
}
