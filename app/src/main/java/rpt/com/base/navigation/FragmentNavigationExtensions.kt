package rpt.com.base.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import rpt.com.base.log.w


fun Fragment.safeNavController(navHostId: Int): NavController? {
    runCatching {
        findNavController()
    }.onSuccess {
        return it
    }

    runCatching {
        requireActivity().safeNavController(navHostId)
    }.onSuccess {
        return it
    }

    runCatching {
        requireView().safeNavController()
    }.onSuccess {
        return it
    }.onFailure {
        w(it)
    }

    return null
}