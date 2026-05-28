package rpt.com.base.navigation

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import rpt.com.base.log.w


fun View.safeNavController(): NavController? {
    runCatching {
        findNavController()
    }.onSuccess {
        return it
    }.onFailure {
        w(it)
    }

    return null
}