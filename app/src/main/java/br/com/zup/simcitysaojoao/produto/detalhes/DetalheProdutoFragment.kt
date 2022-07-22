package br.com.zup.simcitysaojoao.produto.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentDetalheProdutoBinding
import br.com.zup.simcitysaojoao.home.HomeActivity

class DetalheProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalheProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as HomeActivity).supportActionBar?.title = DETALHES_PRODUTO
        recuperarDadosProduto()

        binding.btnFavoritar.setOnClickListener {
            favoritarProduto()
        }
    }

    private fun favoritarProduto() {
        Toast.makeText(context, MENSAGEM_PRODUTO_FAVORITADO, Toast.LENGTH_LONG).show()
    }

    private fun recuperarDadosProduto() {
        val produto = arguments?.getParcelable<ItemProduto>(PRODUTO_KEY)
        if (produto != null) {
            binding.tvNomeProduto.text = produto.getNome()
            binding.tvQuantidadeProduto.text = produto.getQuantidade().toString()
            binding.tvValorProduto.text = produto.getValor().toString()
            binding.tvReceitaProdutoTelaDetalhes.text = produto.getReceita()
        }
    }
}
