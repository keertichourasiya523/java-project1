package demoEmployee;

import java.io.Serializable;

public class empl implements Serializable {
	 int empno;
	 String ename;
	 int  salary;
	 
	 empl(int empno, String ename, int salary ){
		 this.empno=empno;
		 this.ename=ename;
		 this.salary=salary;
	 }
	 public String toString() {
		 return empno+" "+ename+" "+salary;
		 
	 }
	}