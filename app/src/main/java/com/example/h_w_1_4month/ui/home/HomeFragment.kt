package com.example.h_w_1_4month.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.h_w_1_4month.R
import com.example.h_w_1_4month.databinding.FragmentHomeBinding
import com.example.h_w_1_4month.ui.home.adapter.TaskAdapter
import com.example.h_w_1_4month.ui.model.Task
import com.example.h_w_1_4month.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter= TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root ?: binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RV.adapter = adapter
        setFragmentResultListener(TaskFragment.TASK_REQUEST) { _, bundle ->
            val result = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
           adapter.addTask(result)
        }
        binding.add.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }
}