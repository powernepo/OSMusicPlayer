package com.powernepo.osmusicplayer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.powernepo.offline.domain.repository.MobileRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PrimeiraTela : Fragment(R.layout.fragment_primeira_tela){

    @Inject
    lateinit var repository: MobileRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val res = repository.all()
        println(res)
    }
}
