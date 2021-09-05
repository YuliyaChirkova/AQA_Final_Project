package data;

public class User {

    public String userName ="Admin";
    public String password = "admin123";
    public String employeeName ="Alice Duval";
    public String invalidEmployeeName ="Mark Shagal";
    public String adminAddUserName = "Al-Duv";
    public String adminAddUserPassword = "QWER1234";
    public String fromDate = "2021-11-01";
    public String toDate = "2021-11-10";


    public String getUserName() {
        return userName;
    }

    public String getInvalidEmployeeName() {
        return invalidEmployeeName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmployeeName() { return employeeName; }

    public String getAdminAddUserName() { return adminAddUserName; }

    public String getAdminAddUserPassword() { return adminAddUserPassword; }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
}
