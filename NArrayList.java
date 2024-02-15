import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NArrayList {
    public static void main(String[] args) {
        long startTime, endTime, totalTime;

        // Palavras para pesquisar
        String[] palavrasPesquisa = {"Lisbon", "NASA", "Kyunghee", "Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};

        // Leitura do arquivo e construção da tabela de símbolos
        ArrayList<String> tabelaDeSimbolos = new ArrayList<>();
        ArrayList<Integer> frequencias = new ArrayList<>();
        startTime = System.nanoTime();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("leipzig100k.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] palavras = line.split("[\\s\\p{Punct}]+");
                for (String palavra : palavras) {
                    int index = tabelaDeSimbolos.indexOf(palavra);
                    if (index == -1) {
                        tabelaDeSimbolos.add(palavra);
                        frequencias.add(1);
                    } else {
                        int frequencia = frequencias.get(index);
                        frequencias.set(index, frequencia + 1);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        totalTime = (endTime - startTime)/1000000;
        
        System.out.println("Tempo de execucao: " + totalTime + " milisegundos ("+ totalTime/1000 + " segundos)");
        
        // Pesquisa das palavras
        System.out.println("\n\n - Pesquisa de palavras:");
        for (String palavra : palavrasPesquisa) {
            startTime = System.nanoTime();
            tabelaDeSimbolos.indexOf(palavra);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Tempo de execucao: " + totalTime + " milisegundos (" + totalTime / 1000 + " segundos)");
        }

        // Exclusão das palavras
        System.out.println("\n\n - Exclusao de palavras:");
        for (String palavra : palavrasPesquisa) {
            startTime = System.nanoTime();
            int index = tabelaDeSimbolos.indexOf(palavra);
            if (index != -1) {
                tabelaDeSimbolos.remove(index);
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println(palavra + " excluida em " + totalTime + " nanosegundos.");
        }
    }
}
