package fr.excilys.formation.mappeur;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import fr.excilys.formation.dto.RecipeDto;
import fr.excilys.formation.dto.RecipeIngredientDto;
import fr.excilys.formation.model.Recipe;
import fr.excilys.formation.model.RecipeIngredient;

@Component
public class RecipeMappeur {
	
	private RecipeIngredientMappeur recipeIngredientMappeur;
	
	public RecipeMappeur(RecipeIngredientMappeur recipeIngredientMappeur) {
		this.recipeIngredientMappeur = recipeIngredientMappeur;
	}
	
	public RecipeDto toRecipeDto (Recipe recipe) {
		Set<RecipeIngredientDto> ingredients = new HashSet<>();
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setId(recipe.getId());
		recipeDto.setDescription(recipe.getDescription());
		recipeDto.setPicture(recipe.getPicture());
		recipeDto.setInstructions(recipe.getInstructions());
		for(RecipeIngredient recipeingredient : recipe.getIngredients()) {
			ingredients.add(recipeIngredientMappeur.toRecipeIngredientDto(recipeingredient));
		}
		recipeDto.setIngredients(ingredients);
		return recipeDto;
	}
	
	public Recipe toRecipe (RecipeDto recipeDto) {
		Set<RecipeIngredient> ingredients = new HashSet<>();
		Recipe recipe = new Recipe();
		recipe.setId(recipeDto.getId());
		recipe.setDescription(recipeDto.getDescription());
		recipe.setPicture(recipeDto.getPicture());
		recipe.setInstructions(recipeDto.getInstructions());
		for(RecipeIngredientDto recipeingredient : recipeDto.getIngredients()) {
			ingredients.add(recipeIngredientMappeur.toRecipeIngredient(recipeingredient));
		}
		recipe.setIngredients(ingredients);
		return recipe;
	}
}
