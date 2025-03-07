import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab3_p2 {
    public static ArrayList<Review> reviews = new ArrayList<>();
    public static void addreview(Review review)
    {
        reviews.add(review);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList <User> users = new ArrayList<>();
        ArrayList <Movie> movies = new ArrayList<>();
        int i,j,k;
        String line;
        while(true){
            System.out.println("1 - add a user");
            System.out.println("2 - add a movie");
            System.out.println("3 - add a review");
            System.out.println("4 - review movie details ");
            System.out.println("5 - delete a review ");
            System.out.println("6 - print user submited reviews ");
            System.out.println("7 - EXIT");
            System.out.print("Enter an option : ");
            int z = scanner.nextInt();
            scanner.nextLine();
            switch (z)
            {
                case 1:
            System.out.print("Create user : " + "\n" + "Name : ");
            String name = scanner.nextLine();
            for(i = 0 ; i < users.size() ; i++)
                if(users.get(i).getUser().equals(name))
                {
                    System.out.println("user "+users.get(i).getUser()+" already exsists");
                    break;
                }
            if(i == users.size()){
            User user = new User(name);
            users.add(user);
                    System.out.println("user "+name+" created");
        break;}
            break;
                case 2:
            System.out.println("Create Movie : ");
            System.out.print("Title : ");
            String title = scanner.nextLine();
                    for(i = 0 ; i < movies.size() ; i++)
                        if(movies.get(i).getTitle().equals(title))
                        {
                            System.out.println("movie "+movies.get(i).getTitle()+" already exsists");
                            break;
                        }
                    if(i == movies.size()){
            System.out.print("Director : ");
            String director = scanner.nextLine();
            System.out.print("Actors (comma separated) : ");
             line = scanner.nextLine();
            String[] actors = line.split(",");
            Movie movie = new Movie(null,title,director,actors);
            movies.add(movie);
            System.out.println("Movie : " + title +", created by : "+ director +", with actors : " + Arrays.toString(actors));
            break;}
                    break;
            case 3:
                    System.out.print("enter your username : ");
                    line = scanner.nextLine();
                    for (i = 0; i < users.size(); i++)
                        if (users.get(i).getUser().equals(line)) {
                            System.out.print(users.get(i).getUser() + " adds a review for the movie : ");
                            break;
                        }
                    if (i == users.size()) {
                        System.out.println("user not found ! ");
                        break;
                    }
            String moviename = scanner.nextLine();
                    for( j = 0 ; j < movies.size() ; j++)
                        if(movies.get(j).getTitle().equals(moviename))
                            break;
                if(j == movies.size())
                {System.out.println("movie not found ! ");
                    break;}
                    boolean shouldbreak = false;
                if(!reviews.isEmpty())
                {
                    for(k = 0 ; k < reviews.size() ; k++)
                        if (reviews.get(k).getUser().equals(line) && reviews.get(k).getTitle().equals(moviename)) {
                            System.out.println("user " + reviews.get(k).getUser() + " already added a review " + reviews.get(k).getReview() + " for the movie " + reviews.get(k).getTitle());
                            shouldbreak = true;
                            break;
                        }
                    /*if(!shouldbreak)
                    for(k = 0 ; k < reviews.size() ; k++)
                        if(reviews.get(k).getUser().equals(line))
                        {
                            Review review1 = new Review(users.get(i).getUser(),null,null,null,0,null);
                            review1.addreview();
                            Review review2 = new Review(users.get(i).getUser(),movies.get(j).getTitle(),movies.get(j).getDirector(),movies.get(j).getActors(), review1.rating, review1.review);
                            addreview(review2);
                            System.out.println("Review added by "+users.get(i).getUser()+" : "+ review2.review+" with rating "+review2.rating+" for the movie "+movies.get(j).getTitle()+".");
                            shouldbreak = true;
                            break;
                        }*/}
                if(shouldbreak)
                    break;
            for (j = 0 ; j < movies.size() ; j++)
                if(movies.get(j).getTitle().equals(moviename))
            {
            users.get(i).addreview();
            System.out.println("Review added by "+users.get(i).getUser()+" : "+users.get(i).review+" with rating "+users.get(i).rating+" for the movie "+movies.get(j).getTitle()+".");
            Review review = new Review(users.get(i).getUser(),movies.get(j).getTitle(),movies.get(j).getDirector(),movies.get(j).getActors(),users.get(i).rating, users.get(i).review);
            addreview(review);
            break;
        }
            break;
                case 4 :
        System.out.print("enter movie you want : ");
        moviename = scanner.nextLine();
        double sum = 0,count=0;
                    for(i = 0 ; i < movies.size() ; i++)
                        if(moviename.equals(movies.get(i).getTitle()))
                        {
                            System.out.println("Movie : " + movies.get(i).getTitle());
                            System.out.println("Director : " + movies.get(i).getDirector());
                            System.out.println("Actors : " + Arrays.toString(movies.get(i).getActors()));
                            break;
                        }
                    if(i == movies.size())
                    {
                        System.out.println("movie "+moviename+" not found !");
                        break;
                    }
        for(i = 0 ; i < reviews.size() ; i++)
            if(moviename.equals(reviews.get(i).getTitle()))
                break;
        if(i == reviews.size())
        {
            System.out.println("reviews for the movie "+moviename+" not found !");
            break;
        }
        System.out.println("Reviews : ");
        for( i = 0 ; i < reviews.size() ; i++)
            if(moviename.equals(reviews.get(i).getTitle())) {
                System.out.println("Review : " + reviews.get(i).getReview()+" for the user "+reviews.get(i).getUser());
                sum = sum + reviews.get(i).getRating();
                count++;
            }
        System.out.println("Average rating : " + sum / count);
        break;
                case 5 :
            System.out.print("enter the review you want to delete : ");
             line = scanner.nextLine();
            String name2 = " ";
            shouldbreak = true;
            for (i = 0; i < reviews.size(); i++)
                if (line.equals(reviews.get(i).getReview())) {
                    System.out.println("review deleted by " + reviews.get(i).getUser() + " : " + reviews.get(i).getReview());
                    System.out.println("Movie : " + reviews.get(i).getTitle());
                    System.out.println("Director : " + reviews.get(i).getDirector());
                    System.out.println("Actors : " + Arrays.toString(reviews.get(i).getActors()));
                    name2 = reviews.get(i).getTitle();
                    reviews.remove(i);
                    shouldbreak = false;
                    break;
                }
              if(shouldbreak)
                {
                    System.out.println("review "+line+" not found !");
                    break;
                }
              if(reviews.size() == 0)
                  break;
            sum = 0;
            for ( i = 0; i < reviews.size(); i++)
                if (reviews.get(i).getTitle().equals(name2))
                {
                    System.out.println("review : " + reviews.get(i).getReview() + " | " + "rating : " + reviews.get(i).getRating());
                    sum = sum + reviews.get(i).getRating();
                }
            System.out.println("Average rating : " + sum);

            break;
            case 6 : System.out.println("you want to see all the reviews by ?? ");
            line = scanner.nextLine();
                for ( i = 0 ; i < reviews.size() ; i++)
                if(reviews.get(i).getUser().equals(line))
                {
                    System.out.println(reviews.get(i).getUser() + "'s Submitted Reviews ");
                    break;
                }
                if(i == reviews.size())
                {
                    System.out.println("no reviews for the user  "+line);
                    break;
                }
            for ( j = 0; j < reviews.size(); j++)
                if(reviews.get(j).getUser().equals(line))
                    System.out.println("- " + reviews.get(j).getReview()+" for the movie "+reviews.get(j).getTitle());
            break;
                case 7: System.exit(0);
        }}}}
