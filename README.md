# NoteApp

This is a Notes Android app that allows users to create, read, update, and delete notes. The app is built using Clean Architecture with MVVM design pattern for architecture and the UI is implemented using Jetpack Compose.

Features:

Create new notes

Read existing notes

Update existing notes

Delete existing notes

Sort notes based on color, date, or title

Getting Started:

Clone the repository:
git clone https://github.com/Passant-Hatem/notes-app.git
```
Open the project in Android Studio.
Build and run the app on your device or emulator.
Dependencies:

Room for local data storage
LiveData for observing data changes
ViewModel for data management
RxJava for reactive programming
Dagger Hilt for dependency injection
Jetpack Compose for UI implementation
Architecture:

The app follows Clean Architecture with MVVM design pattern, which separates the app into layers with clear responsibilities:

Presentation Layer - handles user interface and user interactions using the MVVM design pattern and Jetpack Compose.
Domain Layer - contains business logic and use cases.
Data Layer - handles data access and storage using Room.
Contributing:

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

License:

MIT
