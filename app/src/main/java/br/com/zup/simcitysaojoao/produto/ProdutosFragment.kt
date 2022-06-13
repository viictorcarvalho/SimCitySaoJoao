package br.com.zup.simcitysaojoao.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentProdutoItemBinding
import br.com.zup.simcitysaojoao.databinding.FragmentProdutosBinding

class ProdutosFragment : Fragment() {
    private lateinit var binding: FragmentProdutosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_produtos, container, false)
    }


}