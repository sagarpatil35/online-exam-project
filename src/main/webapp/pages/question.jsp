 <h1>username:- ${session_username}</h1>
 <h1>selected sub:- ${session_sub}</h1>
<script>

var xmlhttp;

	function senddata() {
		xmlhttp = new XMLHttpRequest();
		var qno = document.questionform.qno.value;
		var question = document.questionform.question.value;
		var submittedAnswer = document.questionform.option.value;
		var data = "qno=" + qno + "&question=" + question + "&submittedAnswer="+ submittedAnswer;
		alert(data);
		xmlhttp.open("get", "saveresponse?" + data);
		xmlhttp.send();
	}

	function RemainingTime() {
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onload = showtime;
		xmlhttp.open("get", "getRemainingTime", true);
		xmlhttp.send();
	}

	function showtime() {
		var totalSeconds = xmlhttp.responseText;
		var min = Math.floor(totalSeconds / 60).toString().padStart(2, '0');
		var sec = (totalSeconds - min * 60).toString().padStart(2, '0');
		document.getElementById("show").value = min + ":" + sec;
		if (xmlhttp.responseText == '0') {
			alert("time up .. ");
			location.href = "endexam";
		}
	}
	setInterval(RemainingTime, 1000);
	function changecolor()	{
		var allAnswers=document.getElementsByTagName("span");
		var allRadioButtons=document.getElementsByName("option");
		var ans = document.questionform.ans.value;
		for(var i=0;i<allAnswers.length;i++){
				if(allAnswers[i].innerText.trim()==ans.trim()){
					allAnswers[i].style.color="red";
					allRadioButtons[i].checked=true;
				}
		}
	}
</script>

<style>
	input {
		border: hidden;
	}
	textarea {
		border: hidden;
	}
	#msg{
		color: red;
	}
</style>
 
<h1>${question}</h1>
<body onload="changecolor()">

<form name="questionform" >

remaining time:-  <input  style="border:none" type="text" id="show" value=""><br><br>

<textarea rows=1 cols=2 name="qno"  value="${questions.qno}" readonly >${questions.qno}</textarea>

<input type="text" value="${questions.question}" name="question" ><br><br>

<input type="radio" value="${questions.option1}" name="option" onclick="senddata()">
<span>${questions.option1}</span> <br><br>

<input type="radio" value="${questions.option2}" name="option" onclick="senddata()">
<span>${questions.option2}</span> <br><br>

<input type="radio" value="${questions.option3}" name="option" onclick="senddata()">
<span>${questions.option3}</span> <br><br>

<input type="radio" value="${questions.option4}" name="option" onclick="senddata()">
<span>${questions.option4}</span> <br><br>


<input type="submit" value="next" formaction="next">
<input type="submit" value="previous" formaction="previous">
<input type="submit" value="end exam" formaction="endexam"><br><br>

<input  style="border:none" type="text" name="ans" value="${ans}"><br><br>
</form>
</body>
<h1 id=msg>${Message}</h1>

