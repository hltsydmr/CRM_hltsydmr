import java.util.*;
import javax.faces.bean.*;

@ManagedBean
public class AccessList {
	
	public String key;
	public String idd;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getIdd() {
		return idd;
	}

	public void setidd(String idd) {
		Operations o = new Operations();
		o.getCustomer(idd);
		this.idd = idd;
	}

	public List<Customer> getacclist(){
		Operations o = new Operations();
		return o.listCustomers();	
	}
	
	public List<Customer> getfindlist(){
		Operations o = new Operations();
		return o.findCustomer(getKey());
	}
	
	public String accshow(){
		return "listCustomers";
	}
	
	public Customer getcst(String id){
		Operations o = new Operations();
		return o.getCustomer(id);
	}
}
