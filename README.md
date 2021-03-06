# iKotlin

iKotlin is a simple Kotlin language learning app. ( But it's written in Java :D )

## Description

This repo contains clean, well-commented code for many Android utilities. You can fork or clone this repo to easily learn/implement similar or the same following :

* ### User registration with firebase + Facebook and Linkedin APIs
    - Firebase user authentication.
    - User registration to MySQL database using a restful API and Volley library.
    - Social Login (Facebook and Linkedin APIs) and managing retreived data on app.
<p align="center">
 <img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/userRegistration1.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/userRegistration2.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
 <img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/userregistration3.png"/>
</p>

* ### Managing fragments and working with listviews, recyclerviews and custom adapters
  - Working with multiple fragments in one Activity / <strong>managing the fragment backstack</strong>.
  - Handling activites / fragments lifecycles (given that the app is based on fragments, and, performs much network calls).*
  - Working with SwipeRefreshLayouts, custom list adapters, handling data in lists, ect...
<p align="center">
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/listViewsFragmentsAdapters1.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/listViewsFragmentsAdapters2.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/listViewsFragmentsAdapters3.png"/>
</p>

* ### Performing network calls using Volley HTTP library
   - I [built my own backend services using php symfony for this app](https://github.com/AmalH/restful-api-with-symfony). So this repo contains a well-commented section on <strong> using Volley HTTP library to consume a restful api</strong>.
<p align="center">
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/restapisNetwokcalls1.png"/>&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/restapisNetwokcalls2.png"/>&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/restapisNetwokcalls3.png"/>
</p>

* ### Various ui components / libraries usage 
   - I used and built a number of cool ui components in this project:
   Expandit: [AmalH/expandit](https://github.com/AmalH/expandit) / Paralloid: [AmalH/Paralloid](https://github.com/AmalH/Paralloid) /   Calligraphy: [chrisjenx/Calligraphy](https://github.com/InflationX/Calligraphy) / EditTag: [qiugang/EditTag](https://github.com/qiugang/EditTag) / more..
<p align="center">
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/ui1.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/ui2.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/ui3.png"/>
</p>

* ### What about a Kotlin compiler ?
  - Back to the network calls, if you need to compile Kotlin code on your app, this repo will help you ! It is as simple as performing a POST call on kotlinlang.org's services as shown in [CompetitionServices.java](https://github.com/AmalH/Kotlin-Learning/blob/master/app/src/main/java/amalhichri/androidprojects/com/kotlinlearning/services/CompetitionsServices.java)'s compileCode() .
<p align="center">
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/kotlinlangServer1.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/kotlinlangServer2.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/kotlinlangServer3.png"/>
</p>

* ### More cool ui components / libraries used 
    - Using webviews to load html/css/js content from in-app assets.
    - Implementing vertical TabLayouts, custom progress bars and more.
<p align="center">
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/ui4.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/ui8.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/AmalH/Kotlin-Learning/master/screenshots/ui7.png"/>
</p>
