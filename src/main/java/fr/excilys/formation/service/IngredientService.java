package fr.excilys.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.excilys.formation.dao.IngredientDAO;
import fr.excilys.formation.dto.IngredientDto;
import fr.excilys.formation.mappeur.IngredientMappeur;
import fr.excilys.formation.model.Ingredient;

@Service
public class IngredientService {
	
	private IngredientDAO ingredientDAO;
	private IngredientMappeur ingredientMappeur;
	
	public IngredientService(IngredientDAO ingredientDAO,IngredientMappeur ingredientMappeur) {
		this.ingredientDAO = ingredientDAO;
		this.ingredientMappeur = ingredientMappeur;
	}
	
	public List<IngredientDto> getAll(){
		List<IngredientDto> listIngredient = new ArrayList<>();
		for(Ingredient in : ingredientDAO.getAll()) {
			listIngredient.add(ingredientMappeur.toIngredientDto(in));
		}
		return listIngredient;
	}
	
	public IngredientDto getById(Long id) {
		return ingredientMappeur.toIngredientDto(ingredientDAO.getById(id));
	}
	
	public void create(String name) {
		Ingredient ingredient = new Ingredient(name);
		ingredientDAO.create(ingredient);
	}
	
	public void update(IngredientDto ingredientDto) {
		ingredientDAO.update(ingredientMappeur.toIngredient(ingredientDto));
	}
	
	public void delete(IngredientDto ingredientDto) {
		ingredientDAO.delete(ingredientMappeur.toIngredient(ingredientDto));
	}
	
	public void deleteById(Long id) {
		ingredientDAO.deleteById(id);
	}
}
