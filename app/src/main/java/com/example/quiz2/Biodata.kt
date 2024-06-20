package com.example.quiz2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "nim"
private const val ARG_PARAM2 = "nama"

class BiodataFragment : Fragment() {
    private var nim: String? = null
    private var nama: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nim = it.getString(ARG_PARAM1)
            nama = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_biodata, container, false)

        val textNim = view.findViewById<TextView>(R.id.text_nim)
        val textNama = view.findViewById<TextView>(R.id.text_nama)

        textNim.text = "NIM: $nim"
        textNama.text = "Nama: $nama"

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(nim: String, nama: String) =
            BiodataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, nim)
                    putString(ARG_PARAM2, nama)
                }
            }
    }
}