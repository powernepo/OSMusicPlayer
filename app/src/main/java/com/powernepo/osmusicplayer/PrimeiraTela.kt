package com.powernepo.osmusicplayer

import android.Manifest
import android.content.ComponentName
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.session.MediaControllerCompat
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.powernepo.common_android.extension.hasPermissionsCompat
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PrimeiraTela : Fragment(R.layout.fragment_primeira_tela) {

    companion object {
        const val PERMISSION_CODE = 123
    }

    private val mediaBrowser: MediaBrowserCompat by lazy {
        MediaBrowserCompat(
            context,
            ComponentName(requireContext(), MusicService::class.java),
            mediaBrowserConnectionCallback,
            null
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().hasPermissionsCompat(Manifest.permission.READ_EXTERNAL_STORAGE) {
            ActivityCompat.requestPermissions(requireActivity(), it, PERMISSION_CODE)
        }
    }

    private val mediaBrowserConnectionCallback = MediaBrowserConnectionCallback()

    private val mediaControllerCallback = MediaControllerCallback()

    private val mediaBrowserSubscriptionCallback = MediaBrowserSubscriptionCallback()

    override fun onStart() {
        super.onStart()
        mediaBrowser.connect()
        mediaBrowser.subscribe("/", mediaBrowserSubscriptionCallback)
    }

    override fun onStop() {
        MediaControllerCompat.getMediaController(requireActivity())
            ?.unregisterCallback(mediaControllerCallback)
        mediaBrowser.disconnect()
        super.onStop()
    }

    inner class MediaBrowserConnectionCallback : MediaBrowserCompat.ConnectionCallback() {
        override fun onConnected() {
            val token = mediaBrowser.sessionToken
            val mediaController = MediaControllerCompat(requireContext(), token)
            mediaController.registerCallback(mediaControllerCallback)
            MediaControllerCompat.setMediaController(requireActivity(), mediaController)
        }
    }

    inner class MediaControllerCallback : MediaControllerCompat.Callback() {

    }

    inner class MediaBrowserSubscriptionCallback : MediaBrowserCompat.SubscriptionCallback() {
        override fun onChildrenLoaded(
            parentId: String,
            children: List<MediaBrowserCompat.MediaItem>
        ) {
            if (children.isNotEmpty()) {
                val mediaController = MediaControllerCompat.getMediaController(requireActivity())
                mediaController.transportControls.playFromUri(
                    children.first().description.mediaUri,
                    null
                )
            }
        }
    }
}
