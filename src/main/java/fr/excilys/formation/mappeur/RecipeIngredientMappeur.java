package fr.excilys.formation.mappeur;

import org.springframework.stereotype.Component;

import fr.excilys.formation.dto.RecipeIngredientDto;
import fr.excilys.formation.model.RecipeIngredient;

@Component
public class RecipeIngredientMappeur {
	
	private IngredientMappeur ingredientMappeur;
	
	public RecipeIngredientMappeur(IngredientMappeur ingredientMappeur) {
		this.ingredientMappeur = ingredientMappeur;
	}
	
	public RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient) {
		RecipeIngredientDto recipeIngredientDto = new RecipeIngredientDto();
		recipeIngredientDto.setId(recipeIngredient.getId());
		recipeIngredientDto.setQuantity(recipeIngredient.getQuantity());
		recipeIngredientDto.setUnit(recipeIngredient.getUnit());
		recipeIngredientDto.setIngredient(ingredientMappeur.toIngredientDto(recipeIngredient.getIngredient()));
		return recipeIngredientDto;
	}
	
	public RecipeIngredient toRecipeIngredient(RecipeIngredientDto recipeIngredientDto) {
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		recipeIngredient.setId(recipeIngredientDto.getId());
		recipeIngredient.setQuantity(recipeIngredientDto.getQuantity());
		recipeIngredient.setUnit(recipeIngredientDto.getUnit());
		recipeIngredient.setIngredient(ingredientMappeur.toIngredient(recipeIngredientDto.getIngredient()));
		return recipeIngredient;
	}
}
