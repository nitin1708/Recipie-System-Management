<html>
<head>
<script src="jscript/jquery-3.4.1.min.js"></script>
<script src="jscript/jquery.serializeToJSON.js"></script>

<script>

  $("#submitAdd").click(function(){
	  var recipeObject=$("#addRecipeForm").serializeToJSON({});
	  var jsonData=JSON.stringify(recipeObject);

	  $.ajax(restURL+"add",{
		  dataType: 'json',
          contentType: 'application/json',
			type: 'POST',  // http method
			data:jsonData , 
			success: function (response, status, xhr) {
				
				if(response.status.toUpperCase()=="SUCCESS")
					{
					$('#message').html("");
					
					$('#message').append('New Recipe Added ').show().delay(2000).fadeOut();
					
						getRequiredRecipies(restURL);
					}
			},
			error: function (jqXhr, textStatus, errorMessage) {
					$('#message').append('Error: ' + errorMessage);
				}	
	  }
	  	);
	  
  });
  

  
});
</script>
</head>
<body>


<div id="createRecipesDiv">
Add Recipes 

<form action="addRecipe" method="post" id="addRecipeForm">
<br/>
 Recipie Name : <input name="recipeName" type="text" />
<br/> Vegiterian  Or NonVegiterian :  <input name="isVeg" type="text" value="veg" /> 
 <br/>Total no of Persons: <input name="numberOfPeople" type="text" />
 <br/>instructions: <input name="instructions" type="textarea" />
 <br/>Ingredients: <input name="ingredients" type="text" />
  
  <br/><input value ="submit" type="button" id="submitAdd" /> 
  <br/><input value ="RESET" type="reset" /> 
  <input value="add" name="recipeAction" type="hidden" />
  
</form>

</div>

</form>
 </div>

</body>
</html>
