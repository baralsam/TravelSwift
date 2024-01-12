/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.EnterpriseAdmin.Roles.ApplicationAdmin;
import Model.EnterpriseAdmin.Roles.FinancialManager;
import Model.EnterpriseAdmin.Roles.GovernmentBoardManager;
import Model.EnterpriseAdmin.Roles.HumanResourceManager;
import Model.EnterpriseAdmin.Roles.TransportationBoardManager;
import Model.EnterpriseAdmin.Roles.VerificationAuthority;
import Model.Directories.CustomerDirectory;
import Model.Directories.HotelDirectory;
import Model.Financial.ForexFinance;
import Model.Directories.LocalBusinessDirectory;
import Model.Directories.TransportAgencyDirectory;
import Model.Directories.TravelAgencyDirectory;


import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ASUS
 */
public class Travel {

    private String name;
    private ApplicationAdmin appAdmin;
    private GovernmentBoardManager govBoaAdmin;
    private TransportationBoardManager traBoaAdmin;
    private VerificationAuthority verAuthAdmin;
    private FinancialManager finManAdmin;
    private HumanResourceManager humResAdmin;
    private CustomerDirectory customerDirectory;
    private HotelDirectory hotelDirectory;
    private ForexFinance forexFinance;
    private LocalBusinessDirectory localBusinessDirectory;
    private TransportAgencyDirectory transportAgencyDirectory;
    private TravelAgencyDirectory travelAgencyDirectory;

    //private 
    String salt = BCrypt.gensalt();

    public Travel(String name) {
        String cPassword = BCrypt.hashpw("Admin@23", salt);
        this.appAdmin = new ApplicationAdmin("Admin", cPassword, "Application Admin");
        cPassword = BCrypt.hashpw("GovPersonnel@23", salt);
        this.govBoaAdmin = new GovernmentBoardManager("GovPersonnel", cPassword, "Government Personnel");
        cPassword = BCrypt.hashpw("TraPersonnel@23", salt);
        this.traBoaAdmin = new TransportationBoardManager("TraPersonnel", cPassword, "Transportation Board Personnel");
        cPassword = BCrypt.hashpw("VerAuthority@23", salt);
        this.verAuthAdmin = new VerificationAuthority("VerAuthority", cPassword, "Verification Authority");
        cPassword = BCrypt.hashpw("FinManager@23", salt);
        this.finManAdmin = new FinancialManager("FinManager", cPassword, "Financial Manager");
        cPassword = BCrypt.hashpw("HumResource@23", salt);
        this.humResAdmin = new HumanResourceManager("HumResource",cPassword,"Human Resource");
        this.forexFinance = new ForexFinance(0.1,0.2,0.2,0.3);
        this.customerDirectory = new CustomerDirectory();
        this.hotelDirectory = new HotelDirectory();
        this.localBusinessDirectory = new LocalBusinessDirectory();
        this.transportAgencyDirectory = new TransportAgencyDirectory();
        this.travelAgencyDirectory = new TravelAgencyDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationAdmin getAppAdmin() {
        return appAdmin;
    }

    public void setAppAdmin(ApplicationAdmin appAdmin) {
        this.appAdmin = appAdmin;
    }

    public GovernmentBoardManager getGovBoaAdmin() {
        return govBoaAdmin;
    }

    public void setGovBoaAdmin(GovernmentBoardManager govBoaAdmin) {
        this.govBoaAdmin = govBoaAdmin;
    }

    public TransportationBoardManager getTraBoaAdmin() {
        return traBoaAdmin;
    }

    public void setTraBoaAdmin(TransportationBoardManager traBoaAdmin) {
        this.traBoaAdmin = traBoaAdmin;
    }

    public VerificationAuthority getVerAuthAdmin() {
        return verAuthAdmin;
    }

    public void setVerAuthAdmin(VerificationAuthority verAuthAdmin) {
        this.verAuthAdmin = verAuthAdmin;
    }

    public FinancialManager getFinManAdmin() {
        return finManAdmin;
    }

    public void setFinManAdmin(FinancialManager finManAdmin) {
        this.finManAdmin = finManAdmin;
    }

    public HumanResourceManager getHumResAdmin() {
        return humResAdmin;
    }

    public void setHumResAdmin(HumanResourceManager humResAdmin) {
        this.humResAdmin = humResAdmin;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public HotelDirectory getHotelDirectory() {
        return hotelDirectory;
    }

    public ForexFinance getForexFinance() {
        return forexFinance;
    }

    public void setForexFinance(ForexFinance forexFinance) {
        this.forexFinance = forexFinance;
    }
                
    public LocalBusinessDirectory getLocalBusinessDirectory() {
        return localBusinessDirectory;
    }
    
        public TransportAgencyDirectory getTrnsportAgencyDirectory() {
        return transportAgencyDirectory;
    }

    public TravelAgencyDirectory getTravelAgencyDirectory() {
        return travelAgencyDirectory;
    }   

}
