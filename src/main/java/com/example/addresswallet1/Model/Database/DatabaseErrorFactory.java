package com.example.addresswallet1.Model.Database;

import com.example.addresswallet1.Model.API.APIResponse;
import org.springframework.http.HttpStatus;

public class DatabaseErrorFactory {
    //TODO: How should this be instantiated? Singleton?
    private static DatabaseErrorFactory databaseErrorFactory;

    public static DatabaseErrorFactory getInstance() {
        if (databaseErrorFactory == null) databaseErrorFactory = new DatabaseErrorFactory();
        return databaseErrorFactory;
    }

    public APIResponse getAPIResponseFromDatabaseError(DatabaseError databaseError) {
        //TODO: would this be easier to hold in a hashmap?
        APIResponse toReturn = new APIResponse();
        switch (databaseError.getErrorCode()) {
            case -1:
                toReturn.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                toReturn.setErrorDescription("Username already exists");
                break;
            case 0:
                break;
            default:
                //generic error here
                toReturn.setHttpStatus(HttpStatus.OK);
                toReturn.setErrorDescription("User has been created");
                break;
        }
        return toReturn;
    }

}
