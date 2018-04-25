Grocery Scraper Test
--------------------

Requirements:
Java 1.8
Maven (wrapper provided)

Instructions
------------

Build
./mvnw package

Run
cd target
java -jar groceryscaper-1.0.0.jar https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html


Improvements
------------
- Look to make scalable breaking out into workers etc
- Better error handling
- Command line --help option