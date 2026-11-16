package com.rocardan.androws

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : Activity() {
 private lateinit var browser: WebView
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  browser = WebView(this)
  browser.settings.javaScriptEnabled = true
  browser.settings.allowFileAccess = true
  browser.settings.allowFileAccessFromFileURLs = false
  browser.settings.allowUniversalAccessFromFileURLs = false
  browser.webViewClient = WebViewClient()
  browser.addJavascriptInterface(Bridge(), "Android")
  setContentView(browser)
  browser.loadUrl("file:///android_asset/index.html")
 }
 inner class Bridge {
  @JavascriptInterface fun apps(): String {
   val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
   val entries = packageManager.queryIntentActivities(intent, 0).sortedBy { it.loadLabel(packageManager).toString().lowercase() }
   val arr = JSONArray()
   entries.forEach { val obj = JSONObject(); obj.put("name", it.loadLabel(packageManager).toString()); obj.put("package", it.activityInfo.packageName); arr.put(obj) }
   return arr.toString()
  }
  @JavascriptInterface fun launch(pkg: String) {
   runOnUiThread { try { packageManager.getLaunchIntentForPackage(pkg)?.let { startActivity(it) } } catch (_: Exception) {} }
  }
  @JavascriptInterface fun openSettings() {
   runOnUiThread { startActivity(Intent(android.provider.Settings.ACTION_SETTINGS)) }
  }
 }
 override fun onBackPressed() { browser.evaluateJavascript("window.closeStart && window.closeStart()", null) }
}
