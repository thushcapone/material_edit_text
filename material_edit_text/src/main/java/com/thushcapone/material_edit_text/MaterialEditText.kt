/*
 *
 *  * Copyright (c) 2018. T.C.
 *  * All Rights Reserved
 *  *
 *  * This product is protected by copyright and distributed under
 *  * licenses restricting copying, distribution and decompilation.
 *  *
 *
 */

package com.thushcapone.material_edit_text

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.thushcapone.custom_edit_text.R
import com.thushcapone.material_edit_text.extensions.getParentActivity
import com.thushcapone.material_edit_text.utils.InputTypeItem


/**
 * Created by Thiependa Seye on 1/8/19.
 * T.C
 * thiependa.seye@gmail.com
 */
class MaterialEditText : LinearLayout {

    var edit: TextInputEditText? = null
    var layout: TextInputLayout? = null

    private var mHint: String? = null
    private var mInputType: String? = null

    constructor(context: Context) : super(context) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getStyleable(attrs)
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getStyleable(attrs)
        initializeViews(context)
    }

    private fun getStyleable(attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.MaterialEditText, 0, 0
        )

        mHint = context.getString(a.getResourceId(
            R.styleable.MaterialEditText_hint,
            R.string.empty
        ))
        mInputType = a.getString(R.styleable.MaterialEditText_inputType)
        a.recycle()
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context the current context for the view.
     */
    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.compound_edit_text, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        setupView()
        setupHint()
        setupInputTypes()
        removeError()
    }

    private fun setupView() {
        layout = findViewById(R.id.layout_item)
        edit = findViewById(R.id.edit_item)
    }

    private fun setupHint(){
        layout?.hint = mHint
    }

    private fun setupInputTypes(){
        InputTypeItem.INPUT_TYPES.find { item -> item.name == mInputType }?.let {
            edit?.inputType = it.value
        }
    }

    private fun removeError(){
        edit?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                layout?.error = ""
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    fun setText(text: String){
        edit?.setText(text)
    }

    fun setText(@StringRes resId: Int){
        edit?.setText(resId)
    }

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()

        bundle.putParcelable(STATE_SUPER_CLASS, super.onSaveInstanceState())

        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        if (state is Bundle) {
            super.onRestoreInstanceState(state.getParcelable(STATE_SUPER_CLASS))
        } else {
            super.onRestoreInstanceState(state)
        }
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>) {
        // Makes sure that the state of the child views in the side
        // spinner are not saved since we handle the state in the
        // onSaveInstanceState.
        super.dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>) {
        // Makes sure that the state of the child views in the side
        // spinner are not restored since we handle the state in the
        // onSaveInstanceState.
        super.dispatchThawSelfOnly(container)
    }

    companion object {

        /**
         * Identifier for the state of the super class.
         */
        private const val STATE_SUPER_CLASS = "SuperClass"
    }

}

////------------------ SET TEXT -------------/////

@BindingAdapter("textAttrChanged")
fun setTextListener(materialEditText: MaterialEditText, listener: InverseBindingListener) {
    materialEditText.edit?.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            listener.onChange()
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}

@BindingAdapter("text")
fun setTextValue(materialEditText: MaterialEditText, value: String?) {
    if (value != materialEditText.edit?.text.toString()) materialEditText.edit?.setText(value)
}

@InverseBindingAdapter(attribute = "text")
fun getTextValue(materialEditText: MaterialEditText): String? {
    return materialEditText.edit?.text.toString()
}

////------------------ END SET TEXT -------------/////


////------------------ SET ERROR -------------/////
@BindingAdapter("error")
fun setErrorValue(materialEditText: MaterialEditText, error: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = materialEditText.getParentActivity()
    if (parentActivity != null && error != null) {
        error.observe(
            parentActivity,
            Observer { value -> materialEditText.layout?.error = value }
        )
    }
}

////------------------ END  SET ERROR -------------/////
