package com.example.mvvm_template.utils

import android.app.Activity
import android.app.Service
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.example.mvvm_template.App
import com.example.mvvm_template.ui.base.LoadingDialog
import java.text.SimpleDateFormat
import java.util.*
import javax.sql.DataSource


fun View.showKeyboard() {
    (App.context.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
    (App.context.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(this.windowToken, 0)
}

//fun Context.showSnackBar(message: String){
//    val toastLayout: View = (this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
//        .inflate(R.layout.toast, null)
//    val text = toastLayout.findViewById<TextView>(R.id.text)
//    text.text = message
//    val toast = Toast(this)
//    toast.duration = Toast.LENGTH_LONG
//    toast.view = toastLayout
//    toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, toast.xOffset, 170)
//    toast.show()
//}

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun AppCompatActivity.setupActionBar() {
    supportActionBar?.setDisplayShowHomeEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
}

fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}


/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */

fun View.showToast(
    message: String,
    timeLength: Int
) {
    Toast.makeText(this.context, message, timeLength).show()
}


/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}


fun ImageView.loadImage(url: String?, placeHolder: Int) {
    if (url == null) {
        this.setImageResource(placeHolder)
    } else {
        Glide.with(this.context).load(url).apply(
            RequestOptions()
                .centerCrop()
                .dontAnimate()
                .dontTransform()
                .placeholder(placeHolder)
        ).listener(object : RequestListener<Drawable?> {

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable?>?,
                dataSource: com.bumptech.glide.load.DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                //    progressBar.visibility = View.GONE
                return false
            }

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable?>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }
        })
            .into(this)
    }
}

fun ImageView.loadImage(url: Uri?, placeHolder: Int) {
    if (url == null) {
        this.setImageResource(placeHolder)
    } else {
        Glide.with(this.context).load(url).apply(
            RequestOptions()
                .centerCrop()
                .dontAnimate()
                .dontTransform()
                .placeholder(placeHolder)
        ).listener(object : RequestListener<Drawable?> {

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable?>?,
                dataSource: com.bumptech.glide.load.DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                //    progressBar.visibility = View.GONE
                return false
            }

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable?>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }
        })
            .into(this)
    }
}

fun AppCompatTextView.setTextFutureExt(text: String) =
    setTextFuture(
        PrecomputedTextCompat.getTextFuture(
            text,
            TextViewCompat.getTextMetricsParams(this),
            null
        )
    )

fun AppCompatEditText.setTextFutureExt(text: String) =
    setText(
        PrecomputedTextCompat.create(text, TextViewCompat.getTextMetricsParams(this))
    )

fun AppCompatActivity.startActivityWithFade(intent: Intent) {
    this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    this.startActivity(intent)
}

fun AppCompatActivity.startActivityForResultWithFade(intent: Intent, requestCode: Int) {
    this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    this.startActivityForResult(intent, requestCode)
}

fun Fragment.startActivityWithFade(intent: Intent) {
    this.activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    this.startActivity(intent)
}

fun Fragment.startActivityForResultWithFade(intent: Intent, requestCode: Int) {
    this.activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    this.startActivityForResult(intent, requestCode)
}

fun Activity.makeStatusBarTransparent() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            } else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            statusBarColor = Color.TRANSPARENT
        }
    }
}

fun showDialogTime(
    context: Context,
    selectionTime: String?,
    timeSelected: TimePickerDialog.OnTimeSetListener
): TimePickerDialog {
    var calendar: Calendar = Calendar.getInstance()
    if (!selectionTime.isNullOrEmpty()) {
        try {
            val date = SimpleDateFormat("HH:mm:ss").parse(selectionTime)
            calendar.time = date!!
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    val dialog = TimePickerDialog(
        context,
        timeSelected,
        calendar[Calendar.HOUR_OF_DAY],
        calendar[Calendar.MINUTE],
        false
    )
    return dialog
}

fun showLoadingDialog(context: Context): LoadingDialog {
    val progressDialog = LoadingDialog(context)
    progressDialog.show()
    if (progressDialog.window != null) {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    progressDialog.setCancelable(false)
    progressDialog.setCanceledOnTouchOutside(false)
    return progressDialog
}

fun RecyclerView.configRecycle(isVertical: Boolean) {
    this.setHasFixedSize(true)
    this.isNestedScrollingEnabled = false
    this.itemAnimator = DefaultItemAnimator()
    if (isVertical) {
        this.layoutManager = LinearLayoutManager(this.context)
    } else {
        this.layoutManager = LinearLayoutManager(
            this.context, LinearLayoutManager.HORIZONTAL,
            false
        )
    }
    val animator = this.itemAnimator
    if (animator is SimpleItemAnimator) {
        animator.supportsChangeAnimations = false
        animator.setChangeDuration(0)
    }
}

fun RecyclerView.configGridRecycle(spanCount: Int, isVertical: Boolean) {
    if (isVertical) {
        this.setHasFixedSize(true)
        this.isNestedScrollingEnabled = false
        this.itemAnimator = DefaultItemAnimator()
        this.layoutManager = GridLayoutManager(this.context, spanCount)
    } else {
        this.setHasFixedSize(true)
        this.isNestedScrollingEnabled = false
        this.itemAnimator = DefaultItemAnimator()
        this.layoutManager = GridLayoutManager(
            this.context, spanCount, GridLayoutManager.HORIZONTAL,
            false
        )
    }
    // To solve blinking after notifyDataSetChanged()
    val animator = this.itemAnimator
    if (animator is SimpleItemAnimator) {
        animator .supportsChangeAnimations = false
        animator.setChangeDuration(0)
    }
}

fun RecyclerView.configStaggeredGridRecycle(spanCount: Int, isVertical: Boolean) {
    if (isVertical) {
        this.setHasFixedSize(true)
        this.isNestedScrollingEnabled = false
        this.itemAnimator = DefaultItemAnimator()
        val layoutManager = StaggeredGridLayoutManager(
            spanCount, StaggeredGridLayoutManager.VERTICAL
        )
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        this.layoutManager =layoutManager
    } else {
        this.setHasFixedSize(true)
        this.isNestedScrollingEnabled = false
        this.itemAnimator = DefaultItemAnimator()

        val layoutManager = StaggeredGridLayoutManager(
            spanCount, StaggeredGridLayoutManager.HORIZONTAL
        )
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        this.layoutManager=layoutManager
    }
    // To solve blinking after notifyDataSetChanged()
    val animator = this.itemAnimator
    if (animator is SimpleItemAnimator) {
        animator .supportsChangeAnimations = false
        animator.setChangeDuration(0)
    }
}