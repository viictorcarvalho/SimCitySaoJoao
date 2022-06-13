package br.com.zup.simcitysaojoao.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.ItemProduto
import br.com.zup.simcitysaojoao.databinding.FragmentProdutoItemBinding

class ProdutoAdapter(private var listaProduto: MutableList<ItemProduto>) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            FragmentProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirDadosItemLista(produto)
    }

    override fun getItemCount(): Int = listaProduto.size // ou pode ser usado: return listaProduto.size

    fun atualizarListaProduto(novaListaProduto: MutableList<ItemProduto>) {
        if (listaProduto.size == 0){
            listaProduto = novaListaProduto
        }else{
            listaProduto.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: FragmentProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun exibirDadosItemLista(produto: ItemProduto) {
            binding.ivCarrinho.setImageResource(produto.getImage())
            binding.tvQuantidadeProduto.text = produto.getQuantidade().toString()
            binding.tvNomeProduto.text = produto.getNome()
        }
    }
}