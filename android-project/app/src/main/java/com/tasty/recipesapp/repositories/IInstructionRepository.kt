package com.tasty.recipesapp.repositories

import com.tasty.recipesapp.api.dto.InstructionDTO
import com.tasty.recipesapp.models.InstructionModel

interface IInstructionRepository {
    fun getInstructionById(id: Int): InstructionModel
    fun InstructionDTO.toModel(): InstructionModel
    fun List<InstructionDTO>.toModelList(): List<InstructionModel>
}