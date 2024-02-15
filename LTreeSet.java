import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class LTreeSet {
    public static void main(String[] args) {
        long startTime, endTime, totalTime;

        // Palavras para pesquisar
        String[] palavrasPesquisa = {"Lisbon", "NASA", "Kyunghee", "Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};

        // Leitura do arquivo e construção da tabela de símbolos
        TreeSet<String> tabelaDeSimbolos = new TreeSet<>();
        startTime = System.nanoTime();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("leipzig100k.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] palavras = line.split("[\\s\\p{Punct}]+");
                for (String palavra : palavras) {
                    tabelaDeSimbolos.add(palavra);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execucao: " + totalTime + " milisegundos (" + totalTime / 1000 + " segundos)");

        // Pesquisa das palavras
        System.out.println("\n\n - Pesquisa de palavras:");
        for (String palavra : palavrasPesquisa) {
            startTime = System.nanoTime();
           tabelaDeSimbolos.contains(palavra);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println(palavra + " encontrada em " + totalTime + " nanosegundos.");
        }

        // Exclusão das palavras
        System.out.println("\n\n - Exclusao de palavras:");
        for (String palavra : palavrasPesquisa) {
            startTime = System.nanoTime();
            tabelaDeSimbolos.remove(palavra);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println(palavra + " excluida em " + totalTime + " nanosegundos.");
            
        }
    }
}
