package fr.excilys.formation.mappeur;

import org.springframework.stereotype.Component;

import fr.excilys.formation.dto.IngredientDto;
import fr.excilys.formation.model.Ingredient;

@Component
public class IngredientMappeur {

	public IngredientDto toIngredientDto (Ingredient ingredient) {
		IngredientDto ingredientDto = new IngredientDto();
		ingredientDto.setId(ingredient.getId());
		ingredientDto.setName(ingredient.getName());
		return ingredientDto;
	}
	
	public Ingredient toIngredient ( IngredientDto ingredientDto) {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ingredientDto.getId());
		ingredient.setName(ingredientDto.getName());
		return ingredient;
	}
}
