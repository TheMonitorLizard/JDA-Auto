/*
 * Copyright 2017 Kaidan Gustave
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.kgustave.jdagen.autologin.subprocessors;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * @author Kaidan Gustave
 */
public class ListenerProcessor extends LoginSubProcessor
{
    public ListenerProcessor(Elements elements, Types types)
    {
        super(elements, types);
    }

    @Override
    public Element process(ExecutableElement element)
    {
        if(element.getReturnType().getKind() == TypeKind.ARRAY ||
           types.isSubtype(element.getReturnType(),
               elements.getTypeElement(Iterable.class.getCanonicalName()).asType()))
        {
            return element;
        }

        return null;
    }
}
