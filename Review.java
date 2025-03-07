import java.util.ArrayList;

public class Review extends Movie{

    public Review(String user, String title, String director, String[] actors, int rating, String review)
    {
        super(user, title, director, actors);
        setReview(review);
        setRating(rating);
    }
    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    public String getReview()
    {
        return review;
    }
    public void setReview(String review)
    {
        this.review = review;
    }
}
