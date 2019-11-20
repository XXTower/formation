package fr.excilys.formation.dto;

import java.util.HashSet;
import java.util.Set;

public class RecipeDto {

	private Long id;
	private String name;
	private String picture;
	private String description;
	private Set<RecipeIngredientDto> ingredients = new HashSet<>();
	private Set<String> instructions = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<RecipeIngredientDto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<RecipeIngredientDto> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(Set<String> instructions) {
		this.instructions = instructions;
	}

}
