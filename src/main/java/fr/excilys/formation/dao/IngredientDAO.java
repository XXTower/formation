package fr.excilys.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.excilys.formation.model.Ingredient;

@Repository
public class IngredientDAO {
	
	private static final String GET_All = "from Ingredient";
	
	private EntityManager entityManager;
	
	IngredientDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public List<Ingredient> getAll(){
		Session session = entityManager.unwrap(Session.class);
		Query<Ingredient> query = session.createQuery(GET_All, Ingredient.class);
		return query.getResultList();
	}
	
	public Ingredient getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Ingredient.class,id);
	}
	
	@Transactional
	public void deleteById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Ingredient ingredient = session.get(Ingredient.class,id);
		session.remove(ingredient);
	}
	
	@Transactional
	public void create(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ingredient);
	}
	
	@Transactional
	public void update(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(ingredient);
	}
	
	@Transactional
	public void delete(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		Ingredient ingredientDB = session.get(Ingredient.class,ingredient.getId());
		session.remove(ingredientDB);
	}

}
