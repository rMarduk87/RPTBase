# Adapt BaseJetComposeFragment to JetCompose Implementation

The goal is to refactor `BaseJetComposeFragment` to properly support Jetpack Compose. Currently, it is a copy of `BaseFragment` that uses `ViewBinding`. The project also lacks the necessary Compose dependencies and configuration.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/Riccardo.Pezzolati/RPTBase/gradle/libs.versions.toml)
- Add Compose BOM and core libraries (UI, Graphics, Tooling, Material3).
- Add Compose Activity and ViewModel integration libraries.

#### [MODIFY] [build.gradle](file:///C:/Users/Riccardo.Pezzolati/RPTBase/app/build.gradle)
- Enable `compose` in `buildFeatures`.
- Add `composeOptions` with the appropriate Kotlin compiler extension version.
- Add Compose dependencies using the BOM.

### Base Classes

#### [MODIFY] [BaseJetComposeFragment.kt](file:///C:/Users/Riccardo.Pezzolati/RPTBase/app/src/main/java/rpt/com/base/BaseJetComposeFragment.kt)
- Remove `ViewBinding` and `Inflate` references.
- Use `ComposeView` as the root view in `onCreateView`.
- Define an abstract `@Composable` function named `BaseJetCompose()` (to match the "JetCompose" naming convention) for subclasses to provide their UI.
- Maintain the `hideSystemBars` functionality.

## Verification Plan

### Automated Tests
- I will verify the build by running `./gradlew :app:assembleDebug` (if possible in this environment).
- I will check for syntax errors using `analyze_file`.

### Manual Verification
- The user can verify by creating a subclass of `BaseJetComposeFragment` and providing a Composable.
