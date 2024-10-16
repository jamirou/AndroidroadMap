package com.example.middlexmlhoroscopo.domain.usecase

import com.example.middlexmlhoroscopo.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)


}