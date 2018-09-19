Foreløpig'ish oppsett;

DisplayMap.java - Javafilen som hoster html-kode, viser maps ++. Kaller på og henter inn info fra SetIcons.java og displayer sol/regn osv ut i fra denne. Vi finner logikk som setter riktig filsti til riktig icon pr sted.

SetIcons.java - Kjører get-kall til vær-databasen. Henter ut info, parser JSON eller whatever, og avgjør værikonet til stedene vi skal ha med.
