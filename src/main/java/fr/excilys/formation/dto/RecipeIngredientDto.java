package fr.excilys.formation.dto;

public class RecipeIngredientDto {

	private Long id;
	private IngredientDto ingredient;
	private Long quantity;
	private String unit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IngredientDto getIngredient() {
		return ingredient;
	}

	public void setIngredient(IngredientDto ingredient) {
		this.ingredient = ingredient;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
