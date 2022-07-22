package br.com.zup.simcitysaojoao.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalBinding
import br.com.zup.simcitysaojoao.home.HomeActivity

class ValorTotalFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalBinding
    private var listaProduto = ArrayList<ItemProduto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValorTotalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as HomeActivity).supportActionBar?.title = VALOR_TOTAL_PRODUTO
        recuperarDadosProduto()

        exibirValorTotal()

        binding.btnCadastrarNovoProduto.setOnClickListener {
            irParaCadastroProduto()
        }
        binding.btnVerProduto.setOnClickListener {
            irParaListaProduto()
        }
    }

    private fun irParaCadastroProduto() {
        val bundle = bundleOf(PRODUTO_KEY to listaProduto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_valorTotalFragment_to_produtosFragment, bundle)
    }

    private fun irParaListaProduto() {
        val bundle = bundleOf(PRODUTO_KEY to listaProduto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_valorTotalFragment_to_produtoCadastradoFragment, bundle)
    }

    fun recuperarDadosProduto() {
        val novaListaProduto = arguments?.getParcelableArrayList<ItemProduto>(PRODUTO_KEY)

        if (novaListaProduto != null) {
            listaProduto = novaListaProduto

            calcularValorTotal()
            binding.tvValorTotal.text = calcularValorTotal().toString()
        }
    }

    fun calcularValorTotal() : Double {
        var somatoria = 0.0
        listaProduto.forEach {
            somatoria += it.getValorTotal()
        }
        return somatoria
    }

    fun exibirValorTotal() {
        binding.tvValorTotal.text = getString(R.string.valor_total) + calcularValorTotal().toString()
    }
}