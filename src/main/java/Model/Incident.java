package Model;
import java.time.LocalDateTime;

public class Incident {
    private String id;
    private String description;
    private LocalDateTime date;

    // Constructeur
    public Incident(String id, String description, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
