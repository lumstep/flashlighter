pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://lumstep: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@maven.pkg.github.com/lumstep/flashlighter") }
    }
}

rootProject.name = "FlashLighter"
include(":app")
include(":flashlighter")
