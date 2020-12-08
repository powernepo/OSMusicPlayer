package com.powernepo.osmusicplayer

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.powernepo.device_content.annotation.Column
import com.powernepo.device_content.extension.generate
import com.powernepo.device_media.music.domain.repository.MusicRepository
import com.powernepo.offline.domain.repository.MobileRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

class Music(
    @Column(MediaStore.Audio.Media._ID)
    val id: String,

    @Column(MediaStore.Audio.Media.DATA)
    val data: String
)

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
                val builder = generate<Music>(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, requireContext())
                val generated = builder.generateList()
                generated
            }
        }
    }

    private suspend fun requestPermissions(callback: suspend () -> Unit) {
        val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        val isGranted = permissions.fold(initial = true, operation = { acc, permission ->
            acc && requireContext().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
        })

        if (isGranted.not()) {
            ActivityCompat.requestPermissions(requireActivity(), permissions, PERMISSION_CODE)
        } else {
            callback()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
