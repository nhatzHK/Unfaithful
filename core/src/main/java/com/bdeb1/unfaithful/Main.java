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

import com.badlogic.ashley.core.PooledEngine;
import screens.MainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author Soheib El-Harrache
 */
public class Main extends Game {
    
    public SpriteBatch sb;
    public ShapeRenderer sp;
    public OrthographicCamera cam;
    
    private World world;
    private PooledEngine engine;

    @Override
    public void create() {
        sb = new SpriteBatch();
        sp = new ShapeRenderer();
        Assets.getInstance().load();
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1200, 800);
        //Settings.load();
        
        setScreen(new MainMenu(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        sb.dispose();
        sp.dispose();
        Assets.getInstance().dispose();
    }
    
    
}