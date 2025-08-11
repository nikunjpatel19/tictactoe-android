package com.nikunjprojects.onlinetictactoe.data

import com.nikunjprojects.model.GameState
import com.nikunjprojects.model.MakeTurn
import kotlinx.coroutines.flow.Flow

interface RealTimeMessagingClient {
    fun getGameStateStream(): Flow<GameState>
    suspend fun sendAction(action: MakeTurn)
    suspend fun close()
}