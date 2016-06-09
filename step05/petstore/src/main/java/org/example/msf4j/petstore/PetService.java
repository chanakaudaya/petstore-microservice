/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.msf4j.petstore;

import org.example.msf4j.petstore.exception.DuplicatePetException;
import org.example.msf4j.petstore.exception.PetNotFoundException;
import org.example.msf4j.petstore.model.Pet;
import org.example.msf4j.petstore.util.PetStoreUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/pet")
public class PetService {

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getPet(@PathParam("id") String id) throws PetNotFoundException {
        Optional<Pet> petOptional = PetStoreUtils.getPet(id);
        if(petOptional.isPresent()) {
            return Response.status(Response.Status.OK).entity(petOptional.get()).build();
        }

        throw new PetNotFoundException("Pet " + id + " not found");
    }

    @POST
    @Consumes("application/json")
    public Response addPet(Pet pet) throws DuplicatePetException {
        if (PetStoreUtils.getPet(pet.getId()).isPresent()) {
            throw new DuplicatePetException("Pet " + pet.getId() + " already exists");
        }

        PetStoreUtils.addPet(pet);
        return Response.status(Response.Status.OK).entity("Pet with ID " +
                pet.getId() + " successfully added").build();
    }

    @PUT
    @Consumes("application/json")
    public Response updatePet(Pet pet) throws PetNotFoundException {
        if (!PetStoreUtils.getPet(pet.getId()).isPresent()) {
            throw new PetNotFoundException("Pet " + pet.getId() + " not found");
        }

        PetStoreUtils.addPet(pet);
        return Response.status(Response.Status.OK).entity("Pet with ID " + pet.getId() +
                " successfully updated").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePet(@PathParam("id") String id) throws PetNotFoundException {
        if (!PetStoreUtils.getPet(id).isPresent()) {
            throw new PetNotFoundException("Pet " + id + " not found");
        }

        PetStoreUtils.deletePet(id);
        return Response.status(Response.Status.OK).entity("Pet with ID " + id + " successfully deleted  ").build();
    }
}
