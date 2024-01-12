/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.TransportAgency.Route;
import Model.TransportAgency.TransportAgency;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class TravelConfigure {

    public static Travel initialize() {
        Travel travel = new Travel("Travel Swift");
        
        Route route = new Route();
        route.setCapacity("100");
        route.setEndLocation("London");
        route.setStartLocation("India");
        route.setPlaneName("Plan 1");
        route.setPrice(1000);
        route.setRouteId("1");
        
        ArrayList<Route> routes= new ArrayList<>();
        routes.add(route);
        
        Map<String, String> loginCredentials = new LinkedHashMap<>();
        loginCredentials.put("british", "British@123");
        ImageIcon icon = new ImageIcon("path/to/your/image.png");
        TransportAgency transportAgency = travel.getTrnsportAgencyDirectory().addTransporAgency("British", "Airlines",loginCredentials , "London", "Samiksha", "(481) 506-3028", "sam@gmail.com", "Transport Agency", icon, "Air");
        transportAgency.setRoutes(routes);
        
        Map<String, String> loginCredentials1 = new LinkedHashMap<>();
        travel.getCustomerDirectory().addCustomer("kk", "kk", "kk", "kk", "kk");
        loginCredentials1.put("sambar", "Sam@123");
        travel.getHotelDirectory().addHodel("samiksha", "hotel", loginCredentials1, "London", "Samiksha", "(481) 506-3028", "sam@gmail.com", "Hotel", icon);
        
        Map<String, String> loginCredentials2 = new LinkedHashMap<>();
        loginCredentials2.put("adwait", "Adi@123");
        travel.getLocalBusinessDirectory().addLocalBusiness("adwait", "local business", loginCredentials2, "usa", "adwait", "(481) 506-3028", "adi@gmail.com", "Local Business", icon);
        
        Map<String, String> loginCredentials3 = new LinkedHashMap<>();
        loginCredentials3.put("chinmay", "Chi@123");
        travel.getTravelAgencyDirectory().addTravelAgency("chinmay", "travel agency", loginCredentials3, "usa", "chinmay", "(481) 506-3028", "chi@gmail.com", "Travel Agency", icon);
        

        
        return travel;
    }
}
