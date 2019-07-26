/**
 * 
 */
window.onload = function() {
	getListOfEmps();
	document.getElementById("empManageIDGoBackBut").addEventListener('click', goBack);
	
}

function goBack() {
	window.history.back();
}

function getListOfEmps() {
	//makes a table that displays users information
	fetch("http://localhost:8081/project1/empsByManageID").then(function(response) {
		let data = response.json();
		return data;
	}).then(function(data) {
		employees = data;
		console.log(employees);
		// Create a HTML Table element.
		let table = document.createElement("TABLE");
		table.border = "1";

		// Add the header row.
		let row = table.insertRow(-1);
		let th = document.createElement("TH");

		th = row.insertCell(-1);
		th.innerHTML = "EmployeeID";
		
		th = row.insertCell(-1);
		th.innerHTML = "First Name";

		th = row.insertCell(-1);
		th.innerHTML = "Last Name";

		th = row.insertCell(-1);
		th.innerHTML = "Email";
			
		th = row.insertCell(-1);
		th.innerHTML = "Username";
		
		th = row.insertCell(-1);
		th.innerHTML = "View Reimbursements";

		//add data to the rows
		for (let i = 0; i < data.length; i++) {
			row = table.insertRow(-1);

			let cell = row.insertCell(-1);
			cell.innerHTML = data[i].employeeID;
			
			cell = row.insertCell(-1);
			cell.innerHTML = data[i].firstName;

			cell = row.insertCell(-1);
			cell.innerHTML = data[i].lastName;
			
			cell = row.insertCell(-1);
			cell.innerHTML = data[i].email;

			cell = row.insertCell(-1);
			cell.innerHTML = data[i].username;
			
			cell = row.insertCell(-1);
			cell.innerHTML = `<button class="btn btn-warning" type="button" id="viewEmpRequests" value="${data[i].employeeID}">View Reimbursement</button>`
			cell.addEventListener('click', viewReimbursementButtonValue);
		}

		// replace the empty div with a table
		let newTable = document.getElementById("empsByManageID");
		newTable.innerHTML = "";
		newTable.appendChild(table);
	})
}

function viewReimbursementButtonValue(cell) {
	console.log(cell);
}