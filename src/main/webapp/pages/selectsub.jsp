 <h1>username:- ${session_username}</h1>
 <h1>***${Message}***</h1>
 
<script>

var xmlhttp;

function getAllSubjects(){
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onload=showAllSubjects;
	xmlhttp.open("get","getAllSubjects",true);
	xmlhttp.send();
}

function showAllSubjects(){
	alert(xmlhttp.responseText);
	var allsubjects =JSON.parse(xmlhttp.responseText);
	alert(allsubjects);//[maths,gk,java]
	
	var combobox=document.getElementById("selectedSubject");

	for(var i=0;i<allsubjects.length;i++){
		var option=document.createElement('option');
		option.text=allsubjects[i];//java
		option.value=allsubjects[i];//java
		combobox.add(option);
	}
}

</script>
 
 
<body onload="getAllSubjects()">

<form>
		<select name="selectsub" id="selectedSubject">
			
		</select><br><br><br><br>
		
<input type="submit" value="Start Exam" formaction="startexam" >
</form>

</body>