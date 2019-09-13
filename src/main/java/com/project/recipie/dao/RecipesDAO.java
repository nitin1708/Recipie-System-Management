package com.project.recipie.dao;

import java.util.List;

import com.project.recipie.model.RecipeDataBean;

public interface RecipesDAO {

	public void insertRecipes(RecipeDataBean bean,String user) throws Exception;
	public void removeRecipes(RecipeDataBean bean,String user)throws Exception;
	public void updateRecipes(RecipeDataBean bean,String user)throws Exception;
	public List<RecipeDataBean> getAll()throws Exception;
	public RecipeDataBean getRecipe(RecipeDataBean bean)throws Exception;
	
}
