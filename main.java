import java.io.*;

public class main {
    public static void main(String[] args){
        public FileReader fde;
        public BufferedReader entrada;
        public String linea;
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
                    numCont = aux[0];
                    numPro = aux[1];

                    //Lee el resto del fichero
                    while(linea != null) {
                        linea = entrada.readLine();

                        if(linea != null) {
                            //Comprueba que esta leyendo contributors
                            if(contadorProcesados < numCont) {
                                //Comienza a leer un nuevo contributor
                                String[] aux = linea.split(" ");
                                if(contadorSkills == 0) {
                                    name = aux[0];
                                    contadorSkills = aux[1];
                                    skills = new ArrayList<>();
                                    levels = new ArrayList<>();
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
        }
        else {
            System.out.println("Argumentos incorrectos.")
        }
    }
}