package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.data.source.remote.RickAndMortyApi
import com.example.rickandmorty.data.source.remote.dto.toListCharacters
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(

    private val api: RickAndMortyApi
): CharacterRepository{
    override fun getCharacters(page: Int): Flow<Result<List<Character>>> = flow{
        emit(Result.Loading())

        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException){
            emit(Result.Error(
                message = "Oops, algo sucedió",
                data = null
            ))
        } catch (e: IOException){
            emit(Result.Error(
                message = "No se encuentra el servidor, verifica tu conexión a internet",
                data = null
            ))
        }
    }

    override suspend fun getChacater(id: Int): Result<Character> {
        TODO("Not yet implemented")
    }
}