package br.com.zup.simcitysaojoao.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentProdutosBinding
import br.com.zup.simcitysaojoao.home.HomeActivity

class ProdutosFragment : Fragment() {
    private lateinit var binding: FragmentProdutosBinding
    private var listaProduto = ArrayList<ItemProduto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as HomeActivity).supportActionBar?.title = PRODUTO

        binding.btnVerProduto.setOnClickListener {
            irParaListaProduto()
        }
        binding.btnValorTotal.setOnClickListener {
            irParaValorTotal()
        }

        criarListaProduto()
    }

    private fun criarListaProduto() {
        binding.btnCadastrarNovoProduto.setOnClickListener {
            val nomeProduto = binding.etNomeProduto.text.toString()
            val quantidadeProduto = binding.etQuantidadeProduto.text.toString()
            val valorProduto = binding.etValorProduto.text.toString()
            val receitaProduto = binding.etReceita.text.toString()

            if (nomeProduto.isNotBlank() && quantidadeProduto.isNotBlank() && valorProduto.isNotBlank() && receitaProduto.isNotBlank()) {

                listaProduto.add(
                    ItemProduto(
                        nomeProduto,
                        quantidadeProduto.toInt(),
                        valorProduto.toDouble(),
                        receitaProduto
                    )
                )
                Toast.makeText(context, MENSAGEM_CADASTRO_PRODUTO, Toast.LENGTH_SHORT).show()
                limparCampos()
            } else {
                msgErro(nomeProduto, quantidadeProduto, valorProduto, receitaProduto)
            }
        }
    }

    private fun irParaListaProduto() {
        val bundle = bundleOf(PRODUTO_KEY to listaProduto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtosFragment_to_produtoCadastradoFragment, bundle)
    }

    private fun irParaValorTotal() {
        val bundle = bundleOf(PRODUTO_KEY to listaProduto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtosFragment_to_valorTotalFragment, bundle)
    }

    private fun msgErro(nome: String, quantidade: String, valor: String, receita: String) {
        binding.etNomeProduto.error = if (nome.isBlank()) MENSAGEM_CAMPO_OBRIGATORIO else null
        binding.etQuantidadeProduto.error =
            if (quantidade.isBlank()) MENSAGEM_CAMPO_OBRIGATORIO else null
        binding.etValorProduto.error = if (valor.isBlank()) MENSAGEM_CAMPO_OBRIGATORIO else null
        binding.etReceita.error = if (receita.isBlank()) MENSAGEM_CAMPO_OBRIGATORIO else null
    }

    private fun limparCampos() {
        binding.etNomeProduto.text.clear()
        binding.etQuantidadeProduto.text.clear()
        binding.etValorProduto.text.clear()
        binding.etReceita.text.clear()
    }
}