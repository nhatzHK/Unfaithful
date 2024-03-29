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
package com.bdeb1.unfaithful.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bdeb1.unfaithful.components.ActionComponent;
import com.bdeb1.unfaithful.components.ComptoirComponent;
import com.bdeb1.unfaithful.components.HackerComponent;
import com.bdeb1.unfaithful.components.LaptopComponent;
import com.bdeb1.unfaithful.components.TargetComponent;
import com.bdeb1.unfaithful.components.TextureComponent;
import com.bdeb1.unfaithful.components.TransformComponent;
import com.bdeb1.unfaithful.util.Constants;

/**
 * @author Soheib El-Harrache
 */
public class RenderingSystem extends IteratingSystem {

    //A REVOIR
    static final float PPM = 16.0f;
    public static final float PIXELS_TO_METRES = 1.0f / PPM;
    static final float FRUSTUM_WIDTH = Gdx.graphics.getWidth()
            / PPM;
    //37.5f;
    static final float FRUSTUM_HEIGHT = Gdx.graphics.getHeight()
            / PPM;//.0f;
    private SpriteBatch batch;
    private OrthographicCamera cam;

    private ComponentMapper<TextureComponent> textureM;
    private ComponentMapper<TransformComponent> transformM;

    {
        System.out.println("NOT RENDERING THIS (NOT TARGET THO) ");
    }

    {
        //			System.out.println ("Ton menu boi");
    }

    public RenderingSystem(SpriteBatch batch) {
        super(Family.all(TransformComponent.class, TextureComponent.class)
                .get());
        this.batch = batch;

        textureM = ComponentMapper.getFor(TextureComponent.class);
        transformM = ComponentMapper.getFor(TransformComponent.class);

        cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
        cam.position.set(FRUSTUM_WIDTH / 2f, FRUSTUM_HEIGHT / 2f, 0);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.enableBlending();
    }

    @Override
    protected void processEntity(Entity entity, float f) {
        TextureComponent tex = textureM.get(entity);
        TransformComponent t = transformM.get(entity);

        if (!(tex.region == null || t.isHidden)) {

            float width = tex.region.getRegionWidth();
            float height = tex.region.getRegionHeight();

            batch.begin();

            if (entity.getComponent(HackerComponent.class) != null) {
                batch.draw(tex.region, t.position.x, t.position.y,
                        width * Constants.World.SCALE,
                        height * Constants.World.SCALE);
            } else if (entity.getComponent(TargetComponent.class) != null) {
                ActionComponent actionC = ComponentMapper
                        .getFor(ActionComponent.class).get(entity);
                if (actionC.action == TargetComponent.ACTION_WALK_RIGHT) {
                    width = width * - 1;
                }
                batch.draw(tex.region, t.position.x, t.position.y,
                        width * Constants.World.SCALE,
                        height * Constants.World.SCALE);
            } else if (entity.getComponent(LaptopComponent.class) != null) {
                batch.draw(tex.region, t.position.x, t.position.y,
                        width * Constants.World.SCALE,
                        height * Constants.World.SCALE);
            } else if (entity.getComponent(ComptoirComponent.class) != null) {
                batch.draw(tex.region, 0, 0,
                        Constants.World.SCENE_DIMENSION.width,
                        Constants.World.SCENE_DIMENSION.height);
            } else {
                //                batch.draw(tex.region, t.position.x -
                // originX,
                //                        t.position.y - originY, originX,
                // originY, width,
                //                        height, PixelsToMeters(t.scale.x),
                //                        PixelsToMeters(t.scale.y), t
                // .rotation);
                batch.draw(tex.region, t.position.x, t.position.y,
                        width * Constants.World.SCALE,
                        Constants.World.SCALE);
            }

            batch.end();
        }
    }
}
