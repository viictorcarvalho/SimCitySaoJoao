package br.com.zup.simcitysaojoao

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ItemProduto(
    private val nome: String,
    private val quantidade: Int,
    private var imagem: Int
//  private val valor: Double,
//  private val receita: String
) : Parcelable {
    fun getNome() = this.nome
    fun getQuantidade() = this.quantidade
    fun getImage() = this.imagem
//    fun getValor() = this.valor
//    fun getReceita() = this.receita
}
