let requests = {}

window.onload = function() {
	populateEmp();
	document.getElementById('readEmpBut').addEventListener('click', createEmpTable);
	document.getElementById('empRequestsBut').addEventListener('click', getRequests);
}

//displays currently logged in users to a <h1 id="welcomeEmp"> tag
function populateEmp() {
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
			document.getElementById("welcomeEmp").innerText = "Welcome Employee " + employee.firstName + " " + employee.lastName;
		}
	})
}

//makes a table that displays users information
function createEmpTable() {
	fetch("http://localhost:8081/project1/session").then(function(response) {
				let data = response.json();
				return data;
			}).then(function(data) {

		employee = data;
		// Create a HTML Table element.
		let table = document.createElement("TABLE");
		table.border = "1";

		// Add the header row.
		let row = table.insertRow(-1);
		let th = document.createElement("TH");

		th = row.insertCell(-1);
		th.innerHTML = "First Name";

		th = row.insertCell(-1);
		th.innerHTML = "Last Name";

		th = row.insertCell(-1);
		th.innerHTML = "Email";
		
		th = row.insertCell(-1);
		th.innerHTML = "Username";

		// Add the data rows.
		row = table.insertRow(-1);

		let td = row.insertCell(-1);
		td.innerHTML = data.firstName;

		td = row.insertCell(-1);
		td.innerHTML = data.lastName;

		td = row.insertCell(-1);
		td.innerHTML = data.email;

		td = row.insertCell(-1);
		td.innerHTML = data.username;

		// replace the empty div with a table
		let newTable = document.getElementById("readEmp");
		newTable.innerHTML = "";
		newTable.appendChild(table);
	})
}


//fetches requests made by the user from a const variable
function getRequests() {
	fetch("http://localhost:8081/project1/readRequests").then(function(response) {
		let requestList = response.json();
		return requestList;
	}).then(function(requestList) {
		remTableGen(requestList);
	})
}

function remTableGen(data1) {

	// Create a HTML Table element.
	let table = document.createElement("TABLE");
	table.border = "1";

	// Add the header row.
	let row = table.insertRow(-1);
	let headerCell = document.createElement("TH");

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Amount";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Reason";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Status";

	// Add the data rows.
	for (let i = 1; i < data1.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = "$" + data1[i].amount;

		cell = row.insertCell(-1);
		cell.innerHTML = data1[i].reason;

		cell = row.insertCell(-1);
		cell.innerHTML = data1[i].resolved;
	}

	// replace the empty div with a table
	let newTable = document.getElementById("empRequests");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}