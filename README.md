# PageCounter App with Android-Clean-Architecture

Simple Page Counting App with clean architecture.

## Clean Architecture

- domain
- data
- presentation
- app

this sample app is using 4 modules.

# Demo

![pagecounter_demo](https://user-images.githubusercontent.com/25246960/151825575-9ac5a20f-738f-492a-bd75-b020a074981e.gif)

### Flow

app -> presentation -> activity -> viewModel -> useCase -> repository -> network request
network response -> repository -> useCase -> viewModel -> liveData -> activity -> compose

## Used Set
- Kotlin
- Jetpack Compose
- Hilt
- Retrofit
- Moshi
- Coroutine
- Material Theme


## Thanks to
this project is using free api counter [https://countapi.xyz/][1].
special thanks to https://countapi.xyz/ author, @mlomb.

[1]: https://countapi.xyz/
