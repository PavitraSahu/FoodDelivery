Pavitra Sahu.

* To run the project, just unzip the file and open it in android studio and click on run icon.
* It may require some necessary dependencies or sdk version to be downloaded for the project to run. So accordingly please update/install it.

1) Approach : I saw the whole page is a scrollable view with different types of views in it. 
So I decided to implement the same using recyclerview with different view types in it.

2) Architecture used was MVI & MVVM. 
MVI: I used to reduce the task on view model. In this, view just throws its intent or action to the view model & viewmodel in turns performs some specific tasks based on this actions.

I have also defined a view state class to track the different states of the task.

This states are observed by view and further process is done based on which state the task has reached.

3) In the project, folder structure is defined based on the different modules. Also I tried to create less dependencies between different components like the View, ViewModel, Model etc.

4) Object Oriented programming is achieved in this. I used sealed classes to restrict the class hierarchy while building the models for the api response & also while building the recyclerview with different view types.

5) I tried to make the code generic by designing the ui based on the api response that I received. For example, I read the priority of the restaurant Collections & displayed one of the list above the other based on their priority received.

6) I have used most of the modern code practices like ViewBinding, LiveData, Coroutines, MVVM, MVI, etc.