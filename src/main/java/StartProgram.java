

import java.util.List;
import java.util.Scanner;

import controller.StoreHelper;
import controller.TicketHelper;
import model.Store;
import model.Ticket;

public class StartProgram {		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			TicketHelper lih = new TicketHelper();
			//Ticket test = new Ticket("1356","My store is completly testing",false);
			
			//lih.insertTicket(test);
			
			//Store testerStore = new Store("1356","AMES","655 Cane Street","515-555-5556");
			//StoreHelper sh = new StoreHelper();
			
			//sh.insertStore(testerStore);
			List<Ticket> alltickets = lih.showAllTickets();
			for(Ticket t : alltickets) {
				System.out.println(t.toString());
			}
			
			System.out.println("task completed.");
		}
		
}
