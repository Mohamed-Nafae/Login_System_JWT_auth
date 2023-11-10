# Android Login System with JWT Authentication

**Author:** Benmeddour Mohamed Nafae

## Overview

This Android app is a simple Login System with JSON Web Token (JWT) authentication. It follows the principles of Clean Architecture and utilizes Retrofit for network requests and Dependency Injection for better code organization.

## Features

- **User Authentication:** Users can log in securely using their credentials.
- **JWT Integration:** Authenticated users receive a JWT token for subsequent API requests.
- **Clean Architecture:** Codebase organized into layers (presentation, domain, data) for maintainability.
- **Retrofit:** Network requests handled with Retrofit for simplicity.
- **Dependency Injection:** Dagger Hilt is used for dependency injection.

## Technologies Used

- **Kotlin:** Programming language for Android development.
- **Retrofit:** HTTP client for Android to handle API requests.
- **Dagger Hilt:** Dependency injection library for Android.
- **Clean Architecture:** Separation of concerns for better maintainability.
- **MVVM (Model-View-ViewModel):** Architecture pattern for the user interface.

## Installation

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or a physical Android device.

## Usage

1. Launch the app on your Android device.
2. Navigate to the Login screen.
3. Enter your username and password.
4. Tap the "Login" button to authenticate.
5. Authenticated users will receive a JWT token.
6. Use the token for subsequent API requests.

## Project Structure

- `app/src/main/java/com/plcoding/jwtauthktorandroid`: Main package for the Android app.
  - `auth/`: Data layer containing repositories and data sources.
  - `ui/`: Presentation layer with view models and UI components.
  - `di/`: Dependency Injection modules using Dagger Hilt.

## Dependencies

- Retrofit: `implementation 'com.squareup.retrofit2:retrofit:2.x.x'`
- Hilt: `implementation 'com.google.dagger:hilt-android:2.x.x'`

Make sure to replace the version numbers with the latest versions available.

