/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author java
 */
public class BrokerDelegate {
    private static final BrokerDelegate BROKER_DELEGATE;
    
    //private BrokerModel model = BrokerModelImpl.getInstance();
    
    private Context context;
    
    static {
        BROKER_DELEGATE = new BrokerDelegate();
    }
    
    public static BrokerDelegate getInstance() {
        return BROKER_DELEGATE;
    }
    
    private BrokerDelegate() {
        try {
            context = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(BrokerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private synchronized BrokerModel getModel() {
        try {
            return (BrokerModel) context.lookup("java:comp/env/BrokerLookup");
        } catch (NamingException ex) {
            Logger.getLogger(BrokerDelegate.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Customer addCustomer(String customerId, String name, String address) throws BrokerException {
        Customer customer = new Customer(customerId, name, address);
        getModel().addCustomer(customer);
        return customer;
    }

    public Customer getCustomer(String customerId) throws BrokerException {
        return getModel().getCustomer(customerId);
    }

    public Customer updateCustomer(String customerId, String name, String address) throws BrokerException {
        Customer customer = new Customer(customerId, name, address);
        getModel().updateCustomer(customer);
        
        return getModel().getCustomer(customerId);
    }
    
    public void deleteCustomer(String customerId) throws BrokerException {
        Customer customer = getModel().getCustomer(customerId);
        getModel().deleteCustomer(customer);
    }

    public Customer[] getAllCustomers() throws BrokerException {
        return getModel().getAllCustomers();
    }
   
    public Stock getStock(String symbol) throws BrokerException {
        return getModel().getStock(symbol);
    }
    
    public Stock[] getAllStocks() throws BrokerException {
        return getModel().getAllStocks();
    }
        
    public CustomerShare addCustomerShare(String customerId, String stockSymbol, int quantity) throws BrokerException {
        CustomerShare share = new CustomerShare(customerId, stockSymbol, quantity);
        getModel().addCustomerShare(share);
        return share;
    }

    public CustomerShare updateCustomerShare(String customerId, String stockSymbol, int quantity) throws BrokerException {
        CustomerShare share = new CustomerShare(customerId, stockSymbol, quantity);
        getModel().updateCustomerShare(share);
        return share;
    }
             
    public CustomerShare[] getAllCustomerShares(String customerId) throws BrokerException {
        return getModel().getAllCustomerShares(customerId);
    }
}
