/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.example.msf4j.petstore.util;

import org.example.msf4j.petstore.model.Pet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Contains utility methods access the Pet storage
 */
public class PetStoreUtils {

    private static Map<String, Pet> storage = new HashMap<>();

    static {
        Pet pet = new Pet();
        pet.setId("pet001");
        pet.setAgeMonths(12);
        pet.setPrice(100f);
        pet.setDetails("FirstPet");
        pet.setImage("image-001.jpg");
        storage.put("pet001", pet);
    }

    public static Optional<Pet> getPet(String id) {
        if (storage.containsKey(id)) {
            return Optional.of(storage.get(id));
        }
        return Optional.empty();
    }

    public static void addPet(Pet pet) {
        storage.put(pet.getId(), pet);
    }
}
