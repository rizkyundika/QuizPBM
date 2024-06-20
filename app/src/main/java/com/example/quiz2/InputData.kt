package com.example.quiz2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InputData : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input_data, container, false)
        val inputNim = view.findViewById<EditText>(R.id.input_nim)
        val inputNama = view.findViewById<EditText>(R.id.input_nama)
        val inputProdi = view.findViewById<EditText>(R.id.input_prodi)
        val radioGroupStatus = view.findViewById<RadioGroup>(R.id.radio_group_status)
        val buttonSubmit = view.findViewById<Button>(R.id.button_submit)

        buttonSubmit.setOnClickListener {
            val nim = inputNim.text.toString()
            val nama = inputNama.text.toString()
            val prodi = inputProdi.text.toString()
            val statusId = radioGroupStatus.checkedRadioButtonId
            val status = if (statusId == R.id.radio_aktif) "Aktif" else "Tidak Aktif"

            Log.d("InputData", "NIM: $nim, Nama: $nama, Prodi: $prodi, Status: $status")
            Toast.makeText(requireContext(), "Data Submitted: NIM: $nim, Nama: $nama, Prodi: $prodi, Status: $status", Toast.LENGTH_LONG).show()

            val biodataFragment = BiodataFragment.newInstance(nim, nama)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, biodataFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputData().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}