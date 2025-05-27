package Laboratory02;

/*1.
Consider the following if…then logic:
    if(age > 65) socialSecurityStatus = "eligible";
    else socialSecurityStatus = "ineligible";
    Rewrite this (pseudo) code using the Java ternary operator
*/

public class PaperPencil {
    private int age;
    private String socialSecurityStatus;

    public PaperPencil(int age, String socialSecurityStatus) {
        this.age = age;
        this.socialSecurityStatus = (age > 65 ? "eligible" : "ineligible");
    }

    public int getAge() {
        return age;
    }

    public String getSocialSecurityStatus() {
        return socialSecurityStatus;
    }

    public void setAge(int age) {
        this.age = age;
        this.socialSecurityStatus = (age > 65 ? "eligible" : "ineligible");
    }

    public void setSocialSecurityStatus(String socialSecurityStatus) {
        this.socialSecurityStatus = socialSecurityStatus;
    }
    @Override
    public String toString() {
        return "PaperPencil{" +
                "age=" + age +
                ", socialSecurityStatus=" + socialSecurityStatus +
                '}';
    }
}