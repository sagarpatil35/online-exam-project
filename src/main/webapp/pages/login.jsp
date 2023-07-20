<style>
	#h {
		color: red;
	}

	body {
		background-color: grey;
	}


</style>

<h1 id=h> ${Message} </h1>

<body>
<form><br>
Enter UsersName:- 
<input type="text" name="username" placeholder="enter user name" required="required"><br><br>
Enter Password:- 
<input type="password" name="password" placeholder="enter password" required="required"><br><br>

<input type="submit" value="login" formaction="selectsub" class="btn" >&nbsp;&nbsp;

<input type="reset"  value="clear" class="btn" ><br><br>
</form>

<form>
<input type="submit" value="register" formaction="register">
</form>

</body>

