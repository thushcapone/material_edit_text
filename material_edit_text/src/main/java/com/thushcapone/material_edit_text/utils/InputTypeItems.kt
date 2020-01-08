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

package com.thushcapone.material_edit_text.utils

import android.text.InputType


/**
 * Created by Thiependa Seye on 12/20/19.
 * T.C.
 * thiependa.seye@gmail.com
 */

class InputTypeItem(val name: String, val value: Int) {
    companion object {
        val INPUT_TYPES = arrayListOf<InputTypeItem>(
            InputTypeItem(
                "date",
                InputType.TYPE_CLASS_DATETIME or InputType.TYPE_DATETIME_VARIATION_DATE
            ),
            InputTypeItem(
                "datetime",
                InputType.TYPE_CLASS_DATETIME or InputType.TYPE_DATETIME_VARIATION_NORMAL
            ),
            InputTypeItem("none", InputType.TYPE_NULL),
            InputTypeItem(
                "number",
                InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_NORMAL
            ),
            InputTypeItem(
                "numberDecimal",
                InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            ),
            InputTypeItem(
                "numberPassword",
                InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            ),
            InputTypeItem(
                "numberSigned",
                InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_SIGNED
            ),
            InputTypeItem("phone", InputType.TYPE_CLASS_PHONE),
            InputTypeItem(
                "text",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
            ),
            InputTypeItem(
                "textAutoComplete",
                InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE
            ),
            InputTypeItem(
                "textAutoCorrect",
                InputType.TYPE_TEXT_FLAG_AUTO_CORRECT
            ),
            InputTypeItem(
                "textCapCharacters",
                InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
            ),
            InputTypeItem(
                "textCapSentences",
                InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            ),
            InputTypeItem("textCapWords", InputType.TYPE_TEXT_FLAG_CAP_WORDS),
            InputTypeItem(
                "textEmailAddress",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            ),
            InputTypeItem(
                "textEmailSubject",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT
            ),
            InputTypeItem(
                "textFilter",
                InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
            ),
            InputTypeItem(
                "textLongMessage",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE
            ),
            InputTypeItem(
                "textMultiLine",
                InputType.TYPE_TEXT_FLAG_MULTI_LINE
            ),
            InputTypeItem(
                "textNoSuggestions",
                InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            ),
            InputTypeItem(
                "textPassword",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            ),
            InputTypeItem(
                "textPersonName",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            ),
            InputTypeItem(
                "textPhonetic",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PHONETIC
            ),
            InputTypeItem(
                "textPostalAddress",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS
            ),
            InputTypeItem(
                "textShortMessage",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE
            ),
            InputTypeItem(
                "textUri",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_URI
            ),
            InputTypeItem(
                "textVisiblePassword",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            ),
            InputTypeItem(
                "textWebEditText",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT
            ),
            InputTypeItem(
                "textWebEmailAddress",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
            ),
            InputTypeItem(
                "textWebPassword",
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD
            ),
            InputTypeItem(
                "time",
                InputType.TYPE_CLASS_DATETIME or InputType.TYPE_DATETIME_VARIATION_TIME
            )
        )
    }
}