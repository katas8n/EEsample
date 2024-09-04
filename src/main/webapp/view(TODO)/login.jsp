<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>

        <form action="/dashboard">
            <fieldset>
                <label for="username">Name: </label>
                <input type="text" name="username" id="username" required />
            </fieldset>

            <fieldset>
                <label for="username">Password: </label>
                <input type="text" name="password" id="password" required />
            </fieldset>

            <input type="submit" value="Login" />

            <p>Don't have an account? <a href="/regist">Register Page</a></p>
        </form>
    </body>
</html>
