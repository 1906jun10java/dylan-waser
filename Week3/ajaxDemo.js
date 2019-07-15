window.onload = function(){
    document.getElementById("weather").onclick = function(){
        sendAjaxGet('', showWeather);
    };
}

//perform ajax call
//url represents the resource being requested
//func represents the callback function to be invoked when the request is complete
function sendAjaxGet(url, func) {
    //step 1: get XHR object
    let xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");

    //step 2: define onreadystatechange
    xtthp.onreadystatechange = function(){
        //readyState of 4 means request is complete
        //status of 200 means ok
        if(this.readyState = 4 && this.status == 200) {
            func(this);
        }
    }
    //step 3: prepare the request
    xhttp.open("GET", url, true);
    // step 4: send the request
    xhttp.send(); //IF WE WERE SENDING A POST REQUEST FOR ANYTHING THAT USED THE BODY
    //IT WOULD GO AS AN ARGUMENT TO SEND()
}

function showWeather(xhttp){
    let weatherObject = JSON.parse(xhttp.responseText);
    console.log(weatherObject);

    document.getElementById("temperature").innerText = "Current temperature: " + weatherObject.main.temp;
}