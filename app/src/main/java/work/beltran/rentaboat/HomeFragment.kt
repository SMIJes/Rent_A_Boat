package work.beltran.rentaboat


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_container_home) as NavHostFragment

        /*This provides the bottomNavigationView with default effects*/
        view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                .setupWithNavController(navHostFragment.navController)

        /*This will provided the toolbar but with a back arrow*/
        //view.findViewById<Toolbar>(R.id.toolbar)
        //        .setupWithNavController(navHostFragment.navController)

        /*This provides the toolbar with just our custom effects*/
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        navHostFragment.navController.addOnDestinationChangedListener { _, destination,_ ->
            toolbar.title = destination.label
        }

        return view
    }


}
