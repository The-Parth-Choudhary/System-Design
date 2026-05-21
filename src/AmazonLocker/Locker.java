package AmazonLocker;

import java.util.Map;

public class Locker {
    private Compartment[] compartments;
    private Map<String, AccessToken> accessTokenMap;

    public String depositPackage(Size size){
        Compartment compartment = getAvailableCompartment(size);

        if (compartment == null){
            throw new Error("No available compartment of size " + size);
        }

        compartment.open();
        compartment.markOccupied();

        AccessToken accessToken = generateAccessToken(compartment);
        String code = accessToken.getCode();
        accessTokenMap.put(code, accessToken);

        return code;
    }

    public void pickup(String code){
        if (code.isEmpty()){
            throw new Error("Invalid code");
        }

        if (!accessTokenMap.containsKey(code)){
            throw new Error("Invalid code");
        }

        AccessToken accessToken = accessTokenMap.get(code);

        if (accessToken.isExpired()){
            throw new Error("Access code is expired");
        }

        Compartment compartment = accessToken.getCompartment();
        compartment.open();
        compartment.markFree();
        accessTokenMap.remove(code);
    }

    public void openExpiredCompartment(){
        for (Map.Entry<String, AccessToken> entry : accessTokenMap.entrySet()){
            String code = entry.getKey();
            AccessToken accessToken = entry.getValue();

            if (accessToken.isExpired()){
                Compartment compartment = accessToken.getCompartment();
                compartment.open();
                compartment.markFree();
            }
        }
    }

    private Compartment getAvailableCompartment(Size size) {
        for (Compartment compartment : compartments){
            if (compartment.getSize() == size && !compartment.isOccupied()){
                return compartment;
            }
        }

        return null;
    }

    private AccessToken generateAccessToken(Compartment compartment) {

        return new AccessToken();
    }
}
