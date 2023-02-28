package com.example.rickandmorty.domain.repositories


import com.example.rickandmorty.data.Result
import com.example.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {


    fun getCharacters(page: Int): Flow<Result<List<Character>>>

    suspend fun getChacater(id: Int): Result<Character>

}