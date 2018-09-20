var map;

var data, json;
var features;

function getJSON() {

    //AJAX to our API

    var xhttp = new XMLHttpRequest(),
        method = "GET",
        url = "http://localhost:8080/weatherapi";

    xhttp.open(method, url, true);

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState === 4) {

            if(xhttp.status === 200) {
                data = xhttp.responseText;
                json = JSON.parse(data);

                getToday();
                initMap();
            }

            if(xhttp.status === 404) {
                console.log("Failed to retrieve data from API");
            }
        }
    };

    xhttp.send();
}

// Kall på denne for å vise kart for neste dag

function showTomorrow() {
    getTomorrow();
    initMap();
}

function initMap() {


    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 5,
        center: new google.maps.LatLng(63.43, 10.39),
        mapTypeId: 'roadmap'
    });

    var icons = {
        Sun: {
            icon: 'images/sunny.png'
        },
        DrizzleSun: {
            icon: 'images/cloud.png'
        },
        Cloud: {
            icon: 'images/cloud.png'
        },
        PartlyCloud: {
            icon: 'images/clouds.png'
        },
        LightCloud: {
            icon: 'images/clouds.png'
        },
        LightRain: {
            icon: 'images/rain.png'
        },
        Rain: {
            icon: 'images/rain.png'
        },
        Drizzle: {
            icon: 'images/storm.png'
        }
    };



    // Create markers.
    features.forEach(function(feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: icons[feature.type].icon,
            map: map
        });
    });
}

function getToday() {
    features = [
        {
            position: new google.maps.LatLng(59.91, 10.61), //Oslo
            type: json['cities'][0]['today']
        }, {
            position: new google.maps.LatLng(60.39, 5.32), //Bergen
            type: json['cities'][1]['today']
        }, {
            position: new google.maps.LatLng(63.43, 10.39), //Trondheim
            type: json['cities'][2]['today']
        }, {
            position: new google.maps.LatLng(58.97, 5.73), //Stavanger
            type: json['cities'][3]['today']
        }, {
            position: new google.maps.LatLng(58.15, 8.01), //Kristiansand
            type: json['cities'][4]['today']
        }, {
            position: new google.maps.LatLng(69.64, 18.95), //Tromsø
            type: json['cities'][5]['today']
        }
    ];
}

function getTomorrow() {
    features = [
        {
            position: new google.maps.LatLng(59.91, 10.61), //Oslo
            type: json['cities'][0]['tomorrow']
        }, {
            position: new google.maps.LatLng(60.39, 5.32), //Bergen
            type: json['cities'][1]['tomorrow']
        }, {
            position: new google.maps.LatLng(63.43, 10.39), //Trondheim
            type: json['cities'][2]['tomorrow']
        }, {
            position: new google.maps.LatLng(58.97, 5.73), //Stavanger
            type: json['cities'][3]['tomorrow']
        }, {
            position: new google.maps.LatLng(58.15, 8.01), //Kristiansand
            type: json['cities'][4]['tomorrow']
        }, {
            position: new google.maps.LatLng(60.64, -2.4), //Tromsø
            type: json['cities'][5]['tomorrow']
        }
    ];
}
