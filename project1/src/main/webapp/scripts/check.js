let employee = {};

window.onload = function() {
	populateEmployee();
}

function populateUser() {
	//send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8081/ServletDemp/session").then(function(response) {
		return response.json() //parse the response in json format to javascript object
	}).then(function(data) {
		//check whether there is a vlaid session
		//define behavior for whne there is no valid user
		if(data.session === null){
			window.location = "http://localhost:8081/ServletDemp/login"
		} else{
			//define behavior for when a user is returned
			employee = data;
			document.getElementById("fistname").innerText = "fistname: " + employee.firstname;
			document.getElementById("lastname").innerText = "lastname: " + user.lastname;
			document.getElementById("email").innerText = "email: " + employee.email;
			document.getElementById("username").innerText = "username: " + employee.username;
			document.getElementById("password").innerText = "password: " + employee.password;
			document.getElementById("managerID").innerText = "managerID: " + employee.managerID;
		}
	})
}