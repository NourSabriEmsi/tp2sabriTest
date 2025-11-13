package fr.unica.miage.nours.langchain4j;


import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class Test3 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        EmbeddingModel model = GoogleAiEmbeddingModel
                .builder()
                .apiKey(cle)
                .modelName("gemini-embedding-001")
                .taskType(GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY)
                .outputDimensionality(300)
                .timeout(Duration.ofSeconds(2))
                .build();
        
        String phrase1 = "L’intelligence artificielle progresse rapidement.";
        String phrase2 = "Les modèles de langage changent la technologie moderne.";

        Response<Embedding> reponse1 = model.embed(phrase1);
        Response<Embedding> reponse2 = model.embed(phrase2);

        Embedding emb1 = reponse1.content();
        Embedding emb2 = reponse2.content();

        double similarite = CosineSimilarity.between(emb1, emb2);
        System.out.println("similarite cosinus : " + similarite);

    }
}