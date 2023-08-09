package ru.liknot.testtask.presentation.screens.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.launch
import ru.liknot.testtask.R
import ru.liknot.testtask.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewBinding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        renderState()
        initBtn()
    }

    private fun initBtn() {
        with(viewBinding) {
            btnLoad.setOnClickListener {
                initWebView()
            }
        }
    }

    private fun initWebView() {

        val webViewClient = object : WebViewClient() {

            var requestId: String = ""
            var requestUuId: String = ""
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                Log.d("MY_TAG", request?.url.toString())

                if (request?.url?.queryParameterNames?.contains("id") == true) {
                    requestId = request.url?.getQueryParameter("id").toString()
                }

                if (request?.url?.queryParameterNames?.contains("uuid") == true) {
                    requestUuId = request.url?.getQueryParameter("uuid").toString()
                }
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                viewModel.saveId(requestId, requestUuId)
            }
        }

        viewModel.loadPage()
        viewBinding.mainWebView.webViewClient = webViewClient
        viewBinding.mainWebView.loadUrl("http://app.zaimforyou.ru/hello")

    }

    private fun renderState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {

                        is MainViewModel.UiState.Default -> {
                            renderLayoutDefaultState(uiState.id, uiState.uuid)
                        }

                        is MainViewModel.UiState.Error -> {
                            renderLayoutErrorState(uiState.exception)
                        }

                        MainViewModel.UiState.Loading -> {
                            renderLayoutLoadingState()
                        }

                        is MainViewModel.UiState.Success -> {
                            renderLayoutSuccessState(uiState.id, uiState.uuid)
                        }
                    }
                }
            }
        }
    }

    private fun renderLayoutSuccessState(id: String?, uuid: String?) {
        with(viewBinding) {
            progressBar.visibility = View.GONE
            btnLoad.visibility = View.GONE
            tvIdRedirect.visibility = View.VISIBLE
            mainWebView.visibility = View.VISIBLE

            (tvIdRedirect.layoutParams as? ConstraintLayout.LayoutParams)?.apply {
                topToTop = ConstraintLayout.LayoutParams.UNSET
            }
            tvIdRedirect.text = getString(R.string.id_and_uuid, id, uuid)
        }
    }

    private fun renderLayoutLoadingState() {
        with(viewBinding) {
            progressBar.visibility = View.VISIBLE
            btnLoad.visibility = View.GONE
            tvIdRedirect.visibility = View.GONE
            mainWebView.visibility = View.GONE
        }
    }

    private fun renderLayoutErrorState(ex: Throwable) {
        with(viewBinding) {
            progressBar.visibility = View.GONE
            btnLoad.visibility = View.VISIBLE

            (tvIdRedirect.layoutParams as? ConstraintLayout.LayoutParams)?.apply {
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            }
            tvIdRedirect.text = ex.message
        }
    }

    private fun renderLayoutDefaultState(id: String?, uuid: String?) {
        with(viewBinding) {
            progressBar.visibility = View.GONE
            btnLoad.visibility = View.VISIBLE
            mainWebView.visibility = View.GONE

            (tvIdRedirect.layoutParams as? ConstraintLayout.LayoutParams)?.apply {
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            }

            tvIdRedirect.text = getString(R.string.id_and_uuid, id, uuid)
        }
    }


    companion object {
        const val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"

        fun getInstance() = MainFragment()
    }
}
