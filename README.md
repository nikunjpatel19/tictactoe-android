# Online TicTacToe

Real-time multiplayer Tic-Tac-Toe for Android built with Jetpack Compose and WebSocket networking.

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue) ![Compose](https://img.shields.io/badge/Jetpack%20Compose-Yes-brightgreen) ![Min SDK](https://img.shields.io/badge/Min%20SDK-24-informational) ![Target SDK](https://img.shields.io/badge/Target%20SDK-34-informational)

## 30-Second Snapshot
- Real-time turn-based game over WebSockets; no polling.
- MVVM architecture with deterministic state via Kotlin Flows.
- Dependency Injection through Hilt for clean separation of concerns.
- Jetpack Compose UI drawing the board and handling gestures.
- Built-in connection retry and loading states for resilience.
- Unit & instrumentation test scaffolding with JUnit and Espresso.

## Demo
```
TODO: Add demo GIF (docs/demo.gif) and 2–4 screenshots (docs/screen_*.png)
```

## Features
- [x] Real-time multiplayer over WebSockets.
- [x] Jetpack Compose UI with gesture detection.
- [x] MVVM with unidirectional state flow.
- [x] Dependency Injection with Hilt.
- [x] Error handling for connection failures.
- [x] Kotlinx Serialization for compact protocol.
- [x] Proguard config prepared for release builds.
- [ ] TODO: Add unit/UI test coverage.

## Architecture
The app follows a simple MVVM pattern:

```
UI (Compose) → ViewModel → RealTimeMessagingClient → WebSocket Server
```

- **ViewModel** collects a stream of `GameState` updates and exposes UI state via `StateFlow`.
- **RealTimeMessagingClient** encapsulates WebSocket traffic using Ktor.
- Coroutines ensure off-main-thread networking while keeping UI responsive.
- Explicit state management avoids mutable UI side effects.

## Tech Stack
| Category | Library/Tool | Notes |
|---|---|---|
| Language | Kotlin | Coroutines & Flow |
| UI | Jetpack Compose | Material 3 components |
| Networking | Ktor WebSockets | Real-time game state sync |
| Serialization | Kotlinx Serialization | JSON payloads |
| DI | Hilt | Injects networking and ViewModel deps |
| Async | Kotlin Coroutines | Structured concurrency |
| Build | Gradle (KTS) | Version catalogs |
| Testing | JUnit, Espresso | Starter tests |

## Setup & Run (Quickstart)
1. **Requirements**
   - Android Studio Hedgehog or newer
   - Android SDK 34 and JDK 17+
2. **Build & Run**
   ```bash
   ./gradlew assembleDebug
   ```
3. **Run Tests**
   ```bash
   ./gradlew test
   ```
   > Requires a local `ANDROID_HOME` or `local.properties` pointing to a valid SDK.
4. **Configure Server**
   - WebSocket endpoint is hardcoded in `KtorRealTimeMessagingClient`.
   - Update the IP if running your own server or using emulator loopback.
5. **Troubleshooting**
   - Ensure `usesCleartextTraffic=true` is acceptable for development; switch to HTTPS for production.
   - Delete `.gradle` cache if build gets stuck.

## Project Structure
```
app/
  src/main/java/com/nikunjprojects/onlinetictactoe/
    data/          # Ktor client & models
    di/            # Hilt modules
    presentation/  # ViewModel & Compose board
    ui/theme/      # Material theme setup
```

## Screenshots (Gallery)
```
TODO: Add screenshots (docs/screen_home.png, docs/screen_game.png)
```

## License
All rights reserved. TODO: Replace with MIT or Apache-2.0.
