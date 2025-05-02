package RidePool;

import java.util.ArrayList;
import java.util.List;

public class Path {
    public static List<Place> getPath(Place from, Place to) {
        List<Place> path = new ArrayList<>();
        int x = from.x, y = from.y;

        while (x != to.x) {
            x += (to.x > x) ? 1 : -1;
            path.add(new Place("Step", x, y));
        }
        while (y != to.y) {
            y += (to.y > y) ? 1 : -1;
            path.add(new Place("Step", x, y));
        }
        return path;
    }
}
