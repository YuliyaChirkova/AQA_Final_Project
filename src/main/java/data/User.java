package data;

public class User {

    public String userName;
    public String password;
    public String employeeName;
    public String invalidEmployeeName;
    public String adminAddUserName;
    public String adminAddUserPassword;
    public String fromDate;
    public String toDate;


    public User(String userName, String password, String employeeName,
                String invalidEmployeeName, String adminAddUserName,
                String adminAddUserPassword, String fromDate, String toDate) {
        this.userName = userName;
        this.password = password;
        this.employeeName = employeeName;
        this.invalidEmployeeName = invalidEmployeeName;
        this.adminAddUserName = adminAddUserName;
        this.adminAddUserPassword = adminAddUserPassword;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

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
