package rpt.com.base.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import rpt.com.base.log.w


fun FragmentActivity.safeNavController(navHostId: Int): NavController? {
    runCatching {
        findNavControllerWithFragmentManager(navHostId)
    }.onSuccess {
        return it
    }

    runCatching {
        findNavControllerWithNavHostId(navHostId)
    }.onSuccess {
        return it
    }.onFailure {
        w(it)
    }

    return null
}

private fun FragmentActivity.findNavControllerWithFragmentManager(navHostId: Int): NavController? {
    runCatching {
        (supportFragmentManager.findFragmentById(navHostId) as NavHostFragment)
            .navController
    }.onSuccess {
        return it
    }

    return null
}

private fun FragmentActivity.findNavControllerWithNavHostId(navHostId: Int): NavController? {
    runCatching {
        findNavController(navHostId)
    }.onSuccess {
        return it
    }

    return null
}