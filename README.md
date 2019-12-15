Gatling JSON Generator
===========================

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

Sample data
---------------
It will generate data that looks like this:
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