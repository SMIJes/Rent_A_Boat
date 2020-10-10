package work.beltran.rentaboat


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_boat.view.*
import work.beltran.rentaboat.feed.BOATS
import work.beltran.rentaboat.feed.getBoat


class BoatFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_boat, container, false)

        //get from deepLink....
        val id = arguments?.getString("id_dl")?.toInt()
                //or get from bundle (default should be set...in the nav_graph)
                ?:BoatFragmentArgs.fromBundle(requireArguments()).id

        //Safe way, as we only need the variable name
        //val id = BoatFragmentArgs.fromBundle(requireArguments()).id

        //Unsafe way of getting arguments, as the key or type may change
        //val id = requireArguments().getInt("id")

        val boat = BOATS.getBoat(id)
        view.nameTextView.text = boat.name
        view.locationTextView.text = boat.location
        view.boatImageViewBoat.setImageResource(boat.picture)
        view.priceTextView.text = boat.price
        return view
    }
}
