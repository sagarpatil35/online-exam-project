<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script>

	var images = [ "Image1", "Image2", "Image3", "Image4" ];
	var currentIndex = -1;
	function changeImage() {
		var img = document.getElementById("i1");
		currentIndex++;
		if (currentIndex == images.length)
			currentIndex = 0;
		img.src = "images/" + images[currentIndex] + ".jpg";
	}
	setInterval(changeImage, 3000);
	
</script>
</head>

<h1>username:- ${session_username}</h1>
<h1>selected sub:- ${session_sub}</h1>
<h1>score :- ${marks}</h1>
<br><br><br>
<table>
		<tr>
			<th>qno</th>
			<th>question</th>
			<th>submittedAnswer</th>
			<th>OriginalAnswer</th>
		</tr>
		
</table>

<div>
	<img src="images/Image4.jpg" width=300 height=300 id="i1">
</div>
