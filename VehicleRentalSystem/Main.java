import java.util.*;
public class Main {	
	static Scanner sc=new Scanner(System.in);
	static HashMap<String,User> user=new HashMap<>();
	static HashMap<String,Vehicle> vehicle=new HashMap<>();
	static String current=null;

	public static void main(String[] args) {
		while(true) {
			System.out.println("1. SignUp\n2. SignIn\n3. Exit");
			int auth=Integer.parseInt(sc.nextLine());
			switch(auth) {
				case 1->signUp();
                case 2-> signIn();
                case 3-> {
                    break;
                }
                default->{
                    System.out.println("Invalid choice");
                }
			}
		}
	}
	
	public static void signUp() {
		System.out.println("Enter your email:");
		String email=sc.nextLine();
		System.out.println("Enter your password:");
		String password=sc.nextLine();
		System.out.println("Enter your role (Admin/Borrower):");
		String role=sc.nextLine();
		
		user.put(email, new User(email,password,role));
		System.out.println("SignUp Completed!");
	}
	
	public static void signIn() {
		System.out.println("Enter your email:");
		String email=sc.nextLine();
		System.out.println("Enter your password:");
		String pass=sc.nextLine();
		
		if(user.containsKey(email) && user.get(email).password.equals(pass)) {
			System.out.println("Login Successful!");
			current=email;
			if(user.get(email).role.equalsIgnoreCase("admin")) {
				adminMenu();
			}
			else{
				borrowerMenu();
			}
		}
		else {
			
			System.out.println("Invalid Credentials!");
		}
	}
	
	public static void adminMenu() {
		System.out.println("Welcome to adminMenu "+current);
		System.out.println("1.Add Vehicle\n2. Modify Vehicle\n3. Delete Vehicle\n4. Search Vehicle\n5. View All Vehicle\n6.Change Vehicle Deposit \n7. View Report\n8. Logout");
		int choice=Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1-> addVehicle() ;
            case 2->modifyVehicle();
            case 3->deleteVehicle(); 
            case 4-> searchVehicle();
            case 5-> viewAll();
            case 6->changeDeposit();
            case 7-> viewReport();

            case 8->{ 
                current=null;
			    return;
            }
            default-> {
                System.out.println("Invalid choice");
            }
        }
	}
	
	public static void addVehicle() {
		System.out.println("Enter vehicle ID:");
		String id=sc.nextLine();
		System.out.println("Enter vehicle Name:");
		String name=sc.nextLine();
		System.out.println("Enter vehicle type:");
		String type=sc.nextLine();
		System.out.println("Enter the count:");
		int count=Integer.parseInt(sc.nextLine());
		System.out.println("Enter rent price:");
		double rentPrice=Double.parseDouble(sc.nextLine());
		System.out.println("Enter deposit:");
		double deposit=(type.equalsIgnoreCase("car"))?10000:3000;
		System.out.println("Enter KM:");
		double km=Double.parseDouble(sc.nextLine());
		vehicle.put(id,new Vehicle(id, name, type, count, rentPrice, deposit, km));
		System.out.println("Vehicle Added Successfully!");
	}
	public static void modifyVehicle() {
		System.out.println("Enter the vehicle ID to be modify:");
		String id=sc.nextLine();
		if(!vehicle.containsKey(id)) {
			System.out.println("Vehicle not found!");
			return;
		}
		System.out.println("Enter new count:");
		vehicle.get(id).count=Integer.parseInt(sc.nextLine());
		System.out.println("Modified Successfully!");
	}
	public static void deleteVehicle() {
		System.out.println("Enter the vehicle ID to be deleted:");
		String id=sc.nextLine();
		vehicle.remove(id);
		System.out.println("Vehicle removed!");
	}
	public static void searchVehicle() {
		System.out.println("Enter the vehicle (name/ID) to be search:");
		String search=sc.nextLine().toLowerCase();
		
		for(Vehicle i:vehicle.values()) {
			if(i.name.toLowerCase().contains(search) || i.id.toLowerCase().contains(search)) {
				System.out.println(i.id+" | "+i.name+" | "+i.type+" | "+i.rentPrice+" | "+i.count);
			}
		}
		System.out.println("Vehicle not found");
	}
	public static void viewAll() {
        System.out.println("Choose sorting option:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Available Count");
        System.out.println("3. View All Without Sorting");

        int choice = Integer.parseInt(sc.nextLine());
        List<Vehicle> list = new ArrayList<>(vehicle.values());

        if (choice == 1) {
            list.sort(Comparator.comparing(v -> v.name.toLowerCase()));
        }
        else if (choice == 2) {
            list.sort(Comparator.comparingInt(v -> v.count));
        }

        System.out.println("ID | Name | Type | RentPrice | Count | Serviced");
        for (Vehicle v : list) {
            System.out.println(v.id + " | " + v.name + " | " + v.type + " | " + v.rentPrice + " | " + v.count + " | " + v.serviced);
        }
    }
    public static void changeDeposit() {
        System.out.println("Enter vehicle ID to change deposit:");
        String id = sc.nextLine();
        
        if (!vehicle.containsKey(id)) {
            System.out.println("Vehicle not found!");
            return;
        }

        System.out.println("Enter new deposit amount:");
        double newDeposit = Double.parseDouble(sc.nextLine());

        vehicle.get(id).deposit = newDeposit;
        System.out.println("Deposit updated successfully!");
    }


	
	public static void borrowerMenu() {
		while(true) {
			System.out.println("Borrower Menu:");
			System.out.println("1. View Available vehicle\n2. Rent vehicle\n3. Return vehicle\n4. Previous Rentals\n5. Logout");
			int ch=Integer.parseInt(sc.nextLine());
            switch(ch){
                case 1->viewAll();
                case 2->rentVehicle();
                case 3->returnVehicle();
                case 4->prevHistory();
                case 5->{
                    current=null;
                    return;
                }
                default->{
                    System.out.println("Invalid Choice");
                }
            }
		}
	}
    public static void rentVehicle() {
        User u = user.get(current);
        System.out.println("Enter vehicle ID to rent:");
        String id = sc.nextLine();
        if (!vehicle.containsKey(id)) {
            System.out.println("Vehicle not found!");
            return;
        }
        Vehicle v = vehicle.get(id);
        if (v.count <= 0) {
            System.out.println("Vehicle unavailable!");
            return;
        }
        if (!v.serviced) {
            System.out.println("This vehicle is due for service and cannot be rented.");
            return;
        }
        boolean hasCar = false, hasBike = false;
        for (String vid : u.rentedVehicle) {
            Vehicle rv = vehicle.get(vid);
            if (rv.type.equalsIgnoreCase("car")) hasCar = true;
            if (rv.type.equalsIgnoreCase("bike")) hasBike = true;
        }
        if ((v.type.equalsIgnoreCase("car") && hasCar) ||
            (v.type.equalsIgnoreCase("bike") && hasBike)) {
            System.out.println("You have already rented a " + v.type + ". Cannot rent another.");
            return;
        }
        if (v.type.equalsIgnoreCase("car") && u.deposit < 10000) {
            System.out.println("Insufficient deposit. ₹10,000 required to rent a car.");
            return;
        }
        if (v.type.equalsIgnoreCase("bike") && u.deposit < 3000) {
            System.out.println("Insufficient deposit. ₹3,000 required to rent a bike.");
            return;
        }
        u.rentedVehicle.add(id);
        v.count--;
        v.isRented = true;
        System.out.println("Vehicle rented successfully!");
    }

	public static void returnVehicle() {
		User u=user.get(current);
		if(u.rentedVehicle.isEmpty()) {
			System.out.println("No vehicle to return!");
			return;
		}
		for(String id:u.rentedVehicle) {
			System.out.println("Enter the KM driven:");
			double km=Double.parseDouble(sc.nextLine());
			Vehicle v=vehicle.get(id);
			double total=v.rentPrice;
			if(km>500) {
				total+=v.rentPrice*0.15;
			}
			
			System.out.println("Damage Level (none/low/medium/high):");
			String damage=sc.nextLine();
			
			if(damage.equalsIgnoreCase("low")) {
				total+=v.rentPrice*0.2;
			}
			else if(damage.equalsIgnoreCase("medium")) {
				total+=v.rentPrice*0.5;
			}
			else if(damage.equalsIgnoreCase("high")) {
				total+=v.rentPrice*0.75;
			}
			
			u.deposit-=total;
			v.km+=km;
			v.count++;
		}
		u.rentedVehicle.clear();
		System.out.println("Vehicle returned!");
	}
	
	public static void prevHistory() {
		User u=user.get(current);
		System.out.println("Enter rental history:");
		
		for(String id:u.rentedVehicle) {
			System.out.println(id+"->"+vehicle.get(id).name);
		}
	}
	
	public static void viewReport() {
		System.out.println("Vehicle report of KM driven:");
		for(Vehicle v:vehicle.values()) {
			System.out.println(v.id+"->"+v.name+"->"+v.km);
		}
	}

}
