package br.com.zup.simcitysaojoao.produto.produtoCadastrado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentProdutoCadastradoBinding
import br.com.zup.simcitysaojoao.home.HomeActivity
import br.com.zup.simcitysaojoao.produto.adapter.ProdutoAdapter

class ProdutoCadastradoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoCadastradoBinding
    private val adapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalhesProduto)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutoCadastradoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as HomeActivity).supportActionBar?.title = PRODUTO

        exibirRecycleView()
    }

    private fun exibirRecycleView() {
        val listaProduto = arguments?.getParcelableArrayList<ItemProduto>(LISTA_KEY)

        listaProduto?.let {
            adapter.atualizarLista(novaListaProduto = listaProduto)
            binding.rvListaProduto.adapter = adapter
            binding.rvListaProduto.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun irParaDetalhesProduto(produto: ItemProduto) {
        val bundle = bundleOf(PRODUTO_KEY to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtoCadastradoFragment_to_detalheProdutoFragment, bundle)
    }
}