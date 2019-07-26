/**
 * 
 */
window.onload = function() {
	getEmpReimbursements();
}

function getEmpReimbursements() {
	fetch("http://localhost:8081/project1/empReimbursements").then(function(response) {
		let requestList = response.json();
		return requestList;
	}).then(function(requestList) {
		console.log(requestList);
		remTableGen(requestList);
	})
}

function remTableGen(data) {
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
	headerCell.innerHTML = "Photo";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Unresolved?";
	// Add the data rows.
	for (let i = 0; i < data1.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = "$" + data1[i].amount;

		cell = row.insertCell(-1);
		cell.innerHTML = data1[i].reason;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data1[i].photo;

		cell = row.insertCell(-1);
		cell.innerHTML = data1[i].resolvedBit;
		
		
	}

	// replace the empty div with a table
	let newTable = document.getElementById("empRequests");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}