package br.com.zup.simcitysaojoao

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class itemProduto(
    private val nome: String,
    private val quantidade: Int,
    private val valorProduto: Double,
    private val receita: String
) : Parcelable {
    fun getNome() = this.nome
    fun getQuantidade() = this.quantidade
    fun getValorProduto() = this.valorProduto
    fun getReceita() = this.receita
}
