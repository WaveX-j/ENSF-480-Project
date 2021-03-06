package Model;
import java.util.*;
public class Search  {
    private String type;
    private double bed;
    private double bath;
    private int furn;
    private int unfurn;
    private String quad;
    private ImportData datab;
    private List<Property> properties;
    private List<SearchCriteria> criteria;


    public void updateLists(){
        //datab.update();
        properties = datab.getProperties();
        criteria = datab.getSearches();
    }
    public Search(ImportData d){
        datab = d;
    }

    /*
     *  The function will iterate the properties and check for matching search criteria
     *  @param idRenter  to check which search criteria the renter associates with
     *  @return returns a list of property id strings that matches the search criteria
     *          returns null otherwise
     *
     */

    public List<String> doSearch(String idRenter){
    updateLists();
        List<String> temp = new ArrayList<>();
        if(!criteria.contains(idRenter)){
            throw new RuntimeException("idRenter not found");
        }

        SearchCriteria search = criteria.get(criteria.indexOf(idRenter));

        this.type = search.getApartmentType();
        this.bed = search.getNoOfBedrooms();
        this.bath = search.getNoOfBathrooms();
        this.furn = search.getFurnished();
        this.unfurn = search.getUnfurnished();
        this.quad = search.getCityQuadrant();
        for(Property p : properties){//iterate each property
            //essentially if a criteria is not matching, we immediately move to the next iteration
            // making sure the 'any' criteria is also not selected.
            //if all the criteria matches, then we will add the property id to the temp list
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else temp.add(p.getIdProperty());
        }

        if(temp.size() != 0) return temp;
        else return null;

    }

    /*This function will check if a property exists based on property criteria
    * All the param will be the search criteria for a property
    * @return true if property with given criteria exists, false otherwise
     */
    public boolean checkPropertyCriteria(String apartmentType, double noOfBedrooms,
                                         double noOfBathrooms, int furnished,
                                         int unfurnished, String cityQuadrant
                                          ) {

        updateLists();
        this.type = apartmentType;
        this.bed = noOfBedrooms;
        this.bath = noOfBathrooms;
        this.furn = furnished;
        this.unfurn = unfurnished;
        this.quad = cityQuadrant;

        for(Property p : properties){//iterate each property
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else return true;
        }
    return false;
    }

    public boolean checkPropertySearchCriteria(SearchCriteria s){//hmmm gotta check
        updateLists();
        this.type = s.getApartmentType();
        this.bed = s.getNoOfBedrooms();
        this.bath = s.getNoOfBathrooms();
        this.furn = s.getFurnished();
        this.unfurn = s.getUnfurnished();
        this.quad = s.getCityQuadrant();

        for(Property p : properties){
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else return true;
        }
        return false;


    }






}
