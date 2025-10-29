package com.example.yourappname

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

fun loadRewardedAd(context: Context, onAdLoaded: (RewardedAd) -> Unit) {
    val adUnitId = "ca-app-pub-7188716363710434/9079934540" // Google's Test Rewarded ID
    RewardedAd.load(context, adUnitId, AdManagerAdRequest.Builder().build(), object : RewardedAdLoadCallback() {
        override fun onAdLoaded(ad: RewardedAd) {
            onAdLoaded(ad)
        }
        override fun onAdFailedToLoad(error: LoadAdError) {
            // Handle ad loading failure
        }
    })
}

fun showRewardedAd(activity: Activity, rewardedAd: RewardedAd, onRewardEarned: () -> Unit) {
    rewardedAd.fullScreenContentCallback = object : FullScreenContentCallback() {
        override fun onAdDismissedFullScreenContent() {
            // Called when ad is dismissed.
        }
        override fun onAdFailedToShowFullScreenContent(adError: AdError) {
            // Called when ad fails to show.
        }
    }
    rewardedAd.show(activity) {
        // User earned the reward.
        onRewardEarned()
    }
}