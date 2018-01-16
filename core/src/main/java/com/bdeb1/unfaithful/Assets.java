/*
 * Copyright 2018 Soheib El-Harrache.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bdeb1.unfaithful;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Soheib El-Harrache
 */
public class Assets {
    public AssetManager manager;

    private static Assets instance = null;

    private Assets() {
        manager = new AssetManager();
    }

    public static Assets getInstance() {
        if (instance == null) {
            instance = new Assets();
        }
        return instance;
    }
    
    //------------------------SPRITES
    public static final AssetDescriptor<Texture> SPRITE_NAME
            = new AssetDescriptor<Texture>(
                    "sprite/exemple_sprite.png", Texture.class);
    
    //------------------------IMAGES
    public static final AssetDescriptor<Texture> IMAGE_NAME
            = new AssetDescriptor<Texture>(
                    "image/exemple_image.png", Texture.class);
    
    //------------------------SOUNDS
    public static final AssetDescriptor<Sound> SOUND_NAME
            = new AssetDescriptor<Sound>(
                    "sound/exemple_sound.ogg", Sound.class);
    
    //------------------------MUSICS
    public static final AssetDescriptor<Music> MUSIC_NAME
            = new AssetDescriptor<Music>(
                    "music/exemple_music.ogg", Music.class);
    
    /**
     * Loads assets.
     */
    public void load() {
        //Sprites
        manager.load(SPRITE_NAME);

        //Images
        manager.load(IMAGE_NAME);

        //Sounds
        manager.load(SOUND_NAME);

        //Musics
        manager.load(MUSIC_NAME);

        //Font
//        manager.load(font_pixel);
    }
    
    /**
     * Disposes the manager.
     */
    public void dispose() {
        manager.dispose();
    }
}