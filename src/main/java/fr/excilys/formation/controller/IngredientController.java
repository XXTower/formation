package fr.excilys.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.excilys.formation.dto.IngredientDto;
import fr.excilys.formation.service.IngredientService;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

	private IngredientService ingredientService;
	
	
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
		
	}
	
	@GetMapping
	public List<IngredientDto> getAll(){
		return ingredientService.getAll();
	}
	
	@PostMapping
	public void insertIngredient(@RequestBody String name) {
		ingredientService.create(name);
	}
	
	@PutMapping
	public void updateIngredient(@RequestBody IngredientDto ingredientDto) {
		ingredientService.update(ingredientDto);
	}
	
	@DeleteMapping
	public void deleteIngredient(@RequestBody IngredientDto ingredientDto) {
		ingredientService.delete(ingredientDto);
	}
	
	@GetMapping(value = "/{id}")
	public IngredientDto getIngedientById(@PathVariable Long id) {
		return ingredientService.getById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteIngredientById(@PathVariable Long id) {
		ingredientService.deleteById(id);
	}
	
}
