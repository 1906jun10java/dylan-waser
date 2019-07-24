let employee = {};

window.onload = function() {
	populateEmployee();
}

function populateEmployee() {
	//send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8081/project1/session").then(function(response) {
		return response.json(); //parse the response in json format to javascript object
	}).then(function(data) {
		console.log(data);
		//check whether there is a vlaid session
		//define behavior for whne there is no valid user
		if(data.session === null){
			window.location = "http://localhost:8081/project1/login"
		} else{
			//define behavior for when a user is returned
			employee = data;
			document.getElementById("firstName").innerText = "firstName: " + employee.firstName;
			document.getElementById("lastName").innerText = "lastName: " + employee.lastName;
			document.getElementById("email").innerText = "email: " + employee.email;
			document.getElementById("username").innerText = "username: " + employee.username;
		}
	})
}