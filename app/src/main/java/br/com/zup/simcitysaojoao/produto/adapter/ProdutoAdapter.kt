package br.com.zup.simcitysaojoao.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.ItemProduto
import br.com.zup.simcitysaojoao.databinding.FragmentProdutoItemBinding

class ProdutoAdapter(
    private var listaProduto: ArrayList<ItemProduto>,
    private var irParaDetalhe: (produto: ItemProduto) -> Unit
) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            FragmentProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirDadosItemLista(produto)

        holder.binding.cvItem.setOnClickListener {
            irParaDetalhe(produto)
        }
    }

    override fun getItemCount(): Int =
        listaProduto.size // ou pode ser usado: return listaProduto.size

    fun atualizarLista(novaListaProduto: ArrayList<ItemProduto>) {
        listaProduto = novaListaProduto
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: FragmentProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun exibirDadosItemLista(produto: ItemProduto) {
            binding.tvProduto.text = "${produto.getQuantidade()} - ${produto.getNome()}"
        }
    }
}