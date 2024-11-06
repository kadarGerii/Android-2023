package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R
import com.tasty.recipesapp.api.dto.RecipeDTO
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repositories.RecipeRepository
import com.tasty.recipesapp.viewmodel.RecipeListViewModel
import com.tasty.recipesapp.viewmodel.RecipeListViewModelFactory

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private val recipesArray = mutableListOf<RecipeDTO>()

    private val recipeListViewModel: RecipeListViewModel by viewModels {
        RecipeListViewModelFactory(requireContext(), RecipeRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the LiveData and update the recipesArray when data is received
        recipeListViewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            if (recipes != null) {
                recipesArray.clear()
                recipesArray.addAll(recipes)
                Log.i("RecipesFragment", "Recipes loaded: $recipes")
            } else {
                Log.i("RecipesFragment", "No recipes available")
            }
        }

        // Load data on button click
        binding.loadButton.setOnClickListener {
            recipeListViewModel.fetchData()
            binding.toastMessage.text = "Recipes loaded"
        }

        // Navigate to a random recipe's detail view on button click
        binding.getRandomButton.setOnClickListener {
            if (recipesArray.isNotEmpty()) {
                val randomRecipe = recipesArray.random()
                Log.i("RecipesButton", "Navigating to RecipeDetailFragment with: $randomRecipe")
                val bundle = Bundle().apply {
                    putSerializable("recipe", randomRecipe)
                }
                findNavController().navigate(
                    R.id.action_recipesFragment_to_recipeDetailFragment,
                    bundle
                )
            } else {
                Log.i("RecipesFragment", "No recipes loaded")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
