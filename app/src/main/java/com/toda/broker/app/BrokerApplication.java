package com.toda.broker.app;

import android.app.Application;
import android.content.Context;

import com.toda.broker.util.FileUtils;
import com.toda.broker.util.Iconfig;
import com.toda.broker.util.ImageUtils;

import java.io.File;

import io.rong.imageloader.cache.disc.impl.UnlimitedDiskCache;
import io.rong.imageloader.cache.disc.naming.Md5FileNameGenerator;
import io.rong.imageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.ImageLoaderConfiguration;
import io.rong.imageloader.core.assist.QueueProcessingType;
import io.rong.imkit.RongIM;

/**
 * Created by guugangzhu on 2016/9/23.
 */

public class BrokerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
        initImageLoader(getApplicationContext());
    }

    public static void initImageLoader(Context context) {
        File dir = new File(FileUtils.getFilePath(Iconfig.IMAGE_CACHE));
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                .denyCacheImageMultipleSizesInMemory().diskCache(new UnlimitedDiskCache(dir))
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(ImageUtils.getDisplayImageOptions())
                .build();
        ImageLoader.getInstance().init(config);
    }
}
