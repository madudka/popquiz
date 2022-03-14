package com.madudka.popquiz.adv;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.madudka.popquiz.R;
import com.madudka.popquiz.TemplateLevelActivity;


public class AdvHelper {
    public static int typeOperation = 0;
    private static InterstitialAd mInterstitialAd;

    public static void init(Context context) {
        MobileAds.initialize(context, initializationStatus -> {
        });
    }

    public static void loadBanner(AdView mAdView){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public static void loadInterstitial(Context context) {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(context, context.getString(R.string.AD_UNIT_INTERSTITIAL),
                adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                mInterstitialAd = null;
                                switch (typeOperation){
                                    default:
                                    case 0: break;
                                    case 1:
                                        if (TemplateLevelActivity.instance.lvlNum < 30) TemplateLevelActivity.instance.back();
                                        else TemplateLevelActivity.instance.gameWin();
                                        break;
                                    case 2: TemplateLevelActivity.instance.gameContinue(); break;
                                }
                            }

                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }

    public static boolean showInterstitialAd(Activity activity, Context context){
        if (mInterstitialAd == null){
            loadInterstitial(context);
            return false;
        } else {
            mInterstitialAd.show(activity);
            return true;
        }
    }
}
