package edu.mobileprogrammingclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import edu.mobileprogrammingclasses.data.Cat
import edu.mobileprogrammingclasses.data.DomesticCat
import edu.mobileprogrammingclasses.data.GetTodosUsecase
import edu.mobileprogrammingclasses.databinding.FragmentSecondBinding
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment() {

  private lateinit var binding: FragmentSecondBinding

  @Inject
  lateinit var lion: Cat

  @Inject
  @PlainCat
  lateinit var someCat: DomesticCat

  @Inject
  @PlainCat
  lateinit var mrFluff: DomesticCat

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    this.binding = FragmentSecondBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.helloWorldText.text = "${someCat.doSound()} and ${mrFluff.doSound()} and ${lion.doSound()}"
  }

}
