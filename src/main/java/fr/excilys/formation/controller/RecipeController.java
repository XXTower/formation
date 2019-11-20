package fr.excilys.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.excilys.formation.dto.RecipeDto;
import fr.excilys.formation.dto.RecipeIngredientDto;
import fr.excilys.formation.service.RecipeService;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
	
	private RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping
	public List<RecipeDto> getAll(){
		return recipeService.getAll();
	}
	
	@PostMapping
	public void createRecipe(@RequestBody RecipeDto recipeDto) {
		recipeService.create(recipeDto);
	}
	
	@PutMapping
	public void updateRecipe(@RequestBody RecipeDto recipeDto) {
		recipeService.update(recipeDto);
	}
	
	@DeleteMapping
	public void deleteRecipe(@RequestBody RecipeDto recipeDto) {
		recipeService.delete(recipeDto);
	}
	
	@GetMapping("/{id}")
	public RecipeDto getRecipeById(@PathVariable Long id) {
		return recipeService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecipeById(@PathVariable Long id) {
		recipeService.deleteById(id);
	}
	
	@PatchMapping("/ingredients")
	public void addIngredients(@RequestParam("id") Long id, @RequestBody List<RecipeIngredientDto> recipeIngredientDto) {
		recipeService.updateIngrdient(id, recipeIngredientDto);
	}
	
}
