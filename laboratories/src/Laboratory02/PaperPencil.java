package Laboratory02;

public class PaperPencil {

    public static void main(String[] args) {

        // 1. Consider the following if…then logic:
        // if(age > 65) socialSecurityStatus = "eligible";
        // else socialSecurityStatus = "ineligible";
        // Rewrite this (pseudo) code using the Java ternary operator.

        int age = 70; // Example age for testing
        String socialSecurityStatus = (age > 65) ? "eligible" : "ineligible";
        System.out.println("Social Security Status: " + socialSecurityStatus);

        // 2. Suppose a String s is initialized by:
        String s = "a friendly face";

        // a. Compute the value of the expression s.charAt(2);
        char charAt2 = s.charAt(2);
        System.out.println("Character at index 2: " + charAt2);

        // b. What is the value of s.length()?
        int length = s.length();
        System.out.println("Length of string: " + length);

        // c. What is the value of s.substring(2,9)?
        String substring2to9 = s.substring(2, 9);
        System.out.println("Substring from index 2 to 9: " + substring2to9);

        // s.substring(4)?
        String substring4 = s.substring(4);
        System.out.println("Substring from index 4 onwards: " + substring4);

        // 3. Write a Java expression that computes each of the following:

        // a. Given the radius r of a circle, compute the area of the circle, and store it in a variable A.
        double r = 5.0; // Example radius
        double A = Math.PI * r * r;
        System.out.println("Area of circle: " + A);

        // b. Given the length len and width wid of a rectangle, compute the length of the diagonal of the rectangle, and store it in a variable diag.
        double len = 3.0, wid = 4.0; // Example dimensions
        double diag = Math.sqrt(len * len + wid * wid);
        System.out.println("Length of diagonal: " + diag);

        // 4. Compute the following (without writing any Java code) and indicate the type of your answer.

        // a. 3 * 5 / 9 % 2
        int result1 = 3 * 5 / 9 % 2; // result: 1, of type int
        System.out.println("3 * 5 / 9 % 2 = " + result1);

        // b. 4 ^ 3 & 5
        int result2 = 4 ^ 3 & 5; // result: 5, of type int
        System.out.println("4 ^ 3 & 5 = " + result2);

        // c. 13 >> 2 << 2 ^ 4
        int result3 = 13 >> 2 << 2 ^ 4; // result: 5, of type int
        System.out.println("13 >> 2 << 2 ^ 4 = " + result3);

        // d. 32 | 16/3 >> 2 & 5
        int result4 = 32 | (16 / 3 >> 2) & 5; // result: 33, of type int
        System.out.println("32 | 16/3 >> 2 & 5 = " + result4);

        // 5. You are reviewing some old Java programs in your company's IT department and you read the following assignment statement in some abandoned code:
        // int a = (b = 5);
        // Is the statement legal (i.e. would it compile)? If so, what value is assigned to the variable a? Explain.

        int b = 5; // Assign b a value
        int a = (b = 5); // This is legal, assigns b the value 5, and then assigns a the value of b (which is 5)
        System.out.println("Value of a: " + a);
    }
}
