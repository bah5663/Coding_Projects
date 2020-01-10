
function displayData() {
    let request = new XMLHttpRequest();
    let pokemon = document.getElementById("searchBox").value;

    if (pokemon === "")
    {
      pokemon = document.getElementById("selects").value;
    }

    let URL = 'http://127.0.0.1:3000/pokemon/' + pokemon;
    request.open('GET', URL, true);

    request.onload = function () {
        if (request.status == 200) {
            let data = JSON.parse(this.response);

            document.getElementById("pokemonName").value = data.name;
            document.getElementById("hp").value = data.stats[5].base_stat;
            document.getElementById("atk").value = data.stats[4].base_stat;
            document.getElementById("def").value = data.stats[3].base_stat;
            document.getElementById("spatk").value = data.stats[2].base_stat;
            document.getElementById("spdef").value = data.stats[1].base_stat;
            document.getElementById("spe").value = data.stats[0].base_stat;
            //document.getElementById("evyield").value = "";
            var eve = "";
            if (data.stats[5].effort > 0){

              var stat = "HP: " + data.stats[5].effort + " ";
              eve += stat;
            }
             if(data.stats[4].effort > 0){

                var stat = "Attack: " + data.stats[4].effort + " ";
                eve += stat;
            }
             if(data.stats[3].effort > 0){

              var stat = "Defense: " + data.stats[3].effort + " ";
              eve += stat;
            }
            if(data.stats[2].effort > 0){
              var stat = "Special Attack: " + data.stats[2].effort + " ";
                eve += stat;

            }
             if(data.stats[1].effort > 0){

                var stat = "Special Defense: " + data.stats[1].effort + " ";
                eve += stat;
            }
             if(data.stats[0].effort > 0){

                var stat = "Speed: " + data.stats[0].effort + " ";
                eve += stat;
            }
            document.getElementById("evyield").value = eve;
                  }
    }
    request.send();
}

// function writeFavorite() {
//     pokemon = document.getElementById("searchBox").value;
//     alert(pokemon + "add to favorites list!");
//     if (fs.existsSync('favorites.json')) {
//         let data = fs.readFileSync('favorites.json');
//         let newList = JSON.parse(data);
//         newList.push(pokemon);
//         fs.writeFile('favorites.JSON', JSON.stringify(newList), (err) => {
//             if (err) {
//                 console.error(err);
//                 return;
//             };
//         });
//     } else {
//         let favList = [];
//         favList.push(pokemon);
//         fs.writeFile('favorites.JSON', JSON.stringify(favList), (err) => {
//             if (err) {
//                 console.error(err);
//                 return;
//             };
//         });
//     }
//     var para = document.createElement("p");
//     var node = document.createTextNode(pokemon);
//     para.appendChild(node);
//     var element = document.getElementById("div1");
//     element.appendChild(para);
// }

function getFavorites() {

  let request = new XMLHttpRequest();
  let URL = 'http://127.0.0.1:3000/pokemon/favorites';
  request.open('GET', URL, true);

  request.onload = function () {
      if (request.status == 200) {
          let data = JSON.parse(this.response);
          var select = document.querySelector("#selects");
          data.forEach(pokemon=> {

            var option = document.createElement("option");
            option.text = pokemon.name;
            option.value = pokemon.name;
            select.appendChild(option);
          });

      }

    }
  request.send();

}

function writeFavorite() {
  pokemon = document.getElementById("searchBox").value;
  let request = new XMLHttpRequest();
  let URL = 'http://127.0.0.1:3000/pokemon/favorite/' + pokemon;
  request.open('PUT', URL, true);

  request.onload = function () {
    alert(pokemon + " added to favorites list!");
  }



    request.send();
  }
