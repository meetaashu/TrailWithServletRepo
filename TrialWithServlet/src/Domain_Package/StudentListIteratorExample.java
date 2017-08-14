package Domain_Package;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StudentListIteratorExample {

	public static void main(String[] args){
		
		stuListIteratorEx s1=new stuListIteratorEx("A", 12, 2, "23233", "sfsd");
		stuListIteratorEx s2=new stuListIteratorEx("B", 12, 2, "23233", "sfsd");
		
//		List<stuListIteratorEx> ls=new LinkedList<stuListIteratorEx>();
//		ls.add(s1);
//		ls.add(s2);
//		
//		LinkedHashSet<stuListIteratorEx> ls= new LinkedHashSet<stuListIteratorEx>();
//		Iterator<stuListIteratorEx> itr=ls.iterator();
		
		Map<Integer,stuListIteratorEx> m=new HashMap<Integer,stuListIteratorEx>();
		
		m.put(1, s1);
		m.put(2, s2);
		// m.entrySet() returns set of Entry which has method getKey() and getValue()
		// so here we will get set of entries then iterate over it to get 1st ( and then 2nd entry) and then use getKey to 
		//get key from that entry and they use map.get ( key) to fetch value corresponding to that key
		Set s=m.entrySet();
		
		Iterator<stuListIteratorEx> itr= s.iterator();
		while(itr.hasNext()){
			Entry entry= (Entry)itr.next();
		//System.out.println("details:"+st);
		//System.out.println("Details are:"+st.getName()+" "+st.getRollNo()+" "+st.getStandard());
		//Object as received from map
		stuListIteratorEx stu= m.get(entry.getKey());
		// use this stu to pring all values inside it :):)
	System.out.println("Student list is:"+stu.getName()+""+stu.getRollNo()+""+stu.getCity());
		}
		
	}
}
