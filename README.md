# Zepto Clone

A modern Android grocery delivery application inspired by Zepto, built using Jetpack Compose with Clean Architecture and MVVM. This project showcases modern Android development practices, scalable architecture, and a smooth user experience using the latest Android development tools and libraries.

## Overview

This project is developed to explore modern Android development using Jetpack Compose. It demonstrates best practices such as Clean Architecture, MVVM, Dependency Injection with Hilt, Firebase integration, and reactive UI development. The application recreates the core shopping experience of a grocery delivery platform, including product browsing, authentication, cart management, wishlist, and profile management.

## Features

The application provides secure user authentication, product browsing, category-based shopping, product search, detailed product pages, shopping cart management, wishlist functionality, user profile management, location support, responsive layouts, smooth navigation, Material Design 3 components, and modern animations built entirely with Jetpack Compose.

## Tech Stack

The project is developed using Kotlin as the programming language and Jetpack Compose for building the user interface. It follows Clean Architecture combined with the MVVM design pattern to maintain a scalable and maintainable codebase. Dependency Injection is implemented using Hilt, while Firebase Authentication, Firestore, and Firebase Storage handle backend services. Navigation Compose manages screen navigation, Coil is used for image loading, and Kotlin Coroutines with StateFlow provide asynchronous programming and reactive state management.

## Architecture

This project follows **Clean Architecture** combined with the **MVVM (Model–View–ViewModel)** design pattern to ensure a scalable, maintainable, and testable codebase. The application is divided into three independent layers: **Presentation**, **Domain**, and **Data**, where each layer has a specific responsibility and communicates through well-defined interfaces.

The **Presentation** layer is responsible for rendering the user interface using Jetpack Compose and managing UI state through ViewModels. The **Domain** layer contains the application's core business logic, use cases, and repository contracts, ensuring that business rules remain independent of frameworks and external dependencies. The **Data** layer manages all data-related operations, including Firebase services, local data sources, and repository implementations.

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
git clone https://github.com/your-username/Zepto-Clone.git
```

## Screenshots

Application screenshots will be added after the development is completed.

## Future Improvements

Future enhancements include online payment integration, real-time order tracking, push notifications, address management, coupon support, order history, dark mode, enhanced animations, and additional performance optimizations.

## Disclaimer

This project is developed solely for educational and learning purposes. It is not affiliated with, sponsored by, or endorsed by Zepto. All trademarks, logos, and brand names belong to their respective owners.

## License

This project is licensed under the MIT License.
