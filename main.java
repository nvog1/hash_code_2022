import java.io.*;

public class main {
    public static void main(String[] args){
        private FileReader fde;
        private BufferedReader entrada;
        private String linea;
        int numPro = 0, numCont = 0, lineaAux = 0;

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
                        if(lineaAux < numCont) {
                            
                        }
                    }
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