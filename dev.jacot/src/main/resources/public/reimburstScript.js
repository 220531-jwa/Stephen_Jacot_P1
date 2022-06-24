let baseUrl = "http://localhost:8080";

async function login() {
    console.log("login button pressed");

    let uname = document.getElementById('uname').value;

    let pass = document.getElementById('pass').value;

    let user = {
        username: uname,
        password: pass
    }

    let employeeJson = JSON.stringify(user);

    let res = await fetch(
                        `${baseUrl}/login`,
                        {
                            method: 'POST',
                            header: {'Content-Type': 'application/json'},
                            body : employeeJson
                        }
    );

    let resJson = await res.json()

    .then((resp) => {
        window.location.assign("employeeHomePage.html");
    })

    .catch((error) => 
    {
        console.log(error);
    });
}