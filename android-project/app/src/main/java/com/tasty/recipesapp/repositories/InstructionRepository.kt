package com.tasty.recipesapp.repositories

import android.content.Context
import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.tasty.recipesapp.api.dto.InstructionDTO
import com.tasty.recipesapp.models.InstructionModel
import org.json.JSONObject
import java.io.IOException

class InstructionRepository : IInstructionRepository {
    override fun getInstructionById(id: Int): InstructionModel {
        return InstructionDTO(1, 1, "Instruction 1").toModel()
    }

    override fun InstructionDTO.toModel(): InstructionModel {
        return InstructionModel(1, "Instruction 1")
    }

    override fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
        return this.map { it.toModel() }
    }

    fun getAll(context: Context): List<InstructionModel> {
        return readAll(context).toModelList()
    }

    fun readAll(context: Context): List<InstructionDTO> {
        val gson = Gson()
        var instructionList = listOf<InstructionDTO>()
        val assetManager = context.assets
        try {
            val inputStream = assetManager.open("instructions.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)
            val jsonObject = JSONObject(jsonString)
            val instructionsArray = jsonObject.getJSONArray("instructions")
            val type = object : TypeToken<List<InstructionDTO>>() {}.type
//if it is simple
//val instructionList =
            //gson.fromJson<List<InstructionDTO>>(jsonString, type)
// if with label
            instructionList = gson.fromJson(instructionsArray.toString(), type)
            Log.i("GSON", instructionList.toString())
//instructions.value = instructionList
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return instructionList
    }


}