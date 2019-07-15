//Part 1
//this is for BookShelf part
let bookShelf = [{title:"Warriors", author:"Erin Hunter", genre:"Fantasy Fiction", coverImage:"Picture"},
                    {title:"The Reckoning", author:"John Grisham", genre:"Horror", coverImage:"Pciture"}];

document.getElementById("insert").innerHTML = bookShelf[0].title;

//Part 2
window.onload = function(){
    document.getElementById("card").onclick = function() {
        sendAjaxGet('https://api.magicthegathering.io/v1/cards', showCard);
    };
}

function sendAjaxGet(url, func){
    //step 1: get XHR object
    let xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");

    //step 2: define onreadystatechange
    xhttp.onreadystatechange = function(){
        //readyState of 4 means request is complete
        //status of 200 means ok
        if(this.readyState = 4 && this.status == 200) {
            func(this);
        };
    }

    //step 3: prepare the request
    xhttp.open("GET", url, true);

    // step 4: send the request
    xhttp.send(); //IF WE WERE SENDING A POST REQUEST FOR ANYTHING THAT USED THE BODY
    //IT WOULD GO AS AN ARGUMENT TO SEND()
}

function showCard(xhttp){
    let cardObject = JSON.parse(xhttp.responseText);
    console.log(cardObject);
}