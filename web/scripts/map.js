var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 6,
        center: new google.maps.LatLng(59.91, 10.61),
        mapTypeId: 'roadmap'
    });

    var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
    var icons = {
        sun: {
            icon: 'images/sunny.png'
        },
        cloud: {
            icon: 'images/cloud.png'
        },
        partcloud: {
            icon: 'images/clouds.png'
        },
        rain: {
            icon: 'images/rain.png'
        },
        storm: {
            icon: 'images/storm.png'
        },
        scott: {
            icon: 'images/scott.jpg'
        }
    };

    var features = [
        {
            position: new google.maps.LatLng(59.91, 10.61), //Oslo
            type: 'sun'
        }, {
            position: new google.maps.LatLng(60.39, 5.32), //Bergen
            type: 'sun'
        }, {
            position: new google.maps.LatLng(63.43, 10.39), //Trondheim
            type: 'cloud'
        }, {
            position: new google.maps.LatLng(58.97, 5.73), //Stavanger
            type: getType();
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

    function getType() {

        return 'sun';

    }

    // Create markers.
    features.forEach(function(feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: icons[feature.type].icon,
            map: map
        });
    });
}
