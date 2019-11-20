package fr.excilys.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.excilys.formation.dao.IngredientDAO;
import fr.excilys.formation.dao.RecipeDAO;
import fr.excilys.formation.dto.RecipeDto;
import fr.excilys.formation.dto.RecipeIngredientDto;
import fr.excilys.formation.mappeur.RecipeMappeur;
import fr.excilys.formation.model.Recipe;
import fr.excilys.formation.model.RecipeIngredient;

@Service
public class RecipeService {
	
	private RecipeDAO recipeDAO;
	private RecipeMappeur recipeMappeur;
	private IngredientDAO ingredientDAO;
	
	public RecipeService(RecipeDAO recipeDAO, RecipeMappeur recipeMappeur, IngredientDAO ingredientDAO) {
		this.recipeDAO = recipeDAO;
		this.recipeMappeur = recipeMappeur;
		this.ingredientDAO = ingredientDAO;
	}
	
	public List<RecipeDto> getAll(){
		List<RecipeDto> list = new ArrayList<RecipeDto>();
		for(Recipe recipe  : recipeDAO.getAll()) {
			list.add(recipeMappeur.toRecipeDto(recipe));
		}
		return list;
	}
	
	public RecipeDto getById(Long id) {
		return recipeMappeur.toRecipeDto(recipeDAO.getById(id));
	}
	
	public void update(RecipeDto recipeDto) {
		recipeDAO.update(recipeMappeur.toRecipe(recipeDto));
	}
	
	public void deleteById(Long id) {
		recipeDAO.deleteById(id);
	}
	
	public void delete(RecipeDto recipeDto) {
		recipeDAO.delete(recipeMappeur.toRecipe(recipeDto));
	}
	
	public void create(RecipeDto recipeDto) {
		Recipe recipe = recipeMappeur.toRecipe(recipeDto);
		setIngredient(recipe);
		recipeDAO.create(recipe);
	}
	
	public void updateIngrdient(Long id, List<RecipeIngredientDto> recipeIngredientDto) {
		RecipeDto recipeDto = getById(id);
		
		recipeDto.getIngredients().addAll(recipeIngredientDto);
		Recipe recipe = recipeMappeur.toRecipe(recipeDto);
		setIngredient(recipe);
		recipeDAO.update(recipe);
	}
	
	public void setIngredient(Recipe recipe) {
		for(RecipeIngredient ingredient : recipe.getIngredients()) {
			ingredientDAO.create(ingredient.getIngredient()); 
		}
	}
}
