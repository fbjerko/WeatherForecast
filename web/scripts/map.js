var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 5,
        center: new google.maps.LatLng(59.91, 10.61),
        mapTypeId: 'roadmap'
    });



    var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
    var icons = {
        sun: {
            icon: '/images/sun.png'
        },
        cloud: {
            icon: '/images/cloud.png'
        },
        partcloud: {
            icon: '/images/clouds.png'
        },
        rain: {
            icon: '/images/liquid.png'
        },
        storm: {
            icon: '/images/storm.png'
        },
        scott: {
            icon: '/images/scott.jpg'
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
            type: 'clouds'
        }, {
            position: new google.maps.LatLng(58.97, 5.73), //Stavanger
            type: 'liquid'
        }, {
            position: new google.maps.LatLng(58.15, 8.01), //Kristiansand
            type: 'storm'
        }, {
            position: new google.maps.LatLng(69.64, 18.95), //Tromsø
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
