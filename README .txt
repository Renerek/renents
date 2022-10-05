This application uses Kotlin and MVVM

## Getting Started

Download the latest Android Studio.

The consumer applications are required to have the following sdk levels as minimum:

    minSdkVersion =  21
    compileSdkVersion = 33

## Tech Breakdown	

In the project we have 3 layers; Data, domain and the presentation layers

in the Data layer we have;
Local, where in we create our Room database and also handle the offline data ;
we also have the  remote. In the remote we have our Dto class which we use to pass our response and we also call the employee APi from here.
Finally in this layer we have the repository. We have the repositoryImplementation we handle all states and we access data from our Dao.

In the domain layer, we have the model and the repository which handle the business logic and act like a mediator between the data layer and the presentation layer

Finally we have the Presentation layer which houses our views.