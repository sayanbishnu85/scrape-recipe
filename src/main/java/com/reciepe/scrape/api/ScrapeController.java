package com.reciepe.scrape.api;

import com.reciepe.scrape.model.RecipeRequest;
import com.reciepe.scrape.model.RecipeResponse;
import com.reciepe.scrape.service.ScrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/scrape")
public class ScrapeController {
    @Autowired
    private ScrapeService scrapeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RecipeResponse getRecipeInstructionsAndIngredients(@RequestBody RecipeRequest recipeRequest) throws IOException {
        return this.scrapeService.getResponse(recipeRequest);
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseEntity<String> handleException(IOException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }
}
