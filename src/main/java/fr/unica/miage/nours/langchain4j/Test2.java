package fr.unica.miage.nours.langchain4j;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINI_KEY");
        ChatModel chatModel = GoogleAiGeminiChatModel.builder().apiKey(apiKey).modelName("gemini-2.5-flash").temperature(0.6).build();PromptTemplate tradTemplate = PromptTemplate.from("""
                Traduire en anglais le texte suivant :"{{phrase}}"
                """);
        Prompt tradPrompt = tradTemplate.apply(Map.of(
                "phrase", "L'intelligence artificielle transforme la manière dont nous interagissons avec la technologie."));
        String resultat = chatModel.chat(tradPrompt.text());System.out.println("Texte original : " + tradPrompt.text());System.out.println("Traduction : " + resultat);
    }
}
