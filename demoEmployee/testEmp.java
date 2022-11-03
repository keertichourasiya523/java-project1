package demoEmployee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class testEmp {
	public static void main(String[] args) throws Exception {
		int choice = -1;
		
		Scanner s= new Scanner(System.in);
		Scanner s1= new Scanner(System.in);
		File file = new File("employee.txt");
		ArrayList<empl>al= new ArrayList<empl>();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;
		
		if(file.isFile()) {
			ois= new ObjectInputStream(new FileInputStream(file));
			al=(ArrayList<empl>)ois.readObject();
			ois.close();
		}
		
		do {
		System.out.println("1. INSERT");
		System.out.println("2. DISPLAY");
		System.out.println("3.SEARCH");
		System.out.println("4.DELETE");
		System.out.println("5.UPDATE");
		System.out.println("6.SORT By EmpNo - On screen");
		System.out.println("7.SORT By EmpNo - In File");
		System.out.println("0. EXIT");
		System.out.println("Enter your choice : ");
	    choice = s.nextInt();
	    
		switch (choice) {
		case 1:
			System.out.println("how many employees you want : ");
		int n = s.nextInt();
		for (int i=0; i<n; i++){
			
			System.out.print("enter employee No. : ");
			int empno = s.nextInt();
			
			System.out.print("enter employee name : ");
			String ename = s1.nextLine();
			
			System.out.print("enter employee salary : ");
			int salary = s.nextInt();
			
			al.add(new empl( empno,ename,salary));

		}
		oos=new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(al);
		oos.close();
		break;
		
		case 2:
			if(file.isFile()) {
				ois= new ObjectInputStream(new FileInputStream(file));
				al=(ArrayList<empl>)ois.readObject();
				ois.close();

			System.out.println("--------------------------------------------------------");
			li=al.listIterator();
			
			while(li.hasNext())
				System.out.println(li.next());
			System.out.println("--------------------------------------------------------");
			}else {
				System.out.println("File not Exists...!");
			}
			break;
		
		case 3:
			
			if(file.isFile()) {
				ois= new ObjectInputStream(new FileInputStream(file));
				al=(ArrayList<empl>)ois.readObject();
				ois.close();

				boolean found = false;
				System.out.println("enter employee no. to search : ");
			int	empno = s.nextInt();
				System.out.println("--------------------------------------------------------");
			li=al.listIterator();
			
			while(li.hasNext()) {
				empl e= (empl)li.next();
				if(e.empno ==empno) {
				
				System.out.println(e);
				found = true;
				}
			}if(!found)
				System.out.println("Record not found...!");
			System.out.println("--------------------------------------------------------");
			}else {
				System.out.println("File not Exists...!");
			}
			break;
			
			
	case 4:
			
			if(file.isFile()) {
				ois= new ObjectInputStream(new FileInputStream(file));
				al=(ArrayList<empl>)ois.readObject();
				ois.close();

				boolean found = false;
				System.out.print("enter employee no. to delete : ");
			int	empno = s.nextInt();
				System.out.println("--------------------------------------------------------");
			li=al.listIterator();
			
			while(li.hasNext()) {
				empl e= (empl)li.next();
				if(e.empno ==empno) {
				
				li.remove();
				found = true;
				}
			}if(found) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
		
			System.out.println("Record deleted successfully....!");
			}
			else {
				System.out.println("Record not found...!");
			}
			System.out.println("--------------------------------------------------------");
			}else {
				System.out.println("File not Exists...!");
			}
			break;
		
	case 5:
			
			if(file.isFile()) {
				ois= new ObjectInputStream(new FileInputStream(file));
				al=(ArrayList<empl>)ois.readObject();
				ois.close();

				boolean found = false;
				System.out.print("enter employee no. to Update : ");
			int	empno = s.nextInt();
				System.out.println("--------------------------------------------------------");
			li=al.listIterator();
			
			while(li.hasNext()) {
				empl e= (empl)li.next();
				if(e.empno ==empno) {
				
	           System.out.print("Enter new name : ");
	           String ename = s1.nextLine();
	           
	           System.out.print("Enter new salary : ");
	          int salary = s.nextInt();
	          
	          li.set(new empl(empno,ename,salary));
	           found = true;
				}
			}if(found) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
			    oos.writeObject(al);
			    oos.close();
			System.out.println("Record is updated successfully...!");
			}else {
				System.out.println("Record not found...!");

			}
			System.out.println("--------------------------------------------------------");
			}else {
				System.out.println("File not Exists...!");
			}
			break;
			
	case 6:
		if(file.isFile()) {
			ois= new ObjectInputStream(new FileInputStream(file));
			al=(ArrayList<empl>)ois.readObject();
			ois.close();

			Collections.sort(al,new Comparator<empl>() {
				public int compare(empl e1,empl e2) {
					return e1.empno-e2.empno;
				}
			});
		System.out.println("--------------------------------------------------------");
		li=al.listIterator();
		
		while(li.hasNext())
			System.out.println(li.next());
		System.out.println("--------------------------------------------------------");
		}else {
			System.out.println("File not Exists...!");
		}
		break;
	
	case 7:
		if(file.isFile()) {
			ois= new ObjectInputStream(new FileInputStream(file));
			al=(ArrayList<empl>)ois.readObject();
			ois.close();

			Collections.sort(al,new Comparator<empl>() {
				public int compare(empl e1,empl e2) {
					return e1.empno-e2.empno;
				}
			});
			
			oos= new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
			
		System.out.println("--------------------------------------------------------");
		li=al.listIterator();
		
		while(li.hasNext())
			System.out.println(li.next());
		System.out.println("--------------------------------------------------------");
		}else {
			System.out.println("File not Exists...!");
		}
		break;
		}
		}
			
		
		while(choice!=0); 
	}
}








