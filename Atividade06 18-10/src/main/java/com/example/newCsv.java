import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVProcessor {

    public static void main(String[] args) {
        String inputFile = "caminho/do/arquivo/entrada.csv";
        String outputFile = "caminho/do/arquivo/saida.csv";

        processCSV(inputFile, outputFile);
    }

    public static void processCSV(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Divide a linha em colunas usando a vírgula como delimitador
                String[] columns = line.split(",");

                // Converte as duas primeiras colunas para inteiros e calcula a soma
                int col1 = Integer.parseInt(columns[0].trim());
                int col2 = Integer.parseInt(columns[1].trim());
                int sum = col1 + col2;

                // Escreve a linha no arquivo de saída com a soma no final
                writer.write(line + "," + sum);
                writer.newLine();
            }

            System.out.println("Processamento concluído. Arquivo de saída gerado com sucesso.");

        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }
}
