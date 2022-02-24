import java.util.*;

public class Contributor {
    private String name;
    private ArrayList<String> skills;
    private ArrayList<Integer> levels;
    private boolean ocupado;
    private static ArrayList<Contributor> contributors = new ArrayList<>();

    public Contributor(String n, Array<String> s, Array<Integer> l) {
        name = n;
        skills = s;
        levels = l;
        ocupado = false;
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

    public boolean getOcupado() {
        return ocupado;
    }

    public static ArrayList<Contributor> getContributors() {
        return contributors;
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