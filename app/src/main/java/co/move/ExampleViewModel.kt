package co.move

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ExampleViewModel {

    val textBias = MutableLiveData<Float>()
    val iconBias = MutableLiveData<Float>()
    val innerIconBias = MutableLiveData<Float>()

    fun clickText() {
        Log.v("anim", "click( Text )")
        textBias.postValue(random.nextFloat() / 2)
    }

    fun clickBoth() {
        Log.v("anim", "click( Icon + Text )")
        iconBias.postValue(random.nextFloat())
        textBias.postValue(random.nextFloat())
    }

    fun clickAll() {
        Log.v("anim", "click( Icon + Text + Inner )")
        iconBias.postValue(random.nextFloat())
        textBias.postValue(random.nextFloat())
        innerIconBias.postValue(random.nextFloat())
    }

    fun clickIcon() {
        Log.v("anim", "click( Icon )")
        iconBias.postValue(random.nextFloat())
    }

    fun clickInner() {
        Log.v("anim", "click( Inner )")
        innerIconBias.postValue(random.nextFloat())
    }

    val random = Random(123)
}

