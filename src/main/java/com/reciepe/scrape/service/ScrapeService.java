package com.reciepe.scrape.service;

import com.reciepe.scrape.model.RecipeRequest;
import com.reciepe.scrape.model.RecipeResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScrapeService {
    public RecipeResponse getResponse(RecipeRequest recipeRequest) throws IOException {
        RecipeResponse recipeResponse = new RecipeResponse();
        Document document = Jsoup.connect(recipeRequest.getUrl()).get();
        extractIngredients(document, recipeResponse.getIngredients());
        extractInstructions(document, recipeResponse.getInstructions());
        return recipeResponse;


    }

    private void extractIngredients(Document document, List<String> ingredientsList) {
        document.select(".ingredients-list")
                .select(".ingredient-section")
                .select(".list--bullets")
                .select("li")
                .forEach(val -> {
                    ingredientsList.add(val.text());
                });
    }

    private void extractInstructions(Document document, List<String> instructionsList) {
        document.select(".field--recipe-steps")
                .select(".list--numbers")
                .select("li")
                .forEach(val -> {
                    instructionsList.add(val.text());
                });
    }
}
