import java.util.*;

public class Contributor {
    private String name;
    private ArrayList<String> skills;
    private ArrayList<Integer> levels;
    private static ArrayList<Contributor> contributors = new ArrayList<>();

    public Contributor(String n, ArrayList<String> s, ArrayList<Integer> l) {
        name = n;
        skills = s;
        levels = l;
        contributors.add(this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public ArrayList<Integer> getLevels() {
        return levels;
    }

    public static void mostrarTodos() {
        for(int i=0; i<contributors.size(); i++) {
            System.out.println("Contributor: " + contributors.get(i).getName());
            for(int j=0; j<contributors.get(i).getSkills().size(); j++) {
                System.out.println("\t" + contributors.get(i).getSkills().get(j) + " > " + contributors.get(i).getLevels().get(j));
            }
        }
    }
}