package work.beltran.rentaboat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.view.*


class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        /*This old method is now archaic in kotlin*/
        //view.findViewById<Button>(R.id.button_login).setOnClickListener { }

        /*Sets the onClickListeners for the login and register buttons*/
        //Here the actual action is stated, hence the curly brackets
        view.buttonLogin.setOnClickListener {
            val email = view.editTextEmail.text.toString()
            val password = view.editTextPassword.text.toString()
            if (email.isEmpty() && password.isEmpty()) {
                findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
            }
        }

        //Here an onClickListener is passed, hence the normal brackets
        view.buttonRegister.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                    R.id.action_welcomeFragment_to_registrationFragment))

        return view
    }
}
