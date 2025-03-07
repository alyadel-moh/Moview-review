import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String user;
    protected String review;
    protected int rating;
    Scanner scanner = new Scanner(System.in);
    User(String user)
    {
        setUser(user);
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void addreview() {
        System.out.println(user + " adds a review : ");
        System.out.print("Review : ");
        review = scanner.nextLine();
        if(review == null || review.equals(""))
            review = scanner.nextLine();
        System.out.print("Rating : ");
        rating = scanner.nextInt();
    }

}
