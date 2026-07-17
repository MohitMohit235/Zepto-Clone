# Zepto Clone

## Overview

This project was developed during my first internship in Mobile Application Development at Elivence Skills. It is built using Kotlin and Android Jetpack while following the MVVM architecture and modern Android development practices.


## Screenshots

![Application Screenshot](screenshots/screenshort.png) 

## Features

- Kotlin
- Android Jetpack
- MVVM Architecture
- ViewModel
- Navigation Component
- Room Database
- Retrofit
- Coroutines
- Material Design 3

## Tech Stack

The project is developed using Kotlin as the programming language and Jetpack Compose for building the user interface. It follows Clean Architecture combined with the MVVM design pattern to maintain a scalable and maintainable codebase. Dependency Injection is implemented using Hilt, while Firebase Authentication, Firestore, and Firebase Storage handle backend services. Navigation Compose manages screen navigation, Coil is used for image loading, and Kotlin Coroutines with StateFlow provide asynchronous programming and reactive state management.

## Architecture

This project follows **Clean Architecture** combined with the **MVVM (Model–View–ViewModel)** design pattern to ensure a scalable, maintainable, and testable codebase.

```text
                Presentation Layer
        (Compose UI, Screens, ViewModels)
                       │
                       ▼
                 Domain Layer
      (Use Cases, Models, Repository Interfaces)
                       │
                       ▼
                  Data Layer
   (Repository Implementation, Firebase, Local Data)
```

By separating responsibilities across these layers, the project achieves better code organization, improved maintainability, easier testing, and long-term scalability while adhering to modern Android development best practices.

## Project Structure

```text
app
│
├── data
│   ├── local
│   ├── remote
│   ├── model
│   ├── repository
│   └── mapper
│
├── domain
│   ├── model
│   ├── repository
│   └── usecase
│
├── presentation
│   ├── components
│   ├── navigation
│   ├── screens
│   └── viewmodel
│
├── di
│
└── ui
```

## Getting Started

Clone the repository, open it in Android Studio, sync the Gradle files, configure Firebase if required, and run the application on an emulator or physical Android device.

```bash
git clone https://github.com/MohitMohit235
```

## Future Improvements

Future enhancements include online payment integration, real-time order tracking, push notifications, address management, coupon support, order history, dark mode, enhanced animations, and additional performance optimizations.

## Disclaimer

This project is developed solely for educational and learning purposes. It is not affiliated with, sponsored by, or endorsed by Zepto. All trademarks, logos, and brand names belong to their respective owners.

## License

This project is licensed under the MIT License.
