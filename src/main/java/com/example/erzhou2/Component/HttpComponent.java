package com.example.erzhou2.Component;



import com.example.erzhou2.Module.HttpModule;
import com.example.erzhou2.ui.Potho.PothoFragment;
import com.example.erzhou2.ui.Video.VideoFragment;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(PothoFragment pothoFragment);
    void inject(VideoFragment videoFragment);
}
