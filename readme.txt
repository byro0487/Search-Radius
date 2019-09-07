Code Documentation:

"BeatApplication" provides three functionalities
1.Add a property
2.Retrieve a property based on its id.
3.Search for properties based on the specific search criteria.

TechStack:
1.JAVA
2.SPRINGBOOT
3.COUCHBASE(DataBase)

Different Components:
1.PropertySearchController
2.PropertyService
3.PropertyRepository
4.RequirementRepositoryService

PropertySearchController-This is the input gateway for all the requests.
PropertyService-The call form controller is delegated to this service, where all the required validations and manipulations are done.
PropertyRepository-Used to store or retrieve the property data.
RequirementRepositoryService-Used to store or retrieve the requirement data.

There are two kinds of resources defined 
1.Property
2.Requirement

Note:
We need the Requirement resource because we are also storing the search request when the search service is being used.
Each method inside the code is well commented to know further details. 

Note:(Future)
Further scope, we can integrate our application with search engine in order to improve the searching.
Example: Apache lucene is integrated with this application fora test example. 
