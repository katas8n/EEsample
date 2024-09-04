<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Dashboard</title>
    </head>
    <body>
        <section id="dashboard">
            <h2>Dashboard</h2>

            <form action="todos" method="post">
                <fieldset>
                    <p>Add title</p>
                    <input type="text" id="title" name="title" />
                </fieldset>

                <fieldset>
                    <p>Add Description</p>
                    <input type="text" id="title" name="title" />
                </fieldset>

                <fieldset>
                    <select name="status" id="status">
                        <option value="PENDING">PENDING</option>
                        <option value="COMPLETED">COMPLETED</option>
                    </select>
                </fieldset>

                <input type="submit" name="submit" id="submit" />
            </form>
        </section>
    </body>
</html>
