package com.example.inidividual11kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inidividual11kt.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), WordAdapter.SendWord {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val wordList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        val recyclerView = binding.recyclerView
        val adapter = WordAdapter(wordList, requireContext(), this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        binding.btnAddWord.setOnClickListener {
            val newWord = "New Word" // Cambia esto para permitir que el usuario ingrese una nueva palabra
            addNewWord(newWord)
            adapter.notifyDataSetChanged()  // Notificar al adaptador que se ha actualizado la lista
        }

        return binding.root
    }

    private fun addNewWord(word: String) {
        wordList.add(word)
    }

    override fun sendWord(word: String) {
        // Lógica para enviar la palabra seleccionada al segundo fragmento
        val bundle = Bundle()
        bundle.putString("word", word)
        // Navegar al segundo fragmento (asegúrate de tener el ID correcto)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
