let currentQuote = "";
let currentFaction = "";
let currentId = "";
let switcher = 0;

function yodaTranslate(quote) {

    if (currentQuote != "") {
        var data = null;
        var xhr = new XMLHttpRequest();

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {
                var obj = JSON.parse(this.responseText);

                if (switcher == 1) {
                    var table = document.getElementById('table');
                    var rowCount = table.rows.length;
                    for (var i = 1; i < rowCount; i++) {
                        table.deleteRow(1);
                    }
                }
                var table = document.getElementById("table");
                var row = table.insertRow(1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                cell1.innerHTML = obj.contents.translated;
                cell2.innerHTML = currentId;
                cell3.innerHTML = currentFaction;
                cell4.innerHTML = "Yes";
            }
        });

        encodedText = encodeURIComponent(quote.trim());

        url = "https://yodish.p.rapidapi.com/yoda.json?text=" + encodedText;

        xhr.open("POST", url);
        xhr.setRequestHeader("x-rapidapi-host", "yodish.p.rapidapi.com");
        xhr.setRequestHeader("x-rapidapi-key", "a96619c959mshfe4c096f4ff40f6p134fb8jsnca4487ddae08");
        xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

        xhr.send(data);
    }

}

function displayQuote() {
    if (document.getElementById('radio1').checked) {
        let request = new XMLHttpRequest();
        request.open("GET", "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote", true);
        request.onload = function () {
            data = JSON.parse(this.response);
            currentQuote = data.starWarsQuote;

            currentId = data.id;
            currentFaction = data.faction;

            if (switcher == 1) {
                var table = document.getElementById('table');
                var rowCount = table.rows.length;
                for (var i = 1; i < rowCount; i++) {
                    table.deleteRow(1);
                }
            }

            var table = document.getElementById("table");
            var row = table.insertRow(1);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            cell1.innerHTML = currentQuote;
            cell2.innerHTML = data.id;
            cell3.innerHTML = data.faction;
            cell4.innerHTML = "No";
        }
        request.send();
    } else if (document.getElementById('radio2').checked) {
        let request = new XMLHttpRequest();
        request.open("GET", "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote", true);
        request.onload = function () {
            data = JSON.parse(this.response);
            currentId = data.id;
            currentFaction = data.faction;
            currentQuote = data.starWarsQuote;
            yodaTranslate(currentQuote);
        }
        request.send();
    }
}

function getQuote() {
    return currentQuote;
}

function resetQuote() {
    if (currentQuote != "") {
        if (switcher == 1) {
            var table = document.getElementById('table');
            var rowCount = table.rows.length;
            for (var i = 1; i < rowCount; i++) {
                table.deleteRow(1);
            }
        }
        var table = document.getElementById("table");
        var row = table.insertRow(1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        cell1.innerHTML = currentQuote;
        cell2.innerHTML = currentId;
        cell3.innerHTML = currentFaction;
        cell4.innerHTML = "No";
    }
}

function deleteRows() {
    console.log(switcher);
    if (switcher == 0) {
        switcher = 1;
    } else if (switcher == 1) {
        switcher = 0
    }
    console.log(switcher);
    var table = document.getElementById('table');
    var rowCount = table.rows.length;
    for (var i = 1; i < rowCount; i++) {
        table.deleteRow(1);
    }
}
