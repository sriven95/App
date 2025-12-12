public class Add {
    public static void main(String[] args) {

        DBConnection db = new DBConnection();
       
        int num1 = db.a();
        System.out.print("Enter second number: ");
        int num2 = db.b();
        System.out.print("Enter third number: ");
        int num3 = db.c();
        int sum = num1 + num2 + num3;
        System.out.println("Sum of the three numbers is: " + sum);
    }
}