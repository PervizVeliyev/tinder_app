<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <div class="container">
        <div class="row align-items-center">
            <div class="col-10">
                <div class="logo">
                    <div class="image">
                        <img src="https://cdn-icons-png.flaticon.com/128/508/508735.png"/>
                    </div>
                    <div class="title">
                        <h1>Tinder</h1>
                    </div>
                </div>
            </div>
            <div class="col-2">
                <div class="btn-logout" title="Logout" onclick="location.href='/logout'">
                    <img src="https://cdn-icons-png.flaticon.com/512/126/126467.png"/>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title">User List</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
                            <tbody>
                            <#list users as user>
                                <tr onclick="location.href='/message/${user.getId()}'" class="bg-danger">
                                    <td>
                                        <div class="avatar-img">
                                            <img class="img-circle" src="${user.getPhotoLink()}"/>  
                                        </div>
                                    </td>
                                    <td class="align-middle">
                                        ${user.getName()}
                                        ${user.getSurname()}
                                    </td>
                                    <td class="align-middle">
                                        ${user.getProfession()}
                                    </td>
                                    <td class="align-middle">
                                        Last Login: ${user.getLastLogin()}<br><small
                                                class="text-white">${user.getLastLoginGap()}</small>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>