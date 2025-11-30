import com.example.customerlist.entity.Customer;
import com.example.customerlist.service.CustomerService;

public class testcontroller {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        for(Customer customer : customerService.customerList()){
            System.out.println("ID: " + customer.getId() +
                    ", Name: " + customer.getName() );
        }
    }
}
