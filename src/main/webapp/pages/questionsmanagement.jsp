<style>
	div{
		text-align: center;
		border: 1px solid gray;
	}
</style>

<div>
<form>	
		<br><br>
qno:-	<input type="text" name="qno"  value="${questions.qno}" placeholder="Enter question number" required><br><br>
	
question:-	<input type="text" value="${questions.question}" name="question" placeholder="Enter question"><br><br>
		
option1:-	<input type="text" value="${questions.option1}" name="option1" placeholder="Enter option" ><br><br>
	
option2:-	<input type="text" value="${questions.option2}" name="option2" placeholder="Enter option"><br><br>
		
option3:-	<input type="text" value="${questions.option3}" name="option3" placeholder="Enter option" ><br><br>
	
option4:-	<input type="text" value="${questions.option4}" name="option4" placeholder="Enter option"><br><br>
		
answer:-	<input type="text" value="${questions.answer}"name="answer" placeholder="Enter Answer" ><br><br>

subject:-	<input type="text" value="${questions.subject}" name="subject" placeholder="Enter subject" ><br><br>
			gk/maths/java <br><br>

			
	<input type="submit" value="addQuestion" formaction="addQuestion">
	<input type="submit" value="viewQuestion" formaction="viewQuestion">
	<input type="submit" value="deleteQuestion" formaction="deleteQuestion">
	<input type="submit" value="updateQuestion" formaction="updateQuestion">
</form>
</div>
${message}
