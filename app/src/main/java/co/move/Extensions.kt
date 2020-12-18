package co.move

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.BindingAdapter

class Extensions private constructor() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:animateVertical")
        fun animateVertical(view: View, value: Float) {
            Log.v("anim", "vertical | $value on ${(view as? TextView)?.text}")
            (view.parent as? ConstraintLayout)?.let { layout ->
                TransitionManager.beginDelayedTransition(
                    layout,
                    AutoTransition().apply {
                        startDelay = 0
                        duration = 200
                    })

                ConstraintSet().apply {
                    clone(layout)
                    setVerticalBias(view.id, value)
                    applyTo(layout)
                }
            }
        }

        @JvmStatic
        @BindingAdapter("app:animateHorizontal")
        fun animateHorizontal(view: View, value: Float) {
            Log.v("anim", "horizontal -  $value on ${(view as? TextView)?.text}")
            (view.parent as? ConstraintLayout)?.let { layout ->
                TransitionManager.beginDelayedTransition(
                    layout,
                    AutoTransition().apply {
                        startDelay = 0
                        duration = 200
                    })
                ConstraintSet().apply {
                    clone(layout)
                    setHorizontalBias(view.id, value)
                    applyTo(layout)
                }
            }
        }
    }
}
