package fr.excilys.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import fr.excilys.formation.model.Recipe;

@Repository
public class RecipeDAO {

private static final String GET_All = "from Recipe";
	
	private EntityManager entityManager;
	
	public RecipeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Recipe> getAll(){
		Session session = entityManager.unwrap(Session.class);
		Query<Recipe> query = session.createQuery(GET_All, Recipe.class);
		return query.getResultList();
	}
	
	public Recipe getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Recipe.class,id);
	}
	
	@Transactional
	public void update(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.update(recipe);
	}
	
	@Transactional
	public void deleteById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Recipe recipe = session.get(Recipe.class,id);
		session.remove(recipe);
	}
	
	@Transactional
	public void delete(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		Recipe recipeDB = session.get(Recipe.class,recipe.getId());
		session.remove(recipeDB);
	}
	
	@Transactional
	public void create (Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.save(recipe);
	}
}
