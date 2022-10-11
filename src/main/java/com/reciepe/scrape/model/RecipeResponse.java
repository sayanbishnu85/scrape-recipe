package com.reciepe.scrape.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RecipeResponse {


    private List<String> instructions;
    private List<String> ingredients;

    public RecipeResponse() {
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
    }
}
