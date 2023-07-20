<script>
	function change(input) {
		input.style.color = "white";
		input.style.background = "black";
	}
</script>

<form><br><br>
Enter UsersName:- 
<input type="text" name=username placeholder="enter username" onfocus="change(this)" required="required"><br><br>
Enter Password:- 
<input type="password" name=password placeholder="enter password" onfocus="change(this)" required="required"><br><br>
Enter MobailNumber:- 
<input type="number" name=mobilenumber placeholder="enter mobailnumber" onfocus="change(this)" required="required"><br><br>
Enter EmailId:- 
<input type="email" name=emailid placeholder="enter emailid" onfocus="change(this)" required="required"><br><br>
Enter Date Of Birth:- 
<input type="date" name=dateofbirth onfocus="change(this)" required="required"><br><br>

<input type="submit" value="submith" formaction="registerdata" >&nbsp;&nbsp;&nbsp;&nbsp;

<input type="reset" value="clear"><br><br>
</form>

<form>
<input type="submit" value="login" formaction="login">
</form>
