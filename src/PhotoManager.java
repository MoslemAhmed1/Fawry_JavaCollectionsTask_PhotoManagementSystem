import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhotoManager 
{
    private List<Photo> photos = new ArrayList<>();
    private Map<String, List<Photo>> photosByTag = new HashMap<>();
    private Map<LocalDate, List<Photo>> photosByDate = new HashMap<>();
    private Map<String, List<Photo>> photosByLocation = new HashMap<>();

    public void uploadPhoto(Photo photo)
    {
        photos.add(photo);

        for (String tag : photo.getTags())
            photosByTag.computeIfAbsent(tag, k -> new ArrayList<>()).add(photo);

        photosByDate.computeIfAbsent(photo.getDate(), k -> new ArrayList<>()).add(photo);

        photosByLocation.computeIfAbsent(photo.getLocationName(), k -> new ArrayList<>()).add(photo);
    }

    public List<Photo> searchByTag(String tag)
    {
        return photosByTag.getOrDefault(tag, Collections.emptyList());
    }

    public List<Photo> searchByDate(LocalDate date)
    {
        return photosByDate.getOrDefault(date, Collections.emptyList());
    }

    public List<Photo> searchByLocation(String location)
    {
        return photosByLocation.getOrDefault(location, Collections.emptyList());
    }

    public List<Photo> searchByMultipleTags(Set<String> tags)
    {
        List<Photo> result = new ArrayList<>();
        for (Photo p : photos)
            if (p.getTags().containsAll(tags))
                result.add(p);

        return result;
    }
}