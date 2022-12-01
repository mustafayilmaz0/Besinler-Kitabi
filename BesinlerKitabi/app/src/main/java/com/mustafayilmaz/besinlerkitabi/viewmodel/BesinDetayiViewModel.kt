package com.mustafayilmaz.besinlerkitabi.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.mustafayilmaz.besinlerkitabi.model.Besin
import com.mustafayilmaz.besinlerkitabi.servis.BesinDatabase
import kotlinx.coroutines.launch

class BesinDetayiViewModel(application: Application) : BaseViewModel(application) {

    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl(uuid: Int){
        launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            val besin = dao.getBesin(uuid)
            besinLiveData.value = besin
        }
    }
}