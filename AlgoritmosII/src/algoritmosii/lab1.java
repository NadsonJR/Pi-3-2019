package algoritmosii;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Description . . .
 *
 * @author: Autor
 * @version: 1.0 Main Class File: topAXX.java File: Structure.java Date:
 * DD/MM/YYYY
 */
public class lab1 {

    public static void main(String[] args) {

        // nome do arquivo
        String nomeDoArquivo1 = "C:\\Users\\antonio.ncgjunior\\Documents\\NetBeansProjects\\Pi-3-2019\\AlgoritmosII\\src\\algoritmosii\\pib.txt";
        String nomeDoArquivo2 = "regioes.txt";
        List<pibCidadeEStado> pib = new ArrayList();
        // linha temporaria
        String linha = null;

        /*      ------------------------------------- */
        /*      Abertura de arquivo e loop de leitura */
        /*      ------------------------------------- */
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo1);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            while ((linha = bufferedReader.readLine()) != null) {
                String[] b = linha.split(";");

                pibCidadeEStado estado = new pibCidadeEStado();

                estado.setEstado(b[0]);
                estado.setPIB(Float.parseFloat(b[1]));

                pib.add(estado);
                //System.out.println(linha);
            }

            // feche o arquivo
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeDoArquivo1 + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeDoArquivo1 + "'");
        }

        /*      ------------------------------------- */
        /*      Exemplo de escrita em arquivo         */
        /*      ------------------------------------- */
        String arquivoDeSaida = "C:\\Users\\antonio.ncgjunior\\Documents\\NetBeansProjects\\Pi-3-2019\\AlgoritmosII\\src\\algoritmosii\\saida.txt";

        try {
            int total = 0;
            int pibLength = 0;

            for (pibCidadeEStado item : pib) {
                total += item.PIB;
                pibLength++;
            }

            System.out.println("Total: " + total);

            String Suldoeste = "Minas Gerais\n"
                    + "Espírito Santo\n"
                    + "Rio de Janeiro\n"
                    + "São Paulo";
            String Norte = "Rondônia\n"
                    + "Acre\n"
                    + "Amazonas\n"
                    + "Roraima\n"
                    + "Pará\n"
                    + "Amapá\n"
                    + "Tocantins";
            String Nordeste = "Maranhão\n"
                    + "Piauí\n"
                    + "Ceará\n"
                    + "Rio Grande do Norte\n"
                    + "Paraíba\n"
                    + "Pernambuco\n"
                    + "Alagoas\n"
                    + "Sergipe\n"
                    + "Bahia";
            String CentroOeste = "Mato Grosso do Sul\n"
                    + "Mato Grosso \n"
                    + "Goiás\n"
                    + "Distrito Federal";
            String Sul = "Sul\n"
                    + "Paraná\n"
                    + "Santa Catarina\n"
                    + "Rio Grande do Sul";
            float SomaSul = 0;
            float SomaNorte = 0;
            float SomaNordeste = 0;
            float SomaSudeste = 0;
            float SomaCentroOeste = 0;
            //total = total / pibLength;
            //System.out.println("Total2: " + total);
            for (pibCidadeEStado item : pib) {
                item.setPercentual((item.getPIB() / total) * 100);

                //System.out.println(item.getPercentual());
                //Verificação de estados
                if (Suldoeste.contains(item.getEstado())) {
                    item.setRegiao("Sudeste");
                    System.out.println("Cidade: " + item.getEstado()
                            + " \nRegiao: " + item.getRegiao()
                            + " \nPIB: " + item.getPIB());
                    SomaSudeste = SomaSudeste + item.getPIB();
                } else if (Norte.contains(item.getEstado())) {
                    item.setRegiao("Norte");
                    System.out.println("Cidade: " + item.getEstado()
                            + " \nRegiao: " + item.getRegiao()
                            + " \nPIB: " + item.getPIB());
                    SomaNorte = SomaNorte + item.getPIB();
                } else if (Nordeste.contains(item.getEstado())) {
                    item.setRegiao("Nordeste");
                    System.out.println("Cidade: " + item.getEstado()
                            + " \nRegiao: " + item.getRegiao()
                            + " \nPIB: " + item.getPIB());
                    SomaNordeste = SomaNordeste + item.getPIB();
                } else if (Sul.contains(item.getEstado())) {
                    item.setRegiao("Sul");
                    System.out.println("Cidade: " + item.getEstado()
                            + " \nRegiao: " + item.getRegiao()
                            + " \nPIB: " + item.getPIB());
                    SomaSul = SomaSul + item.getPIB();
                } else if (CentroOeste.contains(item.getEstado())) {
                    item.setRegiao("Centro-Oeste");
                    System.out.println("Cidade: " + item.getEstado()
                            + " \nRegiao: " + item.getRegiao()
                            + " \nPIB: " + item.getPIB());
                    SomaCentroOeste = SomaCentroOeste + item.getPIB();
                }
            }

            FileWriter fileWriter = new FileWriter(arquivoDeSaida);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("pib da regiao Norte = " + SomaNorte);
            System.out.println("pib da regiao Norte = " + SomaNorte);
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Nordeste = " + SomaNordeste);
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Sudeste = " + SomaSudeste);
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Sul = " + SomaSul);
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Centro-Oeste = " + SomaCentroOeste);

            // feche o arquivo
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + arquivoDeSaida + "'");
        }

    }

    public static class pibCidadeEStado {

        private String Estado;
        private float PIB;
        private float Percentual;
        private String Regiao;

        public String getRegiao() {
            return Regiao;
        }

        public void setRegiao(String Regiao) {
            this.Regiao = Regiao;
        }

        public float getPercentual() {
            return Percentual;
        }

        public void setPercentual(float Percentual) {
            this.Percentual = Percentual;
        }

        public String getEstado() {
            return Estado;
        }

        public void setEstado(String Estado) {
            this.Estado = Estado;
        }

        public float getPIB() {
            return PIB;
        }

        public void setPIB(float PIB) {
            this.PIB = PIB;
        }

    }
}
