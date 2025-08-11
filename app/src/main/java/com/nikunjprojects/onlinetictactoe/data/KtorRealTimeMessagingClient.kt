package com.nikunjprojects.onlinetictactoe.data

import com.nikunjprojects.model.GameState
import com.nikunjprojects.model.MakeTurn
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.flow.*
import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KtorRealTimeMessagingClient(
    private val client: HttpClient
): RealTimeMessagingClient {

    private var session: WebSocketSession? = null

    override fun getGameStateStream(): Flow<GameState> {
        return flow {
            session = client.webSocketSession {
                url("ws://191.96.53.243/play")
            }
            val gameStates = session!!
                .incoming
                .consumeAsFlow()
                .filterIsInstance<Frame.Text>()
                .mapNotNull { Json.decodeFromString<GameState>(it.readText()) }

            emitAll(gameStates)
        }
    }

    override suspend fun sendAction(action: MakeTurn) {
        session?.outgoing?.send(
            Frame.Text("make_turn#${Json.encodeToString(action)}")
        )
    }

    override suspend fun close() {
        session?.close()
        session = null
    }

}