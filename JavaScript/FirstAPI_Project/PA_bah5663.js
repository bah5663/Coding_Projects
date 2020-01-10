let descArray = [];

let request = new XMLHttpRequest();

request.open("GET","https://ghibliapi.herokuapp.com/films", true);
request.onload = function() {
    data = JSON.parse(this.response);

    var list = document.getElementById('movieList');

    data.forEach(movie=> 
        {
            let title = movie.title;
            descArray.push(movie.description);
            var option = document.createElement('option');
            option.value = 'option value'; 
            option.appendChild(document.createTextNode(title));
            list.appendChild(option); 
        })
    //displaying the first movie description
    var description = document.querySelector("#desc");
    var textNode = document.createTextNode("Description:  " + descArray[0]);
    description.appendChild(textNode);
}
request.send();

function displayDesc(){
    let index = document.querySelector("#movieList").selectedIndex;
    var description = document.querySelector("#desc");
    //removing previous description before displaying new one
    while(description.firstChild){
        description.removeChild(description.firstChild);
    }
    var textNode = document.createTextNode("Description:  " + descArray[index]);
    description.appendChild(textNode);
}