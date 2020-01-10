const express = require('express');
let fs = require('fs');

const app = express();
const port = 3000;


const axios = require('axios');



app.listen(port, () => {
  console.log(`Listening on port: ${port}`);
});


app.get('/pokemon/favorites', (req, res) => {

  console.log("server Hit");

  fs.readFile('favorites.json', (err, data) => {
    if (err) throw err;
    favoriteList = JSON.parse(data);
    res.send(favoriteList);
  });
});


app.get('/pokemon/:pokemon', (req, res) => {

  let pokemon = req.params.pokemon;

  var requestString = "https://pokeapi.co/api/v2/pokemon/" + pokemon;


    axios.get(requestString).then(response => {
      res.send(response.data);
    });
});

app.put('/pokemon/favorite/:pokemon', (req, res) => {
  var exists;
  let pokemonName = req.params.pokemon;

  fs.readFile('favorites.json', (err, data) => {
    if (err) throw err;
    favoriteList = JSON.parse(data);
    favoriteList.forEach(pokemon=>{
      if (pokemon.name === pokemonName) {
        exists = true;
      }
      });

      if (!exists)
      {


        var pokeJson =
        {
          name: pokemonName
        };
        favoriteList.push(pokeJson);

  fs.writeFile('favorites.json', JSON.stringify(favoriteList), err => {
    if (err) throw err;
    res.send('Success');
    console.log('Saved File')
    });

 }

  });
});
