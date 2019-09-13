package com.project.recipie.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.recipie.dao.RecipesDAO;
import com.project.recipie.derbyImpl.RecipesDAODerbyImpl;
import com.project.recipie.model.RecipeDataBean;
import com.project.recipie.service.RecipesService;

public class RecipesServiceDirectImpl  implements RecipesService{
	RecipesDAO dao;
	final static Logger logger=Logger.getLogger(RecipesServiceDirectImpl.class);
	final String DBTYPE="derby";
	
	public RecipesServiceDirectImpl()throws Exception {
		try
		{
			if(DBTYPE.equals("derby"))
			{	
				this.dao=new RecipesDAODerbyImpl();
			}
			else
			{
				//default 
				this.dao=new RecipesDAODerbyImpl();
			}
		}
		catch(Exception e)
		{
			logger.error("Error While getting DAO connection"+e.getMessage());
			throw e;
		}
	}
	public void addRecipe(RecipeDataBean bean, String userId) throws Exception {
	
		dao.insertRecipes(bean,userId);

	}

	public void removeRecipe(RecipeDataBean bean, String userId) throws Exception {

		dao.removeRecipes(bean, userId);
	}

	public List<RecipeDataBean> geAllRecipes() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void editRecipe(RecipeDataBean bean, String userid) throws Exception {
		
		dao.updateRecipes(bean, userid);
	}
	public RecipeDataBean getRecipe(RecipeDataBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.getRecipe(bean);
	}

}
