import java.util.*;

public class Project {
    private String name;
    private boolean pospuesto;
    private boolean rechazado;
    private int days;
    private int score;
    private int bbefore;
    private ArrayList<String> skills;
    private ArrayList<Integer> levels;
    private static ArrayList<Project> projects = new ArrayList<>();

    public Project(String n, int d, int s, int b, ArrayList<String> sk, ArrayList<Integer> l) {
        name = n;
        days = d;
        score = s;
        bbefore = b;
        skills = sk;
        levels = l;
        pospuesto = false;
        rechazado = false;
        projects.add(this);
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

    public static ArrayList<Project> getProjects() {
        return projects;
    }

    public int getDays() {
        return days;
    }

    public int getScore() {
        return score;
    }

    public int getBbefore() {
        return bbefore;
    }

    public boolean getPospuesto() {
        return pospuesto;
    }

    public boolean getRechazado() {
        return rechazado;
    }

    public static void reordenar() {
        ArrayList<Project> newProjects = new ArrayList<>();
        int minBbefore = -1, pos = -1, maxScore = -1, minDays = -1;

        //Ordenar por bbefore, score, days y numRoles
        while(projects.size() > 0) {
            minBbefore = -1;
            maxScore = -1;
            minDays = -1;
            pos = -1;
            for(int i=0; i<projects.size(); i++) {
                if(pos == -1 || minBbefore > projects.get(i).getBbefore()) {
                    pos = i;
                    minBbefore = projects.get(i).getBbefore();
                    maxScore = projects.get(i).getScore();
                    minDays = projects.get(i).getDays();
                }
                else if(minBbefore == projects.get(i).getBbefore() && 
                        maxScore < projects.get(i).getScore()) {
                    pos = i;
                    minBbefore = projects.get(i).getBbefore();
                    maxScore = projects.get(i).getScore();
                    minDays = projects.get(i).getDays();
                }
                else if(minBbefore == projects.get(i).getBbefore() && 
                        maxScore == projects.get(i).getScore() && 
                        minDays > projects.get(i).getDays()) {
                    pos = i;
                    minBbefore = projects.get(i).getBbefore();
                    maxScore = projects.get(i).getScore();
                    minDays = projects.get(i).getDays();
                }/*
                else if(minBbefore == projects.get(i).getBbefore() && 
                        maxScore == projects.get(i).getScore() && 
                        minDays == projects.get(i).getDays() && 
                        projects.get(pos).getSkills().size() > projects.get(i).getSkills().size()) {
                    pos = i;
                    minBbefore = projects.get(i).getBbefore();
                    maxScore = projects.get(i).getScore();
                    minDays = projects.get(i).getDays();
                }*/
            }

            if(pos != -1) {
                newProjects.add(projects.get(pos));
                projects.remove(pos);
            }
        }

        projects = newProjects;
    }

    public static void mostrarTodos() {
        for(int i=0; i<projects.size(); i++) {
            System.out.println("Project: " + projects.get(i).getName() + "   Bbefore/Score/Days: " + projects.get(i).getBbefore() + "/" + projects.get(i).getScore() + "/" + projects.get(i).getDays());
            for(int j=0; j<projects.get(i).getSkills().size(); j++) {
                System.out.println("\t" + projects.get(i).getSkills().get(j) + " > " + projects.get(i).getLevels().get(j));
            }
        }
    }
}