import java.io.*;

public class main {
    public static void main(String[] args){
        FileReader fde;
        BufferedReader entrada;
        String linea;
        int numPro = 0, numCont = 0, contadorProcesados = 0, contadorSkills = 0;

        Contributor c;
        String name;
        ArrayList<String> skills;
        ArrayList<Integer> levels;


        if(args.size() == 1) {
            try {
                fde = new FileReader(args[0]);
                entrada = new BufferedReader(fde);

                if(entrada != null) {
                    linea = entrada.readLine();

                    //Almacena la cantidad de contribuidores y proyectos
                    String[] aux = linea.split(" ");
                    numCont = Integer.parseInt(aux[0]);
                    numPro = Integer.parseInt(aux[1]);

                    //Lee el resto del fichero
                    while(linea != null) {
                        linea = entrada.readLine();

                        if(linea != null) {
                            //Comprueba que esta leyendo contributors
                            if(contadorProcesados < numCont) {
                                //Comienza a leer un nuevo contributor
                                aux = linea.split(" ");
                                if(contadorSkills == 0) {
                                    name = aux[0];
                                    contadorSkills = Integer.parseInt(aux[1]);
                                    skills = new ArrayList<String>();
                                    levels = new ArrayList<Integer>();
                                }
                                else {
                                    skills.add(aux[0]);
                                    levels.add(Integer.parseInt(aux[1]));

                                    contadorSkills--;

                                    //Si ha leido la ultima skill del contributor
                                    if(contadorSkills == 0) {
                                        contadorProcesados++;
                                        c = new Contributor(name, skills, levels);
                                    }
                                }
                            }
                        }
                    }


                    //Muestra los contribuidores
                    Contributor.mostrarTodos();
                }
            } catch(IOException e) {
                System.out.println("Error al leer el archivo.");
            }

            //ALGORITMO
            Project.reordenar();
            ArrayList<Contributor> contribuidores = Contributor.getContributors();
            ArrayList<Project> projects = Project.getProjects();
            String solucion = "";
            
            //realmente sería un while(!pospuestos.isEmpty()), pero habría que saber ver si no se va a poder realizar nunca
            //porque no haya gente cualificada y no se pueda cualificar.
            //asigno los proyectos
            for(Integer i = 0; i < 3; i++){
                Integer index = 0;
                while(!projects.isempty()){
                        Project actual = projects[index];
                        projects.remove(index);
                        if(actual.puntua()){
                            if(realizable){
                                //realizar
                            }
                            else if(falta_gente){
                                actual.setPospuesto(true);
                            }
                            else{//no hay gente suficientemente cualificada
                                if(!Project.finished()){//hacer
                                    actual.setPospuesto(true);
                                }
                                else{
                                    actual.setDescartado();
                                }
                            }
                        }
                        else{
                            actual.setDescartado(true);//ver cómo hacer para actualizar el array estático
                        }
                        

                        index++;
                }
                Project.desPosponer();
            }
            

            


        }
        else {
            System.out.println("Argumentos incorrectos.");
        }
    }
}