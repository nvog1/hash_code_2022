import java.util.*;

public class Contributor {
    private String name;
    private List<String> skills;
    private List<Integer> levels;
    private static List<Contributor> contributors = new L<Contributor>();

    public Contributor(String n, Array<String> s, Array<Integer> l) {
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