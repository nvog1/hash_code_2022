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

    public static mostrarTodos() {
        for(int i=0; i<contributors.size(); i++) {
            System.out.println("Contributor: " + contributors.get(i).name);
            for(int j=0; j<contributors.get(i).skills.size(); j++) {
                System.out.println("\t" + contributors.get(i).skills.get(j) + " > " + contributors.get(i).levels.get(j));
            }
        }
    }
}