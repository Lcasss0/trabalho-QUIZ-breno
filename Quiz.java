import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pergunta> perguntasGeografia = new ArrayList<>();
        List<Pergunta> perguntasMatematica = new ArrayList<>();
        List<Pergunta> perguntasCuriosidades = new ArrayList<>();

        inicializarPerguntas(perguntasGeografia, perguntasMatematica, perguntasCuriosidades);

        jogarQuiz(perguntasGeografia, scanner);
        jogarQuiz(perguntasMatematica, scanner);
        jogarQuiz(perguntasCuriosidades, scanner);

        scanner.close();
    }

    private static void inicializarPerguntas(List<Pergunta> perguntasGeografia, List<Pergunta> perguntasMatematica,
                                             List<Pergunta> perguntasCuriosidades) {
        // Adicionar perguntas de geografia
        perguntasGeografia.add(new Pergunta("Qual é a capital do Brasil?", "a) Brasília", "b) São Paulo", "c) Rio de Janeiro", "d) Belo Horizonte", "a"));
        perguntasGeografia.add(new Pergunta("Qual é o maior país do mundo em área territorial?", "a) China", "b) Rússia", "c) Canadá", "d) Estados Unidos", "b"));
        perguntasGeografia.add(new Pergunta("Qual é o rio mais extenso do mundo?", "a) Nilo", "b) Amazonas", "c) Yangtzé", "d) Mississippi", "b"));
        perguntasGeografia.add(new Pergunta("Em que país fica localizada a Torre Eiffel?", "a) Inglaterra", "b) França", "c) Itália", "d) Espanha", "b"));
        perguntasGeografia.add(new Pergunta("Qual é o maior deserto do mundo?", "a) Deserto do Saara", "b) Deserto da Arábia", "c) Deserto de Gobi", "d) Deserto do Atacama", "a"));

        // Adicionar perguntas de matemática
        perguntasMatematica.add(new Pergunta("Quanto é 2 + 2?", "a) 3", "b) 4", "c) 5", "d) 6", "b"));
        perguntasMatematica.add(new Pergunta("Quanto é 5 x 8?", "a) 35", "b) 40", "c) 45", "d) 50", "b"));
        perguntasMatematica.add(new Pergunta("Quanto é a raiz quadrada de 25?", "a) 3", "b) 4", "c) 5", "d) 6", "c"));
        perguntasMatematica.add(new Pergunta("Qual é o resultado de 10 / 2?", "a) 3", "b) 4", "c) 5", "d) 6", "c"));
        perguntasMatematica.add(new Pergunta("Quanto é 3²?", "a) 6", "b) 8", "c) 9", "d) 12", "c"));

        // Adicionar perguntas de curiosidades gerais
        perguntasCuriosidades.add(new Pergunta("Qual é a montanha mais alta do mundo?", "a) Everest", "b) K2", "c) Kangchenjunga", "d) Lhotse", "a"));
        perguntasCuriosidades.add(new Pergunta("Qual é o maior animal terrestre?", "a) Elefante africano", "b) Girafa", "c) Hipopótamo", "d) Rinoceronte", "a"));
        perguntasCuriosidades.add(new Pergunta("Qual é o filme de maior bilheteria da história?", "a) Avatar", "b) Vingadores: Ultimato", "c) Titanic", "d) Star Wars: O Despertar da Força", "b"));
        perguntasCuriosidades.add(new Pergunta("Quantos países existem na Europa?", "a) 25", "b) 30", "c) 35", "d) 40", "c"));
        perguntasCuriosidades.add(new Pergunta("Qual é o idioma mais falado no mundo?", "a) Inglês", "b) Espanhol", "c) Mandarim", "d) Hindi", "c"));
    }

    private static void jogarQuiz(List<Pergunta> perguntas, Scanner scanner) {
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getDescricao());
            for (String alternativa : pergunta.getAlternativas()) {
                System.out.println(alternativa);
            }

            String resposta;
            do {
                System.out.print("Digite a letra da alternativa correta: ");
                resposta = scanner.nextLine().toLowerCase();
            } while (!resposta.equals("a") && !resposta.equals("b") && !resposta.equals("c") && !resposta.equals("d"));

            if (resposta.equals(pergunta.getRespostaCorreta())) {
                System.out.println("Resposta correta!");
            } else {
                System.out.println("Resposta incorreta. Digite novamente.");
                jogarQuiz(perguntas, scanner);
                break;
            }
        }
    }
}

class Pergunta {
    private String descricao;
    private List<String> alternativas;
    private String respostaCorreta;

    public Pergunta(String descricao, String... alternativasEresposta) {
        this.descricao = descricao;
        this.alternativas = new ArrayList<>();
        for (int i = 0; i < alternativasEresposta.length - 1; i++) {
            alternativas.add(alternativasEresposta[i]);
        }
        this.respostaCorreta = alternativasEresposta[alternativasEresposta.length - 1];
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
