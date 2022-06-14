package br.com.zup.simcitysaojoao.produto.produtoCadastrado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.ItemProduto
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentProdutoCadastradoBinding
import br.com.zup.simcitysaojoao.databinding.FragmentTelaInicialBinding
import br.com.zup.simcitysaojoao.home.HomeActivity
import br.com.zup.simcitysaojoao.produto.adapter.ProdutoAdapter

class ProdutoCadastradoFragment : Fragment() {
private lateinit var binding: FragmentProdutoCadastradoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProdutoCadastradoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaProduto = arguments?.getParcelableArrayList<ItemProduto>("PRODUTO_KEY")

        listaProduto?.let {
            binding.rvListaProduto.adapter = ProdutoAdapter(it)
            binding.rvListaProduto.layoutManager = LinearLayoutManager (context)
        }
        (activity as HomeActivity).supportActionBar?.title = "Produto"

    }
}