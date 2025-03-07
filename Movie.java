import java.util.ArrayList;

public class Movie extends User {
    private String title;
    private String director;
    private String[] actors;
    Movie(String user,String title,String director,String[] actors)
    {
        super(user);
        setTitle(title);
        setDirector(director);
        setActors(actors);
    }
    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
