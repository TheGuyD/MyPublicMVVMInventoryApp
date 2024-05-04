package il.theguyd.mymvvmrivhitapp.utils;


import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.navigation.NavigationView;

import il.theguyd.mymvvmrivhitapp.R;

public final class Utils {

    /**
    * private constructor to prevent class instantiation
    * */
    private Utils() {
    }

    /**
     * load image from url to the context
     * @param context
     * @param imageView
     * @param url
     * @param imageProportions
     * */
    public static void showImage(Context context, ImageView imageView , String url , int imageProportions){
        final Context  selfContext = context.getApplicationContext();

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground).centerInside();

        if (isValidContextForGlide(selfContext)){
            Glide.with(selfContext).load(url)
                    .apply(options)
                    .override(imageProportions,imageProportions)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imageView);

        }

    }

    public static String cleanString(String string){
        return string.replaceAll("^\\s+|\\s+$", "");
    }

    private static boolean isValidContextForGlide(final Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof Activity) {
            final Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return false;
            }
        }
        return true;
    }

    /**
     * build navigation drawer based on user choice
     * @param navigationView
     */
    public static void initDrawer(NavigationView navigationView){
        navigationView.getMenu().add(0,0,0,"test");

    }



}
