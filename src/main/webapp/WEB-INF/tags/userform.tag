<div>
	<form action=${applicationScope.formAction } method="post">
	    <input type="hidden" name="id" value=${applicationScope.user.id} />
	    <label for="fname">First Name</label>
	    <input type="text" required name="fname" value=${applicationScope.user.firstName}>
	
	    <label for="lname">Last Name</label>
	    <input type="text" required name="lname" value=${applicationScope.user.lastName} >
	  
	    <input type="submit" value="Submit">
	  </form>
</div>