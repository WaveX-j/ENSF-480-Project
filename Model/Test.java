package Model;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {

        ImportData testData =  new ImportData("jdbc:mysql://127.0.0.1:3306/Online_Rental",
                "root","root");

//        List<Landlord> landList = testData.getLandlords();
//
//        for(int i=0;i<landList.size();i++){
//            System.out.println(landList.get(i).getIdLandlord()+" "+landList.get(i).getName()+" "+
//                    landList.get(i).getUsername()+" "+landList.get(i).getPassword());
//            System.out.println();
//        }

        // BELOW IS SHOWN HOW YOU USE setStatus METHOD FOR PROPERTIES

        //Update.setStatus("jdbc:mysql://127.0.0.1:3306/Online_Rental","root","root","prop06","Cancelled");

        // BELOW IS SHOWN HOW YOU USE setSubscribeOn METHOD FOR PROPERTIES SAME IS HOW YOU USE setSubscribeOff

        //Update.setSubscribeOn("jdbc:mysql://127.0.0.1:3306/Online_Rental","root","root","NiTSs05");

//        List<SearchCriteria> search = testData.getSearches();
//
//        System.out.println(search.get(2).getIdRenter());
//
//        String str[]={"Rt7y48","Wilkson","Wkou45","somepass"};
//
//        Update.landlordAdd("jdbc:mysql://127.0.0.1:3306/Online_Rental",
//                "root","root",str);



    }
}
