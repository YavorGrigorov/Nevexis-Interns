<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> My first JSP   </title>
	</head>	
	<body>		
		<form action="servlet2" method="post">			
			 Please enter a color <br>
			<input type="text" name="color"size="20px">
			<input type="submit" value="submit">				
			<% response.getWriter().print("<br/>Hello roko!"); %>										
		</form>		
	</body>	
</html>