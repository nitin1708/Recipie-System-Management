package com.project.recipie.service;

import java.util.List;

import com.project.recipie.model.RecipeDataBean;

public interface RecipesService {

	public void addRecipe(RecipeDataBean bean,String userId) throws Exception;
	public void removeRecipe(RecipeDataBean bean,String userId) throws Exception;
	public List<RecipeDataBean> geAllRecipes() throws Exception;
	public void editRecipe(RecipeDataBean bean,String userid)throws Exception;
	public RecipeDataBean getRecipe(RecipeDataBean bean)throws Exception;
}
