Gatling JSON Generator
===========================


Update (9th July 2021) - I have recently created a better approach using Java projects, you
can find and read about this here:
https://bestofthetest.blogspot.com/2021/07/gatling-and-test-data-generator-pattern.html?m=1
https://github.com/matthewbretten/gatling-example-datamodel-pattern

This suite is an example to dynamically generate large amounts of JSON documents and still
utilising Gatling's scenario features to control different volumes of certain data.

Prerequisites
-------------

* Maven
* Scala 2.12

Running simulations
---------------
Either run by using
```bash
mvn gatling:test
```
Or specify a test (if there are multiple) by using
```bash
mvn gatling:test -Dgatling.simulationClass=TestSimulation
```

Features
----------------
* Dynamic JSON document generation from Scala objects and classes
* Generating complex JSON with nested objects, lists and relational data (e.g. a total based on
nested values from a list)
* Generating random date times
* Generating random ISO country codes
* Loading random values from a file
* Picking a random number between two values (this is default functionality in Scala 
2.13 but Gatling currently only supports 2.12 so had to back port this)

Behaviour
---------------
When this code is run, it will attempt to perform POST HTTP requests to http://localhost:5000 (as I was running a local Python Flask application to test receiving the requests). 
As part of the POST request, it will include the generated JSON as part of the request body. 

Sample data
---------------
This code will generate JSON data that looks like this as part of each request:
```json
{
  "customer" : {
    "name" : "FkdUbOnVJLslId6RhojEaZPtDbuUTi",
    "age" : 43,
    "countryCode" : "ZM"
  },
  "totalPrice" : 219,
  "items" : [
    {
      "basketItemId" : 1,
      "description" : "Table",
      "price" : 79
    },
    {
      "basketItemId" : 2,
      "description" : "Chair",
      "price" : 99
    },
    {
      "basketItemId" : 3,
      "description" : "Knitting needles",
      "price" : 41
    }
  ],
  "dateCreated" : "2019-12-04 21:05:45"
}
```
