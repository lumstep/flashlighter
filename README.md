# FlashLighter

[![License](https://img.shields.io/github/license/alialbaali/kamel)](http://www.apache.org/licenses/LICENSE-2.0)
[![Kotlin](https://img.shields.io/badge/kotlin-v1.9.22-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Compose-v1.6.0-blue)](https://github.com/JetBrains/compose-multiplatform)

Flashlighter is a library developed with [Compose]([https://github.com/JetBrains/compose-multiplatform](https://developer.android.com/jetpack/compose/why-adopt#powerful)). This repository introduces a unique flashlighter feature, allowing you to effortlessly control the visibility of your screen content.

## Table of contents

- [Demo](#demo)
- [Setup](#setup)
- [Usage](#usage)
- [Contributions](#contributions)
- [License](#license)

## Demo

You can hide the full screen under the flashligher

https://github.com/lumstep/flashlighter/assets/33528377/3da26433-9085-4cab-a07a-444509eb67c7

or just a part of screen

https://github.com/lumstep/flashlighter/assets/33528377/92d4c6c9-185c-4d66-9b9e-5dd7897eb048

shift the flashligher

https://github.com/lumstep/flashlighter/assets/33528377/bc261d71-5872-449b-8df7-635701c2bdaa

set any background for your flashligher

https://github.com/lumstep/flashlighter/assets/33528377/b7e99c0c-d300-4c1e-a9c8-170beb4b95c3

or set any color for background of flashligher

https://github.com/lumstep/flashlighter/assets/33528377/7db84374-8293-4be8-a789-3db2c135ac3d

## Setup

Flashlighter is published on Github Packages:

```kotlin
repositories {
    maven { url = uri("https://lumstep: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@maven.pkg.github.com/lumstep/flashlighter") }
    // ...
}
```

Add the dependency to the module build.gradle.kts:

```kotlin
dependencies {
   implementation("com.lumstep:flashlighter:1.0.0")
   // ...
}
```

## Usage

You can use ```FlashLighter``` composable, it can hide your content under the FlashLighter:

```kotlin
FlashLighter (radius = 200f) {
}
```

Your can specify flashlighter gradient background using: 
```kotlin
FlashLighter (
  // ...
  flashLighterBrush = { center: Offset, radius: Float ->
    Brush.radialGradient(
      0.0f to Color.Black.copy(alpha = 0.7f),
      1.0f to Color.White.copy(alpha = 1f),
      radius = radius,
      center = center,
    )
  }
) {
}
```

Your can specify screen background color using: 
```kotlin
FlashLighter (
  // ...
  backgroundBrush = SolidColor(Color.White)
) {
}
```

Your can apply offset for shifting the flashlight effect using: 
```kotlin
FlashLighter (
  // ...
  shiftOffset = Offset(-120f, -120f)
) {
}
```

## Contributions

Contributions are always welcome!. If you'd like to contribute, please feel free to create a PR or
open an issue.

## License

```
Copyright 2024 Stepan Prokopenko

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
