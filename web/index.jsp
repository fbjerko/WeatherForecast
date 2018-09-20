<%--
  Created by IntelliJ IDEA.
  User: noroff-experis-7
  Date: 18.09.18
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <style>


    /* Always set the map height explicitly to define the size of the div
     * element that contains the map. */
    #map {
      height: 100%;
    }

    /* Optional: Makes the sample page fill the window. */
    html, body {
      height: 100%;
      margin: 0;
      padding: 0;
    }
  </style>

</head>
<body bgcolor="LightBlue">

<div align="center">
  <h2 id="message">Describe the weather in: </h2>
  <button onclick="getSpecific(0)">Oslo</button>
  <button onclick="getSpecific(1)">Bergen</button>
  <button onclick="getSpecific(2)">Trondheim</button>
  <button onclick="getSpecific(3)">Stavanger</button>
  <button onclick="getSpecific(4)">Kristiansand</button>
  <button onclick="getSpecific(5)">Tromsø</button>
</div>
<br>
<div align="center">
  <button onclick="showToday()">Weather today</button>
  <button onclick="showTomorrow()">Weather next day</button>
</div>
<div id="map"></div>

<script src="scripts/map.js"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8KFuvfGGARrSNVZVsnsePgUws7jnzBK4&q&callback=getJSON">
</script>



</body>
</html>
--%>