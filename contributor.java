import java.util.*;

public class contributor {
    private ArrayList<String> skills;
    private ArrayList<Integer> level;
    private static ArrayList<contributor> contributors = new ArrayList<>();

    public contributor(ArrayList<String> s, ArrayList<Integer> l) {
        skills = s;
        level = l;
        contributors.add(this);
    }

}