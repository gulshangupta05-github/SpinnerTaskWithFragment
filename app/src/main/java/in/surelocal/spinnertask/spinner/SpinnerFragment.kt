package `in`.surelocal.spinnertask.spinner

import `in`.surelocal.spinnertask.R
import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.spinner_fragment.*


class SpinnerFragment : Fragment() {

    companion object {
        fun newInstance() = SpinnerFragment()
    }

    private lateinit var viewModel: SpinnerViewModel

    val items = arrayOf("States", "UttarPradesh", "Uttrakhand", "Mumbai")
    val district1 = arrayOf("District1", "Deoria", "Lucknow", "Gorakhpur", "Gaziyabaad")
    val district2 = arrayOf("District2", "Haridwar", "Nainital", "Dehradun", "Chamoli")
    val district3 = arrayOf("District3", "Kolhapur", "Bandra", "Lonavana", "Pune")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.spinner_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SpinnerViewModel::class.java)

        sp.adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, items)
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                result.text = items.get(id.toInt())
                if (position == 0) {
                    sp2.visibility = View.GONE
                } else if (position == 1) {
                    sp2.adapter = ArrayAdapter<String>(
                        requireContext(),
                        android.R.layout.simple_list_item_1,
                        district1
                    )
                    sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                        }
                        override fun onItemSelected(
                            parent: AdapterView<*>?, view: View?, position: Int, id: Long
                        ) {
                            result2.text = district1.get(id.toInt())
                        }
                    }
                    sp2.visibility = View.VISIBLE
                    sp2.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, district1
                    )
                } else if (position == 2) {
                    sp2.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, district2
                    )
                    sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                        }
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
                        ) {
                            result2.text = district2.get(id.toInt())
                        }

                    }
                    sp2.visibility = View.VISIBLE
                    sp2.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, district2
                    )
                } else if (position == 3) {
                    sp2.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, district3
                    )
                    sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                        }
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
                        ) {
                            result2.text = district3.get(id.toInt())
                        }
                    }
                    sp2.visibility = View.VISIBLE
                    sp2.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, district3
                    )
                } else {
                    result2.text = items.get(id.toInt())
                }

            }
        }

    }

}


