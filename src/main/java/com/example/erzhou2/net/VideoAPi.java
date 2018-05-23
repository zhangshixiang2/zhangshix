package com.example.erzhou2.net;



import com.example.erzhou2.bean.VideoBean;

import io.reactivex.Observable;



public class VideoAPi {
    private static VideoAPi videoAPi;
    private VideoAPiService videoAPiService;


    private VideoAPi(VideoAPiService videoAPiService) {

        this.videoAPiService = videoAPiService;
    }


    public static VideoAPi getVideoAPi(VideoAPiService videoAPiService) {
        if (videoAPi == null) {
            videoAPi = new VideoAPi(videoAPiService);
        }
        return videoAPi;
    }


    public Observable<VideoBean> getVideo() {
        return videoAPiService.getVideo();
    }
}
