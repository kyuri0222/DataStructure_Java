import java.util.NoSuchElementException;

public class ArrList <E>{
    private E a[];
	private int size;

    public ArrList(){
        a = (E[]) new Object[1];
        size = 0;
    }

    //k번째 리턴, 단순 읽기만 
    public E peek(int k){
        if(isEmpty()) 
        	throw new NoSuchElementException();
        return a[k];
    }
    
    public boolean isEmpty() {
    	return size ==0;
    }
    
    public void insertLast(E newItem){ // 마지막원소로 삽입 
        if(size == a.length) // 꽉차면 
        	resize(2*a.length); // 2배로 늘려 
        a[size++] = newItem; // 새항목 삽입 
    }
    
    public void insert(E newItem, int k){ // k-1번 다음에 항목 삽입 
        if(size == a.length)  // 꽉차면 
        	resize(2*a.length); // 2배로 늘려 
        for(int i=size-1 ; i >= k; i--) // 뒤에서부터 한칸씩 뒤로 이동 
        	a[i+1] = a[i];
        a[k] = newItem;
        size++;
    }
    
    public void resize(int newSize){ // 배열 크기 조정 
	    Object [] t = new Object[newSize]; // 새로운 배열 t 
	    for(int i = 0; i < size; i++)  // s를 t로 복사 
	    	t[i] = a[i];
	    a = (E[])t;  //t를 s로 
    }

    public E delete(int k){ // k번째 삭제 
        if(isEmpty())
        	throw new NoSuchElementException(); 
        E item = a[k];    
        for(int i = k; i < size-1; i++) // 한칸씩 앞으로 이동 
        	a[i] = a[i+1];    
        size--;    
        if(size > 0 && size == a.length/4) // 전체의 1/4이면 
        	resize(a.length/2);    // 전체의 1/2로 축소 
        return item;
    }
    
	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}