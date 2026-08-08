import java.time.LocalDate;
import java.util.Set;

public class Photo 
{
    private String id;
    private String filename;
    private LocalDate date;
    private String locationName;
    private Set<String> tags;

    public Photo(String id, String filename, LocalDate date, String locationName, Set<String> tags) 
    {
        this.id = id;
        this.filename = filename;
        this.date = date;
        this.locationName = locationName;
        this.tags = tags;
    }

    public String getId() {return id;}
    public String getFilename() {return filename;}
    public LocalDate getDate() {return date;}
    public String getLocationName() {return locationName;}
    public Set<String> getTags() {return tags;}

    @Override
    public String toString()
    {
        return filename + " | date=" + date + " | location=" + locationName + " | tags=" + tags;
    }
}
