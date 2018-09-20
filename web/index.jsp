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
        height: 70%;
        margin: 0;
        padding: 0;
      }
    </style>
    <script>


      var testJSON = {
          "location":"Oslo",
          "weather":"Sun"
      }

      function getWeather(){
          var mylist = document.getElementById("myList");
          document.getElementById("location").value=testJSON.location;
          document.getElementById("weather").value=testJSON.weather;
      }
    </script>


  </head>
  <body>
  <div id="map"></div>

  <script src="/scripts/map.js"></script>
  <script async defer
          src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8KFuvfGGARrSNVZVsnsePgUws7jnzBK4&q&callback=initMap">
  </script>
  <form>
    Select location
    <select id = "myList" onchange="getWeather()">
      <option>Oslo</option>
      <option>Bergen</option>
      <option>Trondheim</option>
      <option>Stavanger</option>
      <option>Kristiansand</option>
      <option>Tromsø</option>
    </select>
  </form>
  <p>The weather in <input type = "text" id="location" size="20"> is <input type="text" id="weather" size = "20"></p>


  </body>
</html>


<%--
 <iframe width= "1000" height="1000" align="center" frameborder="0" style="border:0"
            src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA8KFuvfGGARrSNVZVsnsePgUws7jnzBK4&q=Norway"
            allowfullscreen></iframe>

--%>