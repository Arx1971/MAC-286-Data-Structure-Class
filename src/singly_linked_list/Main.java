package singly_linked_list;

public class Main {
	public static void main(String args[]) {
		
		Generics_Linked_List<Integer> list = new Generics_Linked_List<>();
		System.out.println(list.isempty());
		list.addnewData(10);
		list.addnewData(20);
		list.addnewData(30);
		list.addnewData(40);
		list.addnewData(50);
		list.addnewData(60);
		list.addnewData(70);
		list.addnewData(80);
		list.addnewData(90);
		list.addnewData(100);
		list.addnewData(110);
		list.display();
		list.remove();
		list.display();
		list.remove();
		list.remove();
		System.out.println(list.isempty());
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		
		list.remove();
		list.remove();
		list.remove();
		list.display();
		System.out.println(list.isempty());
		
		Generics_Linked_List<String> stringLIst = new Generics_Linked_List<>();
		System.out.println(stringLIst.isempty());
		
		stringLIst.addnewData("Megatron");
		stringLIst.addnewData("Optimus Prime");
		stringLIst.addnewData("Vector Prime");
		stringLIst.addnewData("Iron Hide");
		stringLIst.addnewData("Bumbble Bee");
		
		stringLIst.display();
		stringLIst.middleelements();
	}
}






























