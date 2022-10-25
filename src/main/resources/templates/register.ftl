
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tinder App | Register</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body class="text-center">
    <form method="post" class="form-signin">
        <img class="mb-4" src="https://cdn-icons-png.flaticon.com/128/5836/5836184.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Register</h1>
        <label for="inputName" class="sr-only">Name</label>
        <input type="text" id="inputName" class="form-control border-fix" name="name" placeholder="Name" required autofocus>
        <label for="inputSurname" class="sr-only">Surname</label>
        <input type="text" id="inputSurname" class="form-control borderless" name="surname" placeholder="Surname" required>
        <label for="inputPhoto" class="sr-only">Photo</label>
        <input type="text" id="inputPhoto" class="form-control borderless" name="photo" placeholder="Photo link (leave empty for default)">
        <label for="inputProfession" class="sr-only">Profession</label>
        <input type="text" id="inputProfession" class="form-control borderless" name="profession" placeholder="Profession" required>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control borderless" name="mail" placeholder="Email address" required>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
        <a href="/login" style="display: inline-block" class="mt-3">Already have an account? Sign in</a>
        <p class="mt-5 mb-3 text-muted">&copy; Tinder 2022</p>
    </form>
</body>
</html>