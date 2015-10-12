import javax.faces.bean.*;

@ManagedBean
@ApplicationScoped

public class Customer {

	public String name;
	public String surname;
	public String company;
	public String department;
	public String position;
	public String phone;
	public String email;
	public String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Customer(){
	
	}
	
	public Customer(String name,String surname, String company, String department, String position, String phone, String email){
		this.name = name;
		this.surname = surname;
		this.company = company;
		this.department = department;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}
	public Customer(String id,String name,String surname, String company, String department, String position, String phone, String email){
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.company = company;
		this.department = department;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}
	
	public String add(){
		Operations o = new Operations();
		o.addCustomer(this);
		return "successAdded";
	}
	
	public String list(){
		Operations o = new Operations();
		o.listCustomers();
		return "listCustomers";
	}
	
	public String edit(){
		Operations o = new Operations();
		Customer c= o.getCustomer(id);
		this.id=c.id;
		this.name=c.name;
		this.surname=c.surname;
		this.company=c.company;
		this.department=c.department;
		this.position=c.position;
		this.phone=c.phone;
		this.email=c.email;
		return "editCustomer";
	}
	
	public String makeEdit(){
		delete();
		add();
		return "editedCustomer";
	}
	
	public String delete(){
		Operations o = new Operations();
		o.delete(id);
		return "deletedCustomer";
	}
	
}
