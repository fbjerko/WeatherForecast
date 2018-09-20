var map;
var data;

function getJSON() {

    var xhttp = new XMLHttpRequest(),
        method = "GET",
        url = "http://localhost:8080/weatherapi";

    xhttp.open(method, url, true);

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState === 4) {

            if(xhttp.status === 200) {
                data = xhttp.responseText;
                console.log(xhttp.responseText)
            }

            if(xhttp.status === 404) {
                console.log("fail");
            }
        }
    };

    xhttp.send();
}

function initMap() {

    getJSON();

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 6,
        center: new google.maps.LatLng(59.91, 10.61),
        mapTypeId: 'roadmap'
    });

    var icons = {
        Sun: {
            icon: 'images/sunny.png'
        },
        Cloud: {
            icon: 'images/cloud.png'
        },
        PartlyCloud: {
            icon: 'images/clouds.png'
        },
        LightRain: {
            icon: 'images/rain.png'
        },
        Rain: {
            icon: 'images/storm.png'
        },
        scott: {
            icon: 'images/scott.jpg'
        }
    };

    var features = [
        {
            position: new google.maps.LatLng(59.91, 10.61), //Oslo
            type: data.
        }, {
            position: new google.maps.LatLng(60.39, 5.32), //Bergen
            type: 'sun'
        }, {
            position: new google.maps.LatLng(63.43, 10.39), //Trondheim
            type: 'cloud'
        }, {
            position: new google.maps.LatLng(58.97, 5.73), //Stavanger
            type: 'rain'
        }, {
            position: new google.maps.LatLng(58.15, 8.01), //Kristiansand
            type: 'storm'
        }, {
            position: new google.maps.LatLng(60.64, -2.4), //Tromsø
            type: 'scott'
        }, {
            position: new google.maps.LatLng(35, 37.5), //Tromsø
            type: 'scott'
        }
    ];



    // Create markers.
    features.forEach(function(feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: icons[feature.type].icon,
            map: map
        });
    });
}
