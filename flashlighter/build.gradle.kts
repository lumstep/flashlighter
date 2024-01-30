import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.lumstep.flashlighter"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

publishing {
    publications {
        // Creates a Maven publication called "release".
        register<MavenPublication>("gpr") {
            // You can then customize attributes of the publication as shown below.
            groupId = "com.lumstep"
            artifactId = "flashlighter"
            version = "1.0.0"
            artifact("${layout.projectDirectory}/build/outputs/aar/flashlighter-release.aar")
        }
    }

    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/lumstep/flashlighter")
            credentials {
                username =
                    gradleLocalProperties(rootDir).getProperty("GitHubPackagesUsername").toString()
                password =
                    gradleLocalProperties(rootDir).getProperty("GitHubPackagesPassword").toString()
            }
        }
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.01.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.foundation:foundation")
}
