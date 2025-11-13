package fr.unica.miage.nours.langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class Test1 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .temperature(0.7)
                .modelName("gemini-2.5-flash")
                .build();

        String reponse = modele.chat("Peux-tu m'expliquer le concept d'inversion de contrôle (IoC) ?");
        System.out.println(reponse);

    }
}