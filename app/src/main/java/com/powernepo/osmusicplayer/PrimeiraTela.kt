package com.powernepo.osmusicplayer

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.powernepo.common_android.extension.hasPermissionCompat
import com.powernepo.common_android.extension.hasPermissionsCompat
import com.powernepo.device_media.music.domain.repository.MusicRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@AndroidEntryPoint
class PrimeiraTela : Fragment(R.layout.fragment_primeira_tela) {

    companion object {
        const val PERMISSION_CODE = 123
    }

    @Inject
    lateinit var repository: MusicRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.coroutineScope.launch {
            requestPermissions {
                val musics = repository.all()
                musics
            }
        }
    }

    private suspend fun requestPermissions(callback: suspend () -> Unit) {
        requireContext().hasPermissionsCompat(Manifest.permission.READ_EXTERNAL_STORAGE){
            ActivityCompat.requestPermissions(requireActivity(), it, PERMISSION_CODE)
        }.takeIf {
            it
        }?.let {
            callback()
        }
    }
}
