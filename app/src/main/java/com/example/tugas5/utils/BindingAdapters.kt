package com.example.tugas5.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas5.R
import com.example.tugas5.model.Movie
import com.example.tugas5.model.Status
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@BindingAdapter("app:setTextInvoiceNumber")
fun bindTextInvoiceNumber(view: TextView, text: String) {
    view.text = view.context.getString(R.string.invoiceNumber, text)
}

@BindingAdapter("app:textPrice")
fun bindTextPrice(view: TextView, price: Int) {
    (DecimalFormat.getCurrencyInstance() as DecimalFormat).also { kursIndo ->
        DecimalFormatSymbols().also { formatRp ->
            formatRp.currencySymbol = "Rp "
            formatRp.groupingSeparator = '.'
            kursIndo.decimalFormatSymbols = formatRp
        }
        view.text = kursIndo.format(price)
    }
}

@BindingAdapter("app:status")
fun bindStatusHistory(view: TextView, status: Status) {
    view.text = when (status) {
        Status.WAITINGPAYMENT -> view.context.getString(R.string.waitingPayment)
        Status.SUCCESS -> view.context.getString(R.string.success)
        Status.FAILED -> view.context.getString(R.string.failed)
    }
}

// image poster movie
@BindingAdapter("app:image")
fun bindImage(view: ImageView, movie: Movie) {
    Glide.with(view.context)
        .load(movie.getPoster())
        .apply(RequestOptions().override(400, 400))
        .into(view)
}

// image single
@BindingAdapter("app:imageSingle")
fun bindImageSingle(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .apply(RequestOptions().override(400, 400))
        .into(view)
}

// image backdrop
@BindingAdapter("app:imageBackdrop")
fun bindImageBackdrop(view: ImageView, movie: Movie) {
    Glide.with(view.context)
        .load(movie.getBackdrop())
        .apply(RequestOptions().override(500, 500))
        .into(view)
}