package data;

public class Candidate {
    public String firstName;
    public String middleName;
    public String lastName;
    public String email;
    public String contactNo;
    public String keyWords;
    public String comment;

    public Candidate(String firstName, String middleName, String lastName,
                     String email, String contactNo, String keyWords,
                     String comment) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.keyWords = keyWords;
        this.comment = comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public String getComment() {
        return comment;
    }
}
