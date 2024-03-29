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
package com.bdeb1.unfaithful.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Soheib El-Harrache
 */
public class ActionComponent implements Component {

    public int action = 0;
    public float time = 0.0f;

    public int get() {
        return action;
    }

    public void set(int newAction) {
        action = newAction;
        if(newAction != action) {
            time = 0.0f;
        }
    }
}
