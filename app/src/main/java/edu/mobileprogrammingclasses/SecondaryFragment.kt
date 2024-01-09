package edu.mobileprogrammingclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import edu.mobileprogrammingclasses.databinding.FragmentSecondaryBinding
import edu.mobileprogrammingclasses.domain.todo.GetTodosListUsecase
import javax.inject.Inject

@AndroidEntryPoint
class SecondaryFragment : Fragment() {

  private lateinit var binding: FragmentSecondaryBinding

  @Inject
  lateinit var todosListUsecase: GetTodosListUsecase

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentSecondaryBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.secondText.text = navArgs<SecondaryFragmentArgs>().value.myArgument
  }
}