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

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.soheibo.template.components.AnimationComponent;
import com.soheibo.template.components.CharacterComponent;
import com.soheibo.template.components.StateComponent;
import com.soheibo.template.components.TextureComponent;
import com.soheibo.template.components.TransformComponent;

/**
 *
 * @author Soheib El-Harrache
 */
public class GameWorld {

    private PooledEngine engine;

    public GameWorld(PooledEngine engine) {
        this.engine = engine;
        createCharacter();
        generateLevel();
    }

    private void generateLevel() {

    }

    private void createCharacter() {
        Entity entity = engine.createEntity();

        AnimationComponent animC
                = engine.createComponent(AnimationComponent.class);
        CharacterComponent charC
                = engine.createComponent(CharacterComponent.class);
        TransformComponent positionC
                = engine.createComponent(TransformComponent.class);
        StateComponent stateC
                = engine.createComponent(StateComponent.class);
        TextureComponent textureC
                = engine.createComponent(TextureComponent.class);

//        animC.animations.put(CharacterComponent.STATE_ALIVE, Assets.uneAnim);
//        animC.animations.put(CharacterComponent.STATE_DEAD, Assets.uneAnim);
//        animC.animations.put(CharacterComponent.STATE_FRENZY, Assets.uneAnim);

        positionC.position.set(5.0f, 1.0f, 0.0f);

        stateC.set(CharacterComponent.STATE_ALIVE);

        entity.add(animC);
        entity.add(charC);
        entity.add(positionC);
        entity.add(stateC);
        entity.add(textureC);

        engine.addEntity(entity);
    }
}