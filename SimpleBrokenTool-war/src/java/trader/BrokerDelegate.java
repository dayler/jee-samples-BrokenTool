/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

/**
 *
 * @author java
 */
public class BrokerDelegate {
    private static final BrokerDelegate BROKER_DELEGATE;
    
    private BrokerModel model = BrokerModelImpl.getInstance();
    
    static {
        BROKER_DELEGATE = new BrokerDelegate();
    }
    
    public static BrokerDelegate getInstance() {
        return BROKER_DELEGATE;
    }
    
    private BrokerDelegate() {}

    public Customer addCustomer(String customerId, String name, String address) throws BrokerException {
        Customer customer = new Customer(customerId, name, address);
        model.addCustomer(customer);
        return customer;
    }

    public Customer getCustomer(String customerId) throws BrokerException {
        return model.getCustomer(customerId);
    }

    public Customer updateCustomer(String customerId, String name, String address) throws BrokerException {
        Customer customer = new Customer(customerId, name, address);
        model.updateCustomer(customer);
        
        return model.getCustomer(customerId);
    }
    
    public void deleteCustomer(String customerId) throws BrokerException {
        Customer customer = model.getCustomer(customerId);
        model.deleteCustomer(customer);
    }

    public Customer[] getAllCustomers() throws BrokerException {
        return model.getAllCustomers();
    }
   
    public Stock getStock(String symbol) throws BrokerException {
        return model.getStock(symbol);
    }
    
    public Stock[] getAllStocks() throws BrokerException {
        return model.getAllStocks();
    }
        
    public CustomerShare addCustomerShare(String customerId, String stockSymbol, int quantity) throws BrokerException {
        CustomerShare share = new CustomerShare(customerId, stockSymbol, quantity);
        model.addCustomerShare(share);
        return share;
    }

    public CustomerShare updateCustomerShare(String customerId, String stockSymbol, int quantity) throws BrokerException {
        CustomerShare share = new CustomerShare(customerId, stockSymbol, quantity);
        model.updateCustomerShare(share);
        return share;
    }
             
    public CustomerShare[] getAllCustomerShares(String customerId) throws BrokerException {
        return model.getAllCustomerShares(customerId);
    }
}
