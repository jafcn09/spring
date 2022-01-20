
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <main class="p-4 d-flex flex-column align-items-center">
	  <div style="width: 40vw;">
	  	<img style="width: 40vw; height:20vw;" src="img/aula.jpg">
	  
	  </div>
	  <div class="card" style="width: 40vw;">
		  <div class="card-body">
		  	<form method="post" class="pb-4" action="usuario">
					<h3 class="text-center">Iniciar sesión</h3>
					<label for="username">Nombre de usuario</label>
					<input type="text" class="form-control" id="username" name="username" placeholder="Usuario" required autofocus /><br>
					<label for="password">Password</label>
					<input type="password" class="form-control" id="password" name="password" placeholder="Password" required /><br>
					<input type="hidden" name="action" value="login"/>					
					<div class="p-4 d-flex flex-ro1 justify-content-around">
						<input type="submit" value="Login" class="btn btn-primary" />
					</div>
			</form>  
		  </div>
	  </div>
  </main>
</body>
</html>