package br.com.zup.simcitysaojoao.telaInicial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.SIMCITY_SAO_JOAD
import br.com.zup.simcitysaojoao.databinding.FragmentTelaInicialBinding
import br.com.zup.simcitysaojoao.home.HomeActivity

class TelaInicialFragment : Fragment() {
    private lateinit var binding: FragmentTelaInicialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTelaInicialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as HomeActivity).supportActionBar?.title = SIMCITY_SAO_JOAD

        binding.btnTelaInicial.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_telaInicialFragment_to_produtosFragment)
        }

    }
}