/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Directories;


import Model.TransportAgency.TransportAgency;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author samik
 */
public class TransportAgencyDirectory {
    private ArrayList<TransportAgency>transportAgencyList;
    
    public TransportAgencyDirectory(){
        this.transportAgencyList = new ArrayList<TransportAgency>();
    }
        
    public ArrayList<TransportAgency> getTransporAgencyList() {
        return transportAgencyList;
    }

    public void setTransporAgencyList(ArrayList<TransportAgency>travelAgencyList) {
        this.transportAgencyList = travelAgencyList;
    }
   
    public TransportAgency addTransporAgency(String businessName, String businessDescription, Map<String, String> loginCredentials, String headquarter, String ownerName, String ownerPhone, String ownerEmail, String type, ImageIcon logoImage, String mode){
       TransportAgency localBusiness = new TransportAgency( businessName,  businessDescription,  loginCredentials,  headquarter,  ownerName,  ownerPhone,  ownerEmail,  type,  logoImage, mode);
       transportAgencyList.add(localBusiness);
       return localBusiness;
   } 
     
    public void deleteTransporAgency(TransportAgency travelAgency){
       transportAgencyList.remove(travelAgency);
    }    
}
